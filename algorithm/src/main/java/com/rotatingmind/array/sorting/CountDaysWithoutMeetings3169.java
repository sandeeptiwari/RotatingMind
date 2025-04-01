package com.rotatingmind.array.sorting;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1).
 * You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).
 *
 * Return the count of days when the employee is available for work but no meetings are scheduled.
 *
 * Note: The meetings may overlap.
 *
 *
 *
 * Example 1:
 *
 * Input: days = 10, meetings = [[5,7],[1,3],[9,10]]
 *
 * Output: 2
 *
 * Explanation:
 *
 * There is no meeting scheduled on the 4th and 8th days.
 *
 * Example 2:
 *
 * Input: days = 5, meetings = [[2,4],[1,3]]
 *
 * Output: 1
 *
 * Explanation:
 *
 * There is no meeting scheduled on the 5th day.
 */

record Meeting1(int start, int end) {}

class Meeting {
    private int start, end;
    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

public class CountDaysWithoutMeetings3169 {

    /**
     * [1, 2, 3, F, 5, 6, 7, F, 9, 10]
     * meetings = [[5,7],[1,3],[9,10]]
     * 1. [1,3],[5,7],[9,10]
     * TLE
     */
    public int countDays(int days, int[][] meetings) {
      int[] avaliable = new int[days];
      Arrays.fill(avaliable, 0);
      int n = meetings.length;

        for (int i = 0; i < n; i++) {
            markAttendance(avaliable, meetings[i][0] -1, meetings[i][1]);
        }

        return (int)Arrays.stream(avaliable).boxed().filter(ele -> ele != 1).count();
    }

    private void markAttendance(int[] avaliable, int start, int end) {
        for (int i = start; i < end; i++) {
            avaliable[i] = 1;
        }
    }

    /**
     * [1, 2, 3, F, 5, 6, 7, F, 9, 10]
     * meetings = [[5,7],[1,3],[9,10]]
     * 1. [1,3],[6,7],[9,10]
     */
    public int countDaysV1(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int result = 0;
        int lastmeet = 0;
        for(int[] meet : meetings) {
            if(lastmeet < meet[0])
                result+= meet[0] - lastmeet - 1;
            lastmeet = lastmeet > meet[1] ? lastmeet : meet[1];
        }
        if(lastmeet <= days)
            result += days - lastmeet;

        return result;
    }


    public static void main(String[] args) {
        CountDaysWithoutMeetings3169 obj = new CountDaysWithoutMeetings3169();
        int days = 10;
        //int[][] meetings = {{5,7},{1,3},{9,10}};
        int[][] meetings = {{3,49},{23,44},{21,56},{26,55},{23,52},{2,9},{1,48},{3,31}};
        int result = obj.countDaysV1(days, meetings);
        System.out.println("Result:: " + result);
    }

}
