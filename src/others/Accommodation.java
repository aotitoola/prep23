package others;

import java.util.*;

public class Accommodation {

    public static void main(String[] args) {

        // given these input data
        int checkInDate = 178;
        int checkoutDate = 180;

        Set<String> requestedFeatures = new HashSet<>();
        requestedFeatures.add("wifi");

        // Initialise input data map
        // key = day, value = available rooms for that day
        Map<Integer, List<Room>> rooms = new HashMap<>();
        rooms.put(178, Arrays.asList(
                new Room(4, 120, new HashSet<>(List.of("breakfast"))),
                new Room( 5, 280, new HashSet<>(Arrays.asList("breakfast", "refundable", "wifi")))
        ));

        rooms.put(179, Arrays.asList(
                new Room(1, 140, new HashSet<>(Arrays.asList("breakfast", "refundable"))),
                new Room( 3, 180, new HashSet<>(Arrays.asList("breakfast", "wifi"))),
                new Room( 10, 280, new HashSet<>(Arrays.asList("breakfast", "refundable", "wifi")))
        ));

        rooms.put(180, Arrays.asList(
                new Room(8, 120, new HashSet<>(List.of("breakfast"))),
                new Room( 1, 160, new HashSet<>(Arrays.asList("breakfast", "wifi")))
        ));


        // Solve the problem
        List<Room> ans = findAvailableRooms(checkInDate, checkoutDate, requestedFeatures, rooms);
        // print the rooms found
        for(Room room: ans){
            System.out.println(room);
        }
    }

    static boolean present(Set<String> features, Set<String> roomFeatures){
        boolean present = true;
        for(String f: features){
            if (!roomFeatures.contains(f)) {
                present = false;
                break;
            }
        }
        return present;
    }

    static Set<String> intersection(Set<String> features, Set<String> processed){
        Set<String> common = new HashSet<>();
        for(String p: processed){
            if(features.contains(p)){
                common.add(p);
            }
        }
        return common;
    }

    static List<Room> findAvailableRooms(int checkInDate, int checkoutDate, Set<String> features, Map<Integer, List<Room>> rooms){

        if(checkInDate == checkoutDate) return new ArrayList<Room>();
        List<Room> curr = findAvailableRooms(checkInDate + 1, checkoutDate, features, rooms);

        List<Room> ans = new ArrayList<>();

        for(Room room: rooms.get(checkInDate)){
            if(present(features, room.features)){

                if(curr.isEmpty()){
                    ans.add(room);
                    continue;
                }

                for(Room processed: curr){
                    ans.add(new Room(Math.min(processed.availability, room.availability), processed.price + room.price, intersection(room.features, processed.features)));
                }

            }
        }

        return ans;
    }
}

class Room {
    Integer availability;
    Integer price;
    Set<String> features;

    public Room() {
    }

    public Room(Integer availability, Integer price, Set<String> features) {
        this.availability = availability;
        this.price = price;
        this.features = features;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Room.class.getSimpleName() + "[", "]").add("availability=" + availability)
                .add("price=" + price).add("features=" + features).toString();
    }
}
