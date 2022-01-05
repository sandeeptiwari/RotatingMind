package com.rottaingmind.ds.stack.dijkstra;

public class App {

    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        String expression = "((3+4) + (5*3))";
        algorithm.interpretExpression(expression);
        algorithm.result();
    }
}
