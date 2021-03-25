package stream;

import java.util.List;

public class Instructor {
    private String name;
    private int yearsOfExperience;
    private String title;
    private String gender;
    private boolean isOnline;
    private List<String> courses;

    public Instructor(String name, int yearsOfExperience, String title, String gender,
                      boolean isOnline, List<String> courses) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.title = title;
        this.gender = gender;
        this.isOnline = isOnline;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getTitle() {
        return title;
    }

    public String getGender() {
        return gender;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public List<String> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + name + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", title='" + title + '\'' +
                ", gender='" + gender + '\'' +
                ", isOnline=" + isOnline +
                ", courses=" + courses +
                '}';
    }
}
