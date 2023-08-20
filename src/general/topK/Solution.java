package general.topK;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    // There is a list of hotels & they were given in below format:
    // {hotel_id, parent_hotel_id, no_of_hotel}

    // multi-level hotel hierarchy exits in the system.
    // example:

    /*
        [
            {3, 0, 14},
            {0, null, 10},
            {4, 0, 44},
            {6, null, 7},
            {10, 6, 13},
            {7, 6, 17},
            {2, null, 2},
            {14, 2, 9},
            {25, 14, 10},
            {12, 2, 10},
            {13, 0, 1},
            {14, 2, 9}
        ]
     */

    // Here null represent the top level of the hotel. We want to know top k hotel chains.
    // o/p: if k = 2: {(0,69), (2,56)}

    public static void main(String[] args) {

        // input
        List<int[]> input = new ArrayList<>();
        input.add(new int[]{ 3,0,14});
        input.add(new int[]{0, -1, 10});
        input.add(new int[]{4,0,44});
        input.add(new int[]{6, -1, 7});
        input.add(new int[]{10, 6, 13});
        input.add(new int[]{7, 6, 17});
        input.add(new int[]{2, -1, 2});
        input.add(new int[]{25, 14, 10});
        input.add(new int[]{12, 2, 10});
        input.add(new int[]{13, 0, 1});
        input.add(new int[]{14, 2, 9});



    }

}
