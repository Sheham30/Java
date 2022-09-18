import java.util.*;

class Student {

    private String studentName;

    public String getstudentName() {
        return studentName;
    }

    public void setstudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return studentName;
    }
}

class School {

    private String SchoolName;

    List<Student> students;

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String SchoolName) {
        this.SchoolName = SchoolName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setSchool(List<Student> students) {
        this.students = students;
    }
}

public class Association {
    public static void main(String[] args) {
        School schl = new School();
        schl.setSchoolName("Bahria Foundation");

        Student a1 = new Student();
        a1.setstudentName("Sheham");
        Student a2 = new Student();
        a2.setstudentName("Ahmad");

        List<Student> empList = new ArrayList<Student>();
        empList.add(a1);
        empList.add(a2);

        schl.setSchool(empList);

        System.out.println("\n" + schl.getStudents() + " are students in the School " + schl.getSchoolName() + "\n");
    }
}
