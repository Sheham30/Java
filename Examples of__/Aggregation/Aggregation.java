class University
{
    private String name;
    private String city;
    private int noOfRooms;

    public University(String name, String city, int noOfRooms)
    {
        this.name = name;
        this.city = city;
        this.noOfRooms = noOfRooms;
    }
    
}

class Professors
{
    private String name;
    private int salary;
    
    public Professors(String name, int sal)
    {
        this.name = name;
        this.salary = sal;
    }
}

// *****The relationship between University class and Professors class is Aggregation********


public class Aggregation {
    public static void main(String[] args) {

        University Ned = new University("Ned", "Karachi", 6);
        Professors Ateeq = new Professors("Ateeq", 50000);

    }
}
