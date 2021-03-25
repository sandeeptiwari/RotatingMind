package stream;

import java.util.Arrays;
import java.util.List;

public class InstructorController {

    public List<Instructor> getAll() {
        Instructor instructor1 = new Instructor("Mike", 25, "Director Manager",
                "M", false, Arrays.asList("Java programming", "Spring programming", "SQL"));

        Instructor instructor2 = new Instructor("Dianna", 20, "Business Analiyst",
                "F", true, Arrays.asList("Database Architecture", "SQL"));

        Instructor instructor3 = new Instructor("Jane", 4, "Software Developer",
                "M", false, Arrays.asList("Java programming", "Python programming"));

        Instructor instructor4 = new Instructor("David Jesen", 12, "DevOps Engineer",
                "M", true, Arrays.asList("Java programming", "Python programming"));

        Instructor instructor5 = new Instructor("Cristi", 6, "Test Engineer",
                "F", true, Arrays.asList("Selenium", "TestNg", "Cucumber"));

        Instructor instructor6 = new Instructor("Ryan", 2, "Software Developer",
                "M", false, Arrays.asList("Java programming", "Java Script"));

        Instructor instructor7 = new Instructor("Kyle", 15, "Sr. Software Developer",
                "M", true, Arrays.asList("Java programming", "Spring Boot", "Angular Js"));

        Instructor instructor8 = new Instructor("Michale", 14, "Sr. Software Developer",
                "M", true, Arrays.asList("Angular Js", "Java programming"));

        Instructor instructor9 = new Instructor("Lorena", 8, "Dev Ops Engineer",
                "F", true, Arrays.asList("Jenkins", "DevOps"));

        List<Instructor> list = Arrays.asList(instructor1, instructor2, instructor3, instructor4, instructor5, instructor6
        , instructor7, instructor8, instructor9);

        return list;
    }
}
