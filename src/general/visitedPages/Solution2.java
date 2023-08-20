package general.visitedPages;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


// Question: https://leetcode.com/discuss/interview-question/125297/Booking-or-Most-popular-sequence-of-3-consecutive-visited-pages


public class Solution2 {

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
    Solution 2:
    Create a Map with key as userId and value as string which all pages visited in order .. TC : O(n)
    Create another Map with key as all substrings of size 3, and value as frequency of each substring.. O(n*k)
    Find max frequency from map.. O(n)

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


        Map<Integer, String> userMap = new HashMap<>();

        // collect the website info for every user, key: username, value: page
        for (UserPage page: pageVisits) {

            if (userMap.containsKey(page.getUser())) {

                String visited = userMap.get(page.getUser());
                int len = visited.length();

                if (!visited.isEmpty() && !(visited.charAt(len - 1) == page.getPage())) {
                    userMap.put(page.getUser(), visited +  page.getPage());
                }

            } else {
                userMap.put(page.getUser(), String.valueOf(page.getPage()));
            }
        }



        List<String> visitedPages = userMap.values().stream().toList();

        Map<String, Integer> freqMap = new HashMap<>();

        for (String pages : visitedPages) {

            char[] pageArray = pages.toCharArray();

            int l = 0;
            int r = l + 3;

            while (r <= pageArray.length) {

                String subStr = pages.substring(l, r);
                freqMap.put(subStr, freqMap.getOrDefault(subStr, 0) + 1);

                l++;
                r++;
            }
        }

        System.out.println(freqMap);

    }





}
