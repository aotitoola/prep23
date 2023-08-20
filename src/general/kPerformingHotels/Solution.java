package general.kPerformingHotels;

import java.util.*;
import java.util.stream.Collectors;

// Problem Statement: https://leetcode.com/discuss/interview-question/1431676/Booking.com-Award-Top-K-Hotels-OA-HackerRank
public class Solution {

    public static void main(String[] args) {

        String positiveKeywords = "breakfast beach city center location metro view staff price";
        String negativeKeywords = "not";

        // both hotelIds and reviews are 1 to 1 mapped
        int[] hotelIds = {1,2,1,1,2};
        String[] reviews = {
                "This hotel has a nice view of the city center. The location is perfect.",
                "The breakfast is ok. Regarding location, it is quite far from city center but the price is cheap so it is worth.",
                "Location is excellent, 5 minutes from the city center. There is also a metro station very close to the hotel.",
                "They said I couldn’t take my dog and there were other guests with dogs! That is not fair.",
                "Very friendly staff and a good cost-benefit ratio. Its location is a bit far from the city center."
        };


        // k : the number of hotels we want to award.
        int k;

        List<Integer> hotelIdsList = Arrays.stream(hotelIds).boxed().toList();
        List<Integer> answer = awardTopKHotels(positiveKeywords, negativeKeywords, hotelIdsList, List.of(reviews), 2);

        System.out.println(answer);
    }

    // should return a list of the top k hotels in non-decreasing order
    public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds,
                                                List<String> reviews, int k) {

        // create a set of positive and negative words from the supplied String
        Set<String> positiveWords = new HashSet<>(Arrays.asList(positiveKeywords.split(" ")));
        Set<String> negativeWords = new HashSet<>(Arrays.asList(negativeKeywords.split(" ")));

        positiveWords = positiveWords.stream().map(String::toLowerCase).collect(Collectors.toSet());
        negativeWords = negativeWords.stream().map(String::toLowerCase).collect(Collectors.toSet());

        // create a map to keep the scores
        Map<Integer, Integer> scores = new HashMap<>();

        // O(N^2)
        for (int i = 0; i < reviews.size(); i++) {
            int hotelId = hotelIds.get(i);

            // collect each review as a list of strings
            // we are not using a set here because, we are allowing more than one occurrence of a word
            List<String> currentReview = Arrays.asList(reviews.get(i).split(" "));

            // create a counter for the positive and the negatives
            int posCount = 0, negCount = 0;

            // remove dots and commas, and convert to lowercase
            currentReview = currentReview.stream().map(r -> {
                r = r.replace(".", "");
                r = r.replace(",", "");
                r = r.toLowerCase();
                return  r;
            }).toList();

            // for each string in currentReview, check if positive or negative
            for (String rev : currentReview) {
                if (positiveWords.contains(rev)) posCount++;
                if (negativeWords.contains(rev)) negCount++;
            }

            scores.put(hotelId, scores.getOrDefault(hotelId, 0) + 3 * (posCount - negCount));
        }


        // initialise a stack to sort the scores
        // if the score values are the same, sort by the hotel id
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ?  b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );

        // let's add elements from the map into the queue and sort accordingly
        for (Map.Entry<Integer, Integer> entry: scores.entrySet()) {

            pq.offer(entry);

            // after sorting, remove the element at the head of the queue (stack) LIFO
            if (pq.size() > k) pq.poll();
        }

        // next we populate the final results
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            // add it from the beginning of the array
            res.add(0, pq.poll().getKey());
        }

        return res;
    }
}
