package com.rottaingmind.ds.dp;

public class SolvingQuestionsWithBrainpower2140 {

    public long mostPoints(int[][] questions) {
        int n = questions.length;
        return mostPoints(questions, 0);
    }

    private long mostPoints(int[][] questions, int i) {
        if (i >= questions.length) return 0; // Base case: out of bounds

        // Option 1: Take the current question and move to i + cooldown + 1
        long take = questions[i][0] + mostPoints(questions, i + questions[i][1] + 1);

        // Option 2: Skip the current question
        long skip = mostPoints(questions, i + 1);

        // Return max of both options
        return Math.max(take, skip);
    }

    public static void main(String[] args) {
        SolvingQuestionsWithBrainpower2140 obj = new SolvingQuestionsWithBrainpower2140();
        int[][] test1 = {{3,2}, {4,3}, {4,4}, {2,5}};
        int[][] test2 = {{2,1}, {3,2}, {5,3}, {7,1}, {1,4}, {9,2}};

        System.out.println("Test Case 1: " + obj.mostPoints(test1)); // Expected Output: 5
        System.out.println("Test Case 2: " + obj.mostPoints(test2)); // Expected Output: 12
    }

}
