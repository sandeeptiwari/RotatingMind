package map.student;

import java.util.*;

public class StudentController {

    private static Map<StudentStatus, TreeMap<Integer, Student>> load() {
        Map<StudentStatus, TreeMap<Integer, Student>> map = new HashMap<>();
        //PHD
        TreeMap<Integer, Student> smap1 = new TreeMap<>();
        smap1.put(1000, new Student(1000, "Ramesh", 28));
        smap1.put(1001, new Student(1001, "Suresh", 22));
        smap1.put(1002, new Student(1002, "Dinesh", 26));
        smap1.put(1003, new Student(1003, "Umesh", 25));

        map.put(StudentStatus.PHD, smap1);

        //UNDERGRAD
        TreeMap<Integer, Student> undergradeMap = new TreeMap<>();
        undergradeMap.put(2000, new Student(2000, "Sandeep", 18));
        undergradeMap.put(2001, new Student(2001, "Pradeep", 20));
        undergradeMap.put(2002, new Student(2002, "Kuldeep", 19));
        undergradeMap.put(2003, new Student(2003, "Rajdeep", 17));

        map.put(StudentStatus.UNDERGRAD, undergradeMap);

        //PostGrade
        TreeMap<Integer, Student> postgradeMap = new TreeMap<>();
        postgradeMap.put(3000, new Student(3000, "John", 22));
        postgradeMap.put(3001, new Student(3001, "Kyle", 20));
        postgradeMap.put(3002, new Student(3002, "Robert", 21));
        postgradeMap.put(3003, new Student(3003, "Ryan", 23));

        map.put(StudentStatus.POSTGRAD, postgradeMap);

        return map;
    }

    public static void main(String[] args) {
        Map<StudentStatus, TreeMap<Integer, Student>> map = load();
        StudentDetails studentDetails = map.entrySet().stream()
                .flatMap(statusEntry  -> statusEntry.getValue().entrySet().stream()
                .map(ageEntry -> new AbstractMap.SimpleEntry<>(ageEntry.getValue().getAge(),
                        new StudentDetails(ageEntry.getValue().getId(),
                        statusEntry.getKey(), ageEntry.getValue().getName()))))
                .min(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .get();
        System.out.println("StudentDetails:: "+studentDetails);
    }
}
