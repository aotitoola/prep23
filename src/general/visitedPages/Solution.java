package general.visitedPages;

import java.util.*;


// Question: https://leetcode.com/discuss/interview-question/125297/Booking-or-Most-popular-sequence-of-3-consecutive-visited-pages
public class Solution {

/*  Question:
    Given log = [
    { 'user': '1', 'page': 'A'},
    { 'user': '2 ', 'page': 'B'},
    { 'user': '1', 'page': 'B'},
    { 'user': '1', 'page': 'D'},
    { 'user': '2', 'page': 'A'},
    { 'user': '3', 'page': 'B'},
    { 'user': '3', 'page': 'D'},
    { 'user': '1', 'page': 'C'},
    { 'user': '3', 'page': 'C'},
    { 'user': '1', 'page': 'C'},
    { 'user': '2', 'page': 'C'},
    { 'user': '3', 'page': 'B'},
    { 'user': '1', 'page': 'A'},
    { 'user': '3', 'page': 'C'},
    ]

    We need to find the sequence of pages of length 3, that is the most popular.
    ex:
    user 1 visits: A, B, D, C, A
    user 2 visits: B, A, C
    user 3 visits: B, D, C, B, C

    Possible consecutive sequences: ABD, BDC, DCA, BAC, DCB, CBC

    The most popular is BDC, since user 1 and user 3 visit that sequence

    Time complexity: ?
    Memory complexity: ?

    */




/*
    Solution 1:

    - we collect the time and website info according to every user
    - n^3 traverse all 3-seq in every user and use count map to record the 3-seq occurring times(remember to sort by time and avoid same sequence in the same user)
    - get the result

    */


    public static void main(String[] args) {

        // set up the input
        // use a linkedList to keep the sequence
        List<UserPage> pageVisits = new LinkedList<>();
        pageVisits.add(new UserPage(1, 'A'));
        pageVisits.add(new UserPage(2, 'B'));
        pageVisits.add(new UserPage(1, 'B'));
        pageVisits.add(new UserPage(1, 'D'));
        pageVisits.add(new UserPage(2, 'A'));
        pageVisits.add(new UserPage(3, 'B'));
        pageVisits.add(new UserPage(3, 'D'));
        pageVisits.add(new UserPage(1, 'C'));
        pageVisits.add(new UserPage(3, 'C'));
        pageVisits.add(new UserPage(1, 'C'));
        pageVisits.add(new UserPage(2, 'C'));
        pageVisits.add(new UserPage(3, 'B'));
        pageVisits.add(new UserPage(1, 'A'));
        pageVisits.add(new UserPage(3, 'C'));


        Map<Integer, LinkedList<Character>> userMap = new HashMap<>();

        // collect the website info for every user, key: username, value: page
        for (UserPage page: pageVisits) {

            if (userMap.containsKey(page.getUser())) {
                LinkedList<Character> pages = userMap.get(page.getUser());

                if (!pages.isEmpty() && !pages.peekLast().equals(page.getPage())) {
                    pages.add(page.getPage());
                }

            } else {
                LinkedList<Character> newList = new LinkedList<>();
                newList.add(page.getPage());
                userMap.put(page.getUser(), newList);
            }
        }

        // count map to record every 3 combination occurring time for the different user.
        // LinkedList<Character> values = userMap.values();

        // BRUTE FORCE
        Map<String, Integer> counter = new HashMap<>();

        for (LinkedList<Character> values: userMap.values()) {

            int n = values.size();

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {

                        String current = String.valueOf(values.get(i))  + String.valueOf(values.get(j)) + String.valueOf(values.get(k));
                        System.out.println(current);

                        counter.put(current, counter.getOrDefault(current, 0) + 1);
                    }
                }
            }
        }


        //counter.


        //System.out.println(counter);
    }





}
