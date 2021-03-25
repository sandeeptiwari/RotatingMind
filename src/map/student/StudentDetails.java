package map.student;

public class StudentDetails {
    public int id;
    public StudentStatus studentStatus;
    public String name;

    public StudentDetails(int id, StudentStatus studentStatus, String name) {
        this.id = id;
        this.studentStatus = studentStatus;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public StudentStatus getStudentStatus() {
        return studentStatus;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "id=" + id +
                ", studentStatus=" + studentStatus +
                ", name='" + name + '\'' +
                '}';
    }
}
