package general;

import general.streamAggregation.Hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaSyntax {

    public static void main(String[] args) {

        // set up sample collection
        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel(23, "IT", "user1", true));
        hotels.add(new Hotel(23, "IT", "user2", true));
        hotels.add(new Hotel(23, "IT", "user1", true));
        hotels.add(new Hotel(42, "IT", "user3", false));
        hotels.add(new Hotel(88, "FR", "user1", true));


        // CREATING A STREAM

        // create an empty stream
        Stream<String> streamEmpty = Stream.empty();

        // create from collection
        Stream<Hotel> hotelStream = hotels.stream();

        // create from array
        Stream<String> streamOfArray = Stream.of("a", "b", "c");

        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamPartOfArray = Arrays.stream(arr, 1, 3);


        // Intermediate Operations
        // FILTER

        // using lambda expression
        List<Hotel> filterHotels1 = hotels
                .stream()
                .filter(h -> h.isUser_logged_in())
                .collect(Collectors.toList());

        // using method reference
        List<Hotel> filterHotels2 = hotels
                .stream()
                .filter(Hotel::isUser_logged_in)
                .toList();

        // handling exceptions
        List<Hotel> filterHotels3 = hotels
                .stream()
                .filter(h ->
                        {
                            try {
                                return h.isUser_logged_in();
                            } catch (Exception e) {
                                //handle exception
                            }
                            return false;
                        }
                )
                .toList();

        // make sure you call terminal operation after intermediate operations and not the other way around
        List<String> elements = Stream.of("a", "b", "c").filter(element -> element.contains("b"))
                        .toList();
        Optional<String> anyElement = elements.stream().findAny();
        Optional<String> firstElement = elements.stream().findFirst();

        // source, intermediate operation(s) and a terminal operation.
        // skip first element of a stream - Intermediate
        Stream<String> onceModifiedStream =
                Stream.of("abcd", "bbcd", "cbcd").skip(1)
                        // substitute every element in the stream with a different element (same or different type)
                        .map(element -> element.substring(0, 3))
                        .sorted();

        long size = onceModifiedStream.count();


    }




}
