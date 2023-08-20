package general.hotels;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        // Initialise input data
        Map<Integer, List<Room>> roomsMap = new HashMap<>();

        List<Room> day1 = new ArrayList<>();
        day1.add(new Room(120, new HashSet<>(List.of("breakfast", "refundable")), 2));

        List<Room> day2 = new ArrayList<>();
        day2.add(new Room(130, new HashSet<>(List.of("breakfast")), 1));
        day2.add(new Room(140, new HashSet<>(List.of("breakfast", "refundable")), 3));

        List<Room> day3 = new ArrayList<>();
        day3.add(new Room(130, new HashSet<>(List.of("breakfast")), 2));
        day3.add(new Room(140, new HashSet<>(List.of("breakfast", "refundable", "wifi")), 10));

        roomsMap.put(176, day1);
        roomsMap.put(177, day2);
        roomsMap.put(178, day3);


        // Request
        Request request = new Request(176, 178, new HashSet<>(List.of("breakfast")), 1);
        searchAvailableRooms(roomsMap, request);

        //


    }

    public static List<List<Room>> searchAvailableRooms(Map<Integer, List<Room>> roomsMap, Request request){

        List<List<Room>> possibleRooms = new ArrayList<>();

        for (int today = request.getCheckIn(); today <  request.getCheckOut(); today++) {
            List<Room> availToday = roomsMap.get(today);

            // filter rooms based on request
            availToday = availToday.stream().filter(
                     a -> a.getFeatures().containsAll(request.getFeatures())
                        && a.getAvailability() >= request.getRooms()
            ).toList();


            if (!availToday.isEmpty()) {
                possibleRooms.add(availToday);
            }
        }

        System.out.println("-------------------");
        possibleRooms.forEach(System.out::println);

        return possibleRooms;
    }


    public static List<Room> combineOutputs(List<List<Room>> outputs) {

        // STOPPED!! because I need to find all the possible combinations
        outputs.stream().reduce(new ArrayList<Room>(),
                (acc, r) -> {
                    int price = 0;
                    Set<String> features = new HashSet<>();
                    int availability = 0;

                    r.forEach(x -> {
                  //      price += x.getPrice();
                    });
                 //   acc.add()
                    return acc;
                });


            return null;

    }

//    public static boolean validateFeatures(Set<String> available, Set<String> required) {
//        System.out.println("avail " + available);
//        System.out.println("required " + required);
//
//        boolean res = available.containsAll(required);
//        System.out.println(res);
//        return res;
//    }
}
