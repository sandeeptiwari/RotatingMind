package session_7;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8Demo {

    public static void main(String[] args) {
        //We have list of movies, which has more that 4.5 rating & group them by its category
        //Map<Category, List<Movie>> moviewByCategory = new HashMap<>();
        //{["Comedy"] -> List("3 idiot", "Bhool Bholaiya"),
        // ["Crime"] -> List("Gangs Of wasseypur")}
        //Category category = new Category("Comedy");
        Movie movie = new Movie("3 idiot",4.6, "Comedy");

        //Category category1 = new Category("Drama");
        Movie movie1 = new Movie("Pursuiate of happiness",4.4, "Drama");

       // Category category2 = new Category("Comedy");
        Movie movie2 = new Movie("Bhool Bholaiya",4.7, "Comedy");

       // Category category3= new Category("Crime");
        Movie movie3 = new Movie("Gangs Of wasseypur",4.5, "Crime");

        List<Movie> movies = List.of(movie, movie1, movie2, movie3);
       // System.out.println(movieByCategory(movies)); // before java 8


        //Set<String> set = new TreeSet<String>((o1, o2) -> 0);

        Predicate<Movie> isGreaterThanOrEqual4_5 = m -> m.getRating() >= 4.5;

        Map<String, List<Movie>> collect =
                movies.stream()
                        .filter(isGreaterThanOrEqual4_5)
                        .collect(Collectors.groupingBy(m1 -> m1.getCategory()));
       // System.out.println(collect);
        /**
         *  parameter -> expression
         *  (p1, p2) -> expression
         *  (p1, p2) -> { return expression }
         *
         */



        Addition addition = (num1, num2) -> num1 + num2;
        double sum = addition.sum(10, 20);
        //System.out.println("Sum of nums " + sum);
       // List<Integer> doubleNumber = new ArrayList<>();
        List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,19,20);
        /*for (Integer num: nums) {
            doubleNumber.add(num * 2);
        }*/
        Function<Integer, Integer> doubleFunction = n -> n * 2;
        Predicate<Integer> evenFunction = ele -> ele % 2 == 0;
        List<Integer> doubleNumber = nums.stream().map(doubleFunction).collect(Collectors.toList());
        List<Integer> evenNumbers = nums.stream().filter(evenFunction).collect(Collectors.toList());
        System.out.println(nums);
        System.out.println(doubleNumber);
        System.out.println(evenNumbers);
    }

    @FunctionalInterface
    interface Addition {
        double sum(int num1, int num2);
    }

    private static Map<String, List<Movie>> movieByCategory(List<Movie> movies) {
        Map<String, List<Movie>> movieByCategory = new HashMap<>();
         for (Movie movie: movies) {
             if (movie.getRating() >= 4.5) {
                 String category = movie.getCategory();
                 List<Movie> movieList = movieByCategory.get(category);
                 if(movieList == null) {
                     movieList = new ArrayList<>();
                     movieByCategory.put(category, movieList);
                 }
                 movieList.add(movie);
             }
         }
         return movieByCategory;
    }

}

class Movie {
    private String name;
    private double rating;
    private String category;

    public Movie(String name, double rating, String category) {
        this.name = name;
        this.rating = rating;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", category=" + category +
                '}';
    }
}
