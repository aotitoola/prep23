package general.streamAggregation;

import java.util.*;
import java.util.stream.Collectors;


// Question Link: https://leetcode.com/discuss/interview-question/1010630/Booking.com
public class Solution {

    public static void main(String[] args) {

        List<Hotel> streamInput = new ArrayList<>();
        streamInput.add(new Hotel(23, "IT", "user1", true));
        streamInput.add(new Hotel(23, "IT", "user2", true));
        streamInput.add(new Hotel(23, "IT", "user1", true));
        streamInput.add(new Hotel(23, "IT", "user4", false));
        streamInput.add(new Hotel(42, "IT", "user3", false));
        streamInput.add(new Hotel(42, "IT", "user4", true));
        streamInput.add(new Hotel(42, "IT", "user5", true));
        streamInput.add(new Hotel(88, "FR", "user1", true));

        // Expected result
        // { hotel_area_code: "IT", hotel_id: 23, views: 3 }
        // { hotel_area_code: "FR", hotel_id: 88, views: 1 }

        List<FilterResult> output = streamInput.stream()
                // filter out users not logged in
                .filter(Hotel::isUser_logged_in)
                // map this stream to a new Filter result (what the output should look like)
                .map( x -> {
                    // views here is useless
                    return new FilterResult(x.getHotel_area_code(), x.getHotelId(), 1);
                })
                // Collectors.groupingBy returns a map with key as the grouping field, and value as the list of objects
                .collect(
                        Collectors.groupingBy(FilterResult::getHotel_area_code))
                // get access to the entry set with contains hotelId as key and hotels as values
                .entrySet()
                .stream()
                // using a collect because you can't construct new Map.Entry in a map() call so the work is mixed into the collect() call.
                // this block is to then filter by the hotelID
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> {

                            List<FilterResult> curr = entry.getValue();
                            Map<Long, Long> counter = curr.stream().collect(Collectors.groupingBy(FilterResult::getHotelId, Collectors.counting()));

                            long hotelId = counter
                                    .entrySet()
                                    .stream()
                                    .max(Map.Entry.comparingByValue())
                                    .map(Map.Entry::getKey)
                                    .orElse(0L);

                            // use removeIf from list
                            curr.removeIf(x -> x.getHotelId() != hotelId);
                            return curr;
                        }
                ))
                .entrySet()
                .stream()
                // stream again and map it
                .map( entry -> {

                    String areaCode = entry.getKey();
                    long hotelId = entry.getValue().get(0).getHotelId();
                    int views = entry.getValue().size();

                    return new FilterResult(areaCode, hotelId, views);

                })
                .sorted(Comparator.comparing(FilterResult::getViews).reversed())
                .peek(System.out::println)
                .toList();
    }
}
