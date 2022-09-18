// import java.lang.Cloneable.*;

class Location1 implements Cloneable {
    private String name;
    private int xCor;
    private int yCor;

    Location1(String n, int x, int y) {
        this.name = n;
        this.xCor = x;
        this.yCor = y;
    }

    // getters
    public String getName() {
        return name;
    }

    public int getxCor() {
        return xCor;
    }

    public int getyCor() {
        return yCor;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setxCor(int xCor) {
        this.xCor = xCor;
    }

    public void setyCor(int yCor) {
        this.yCor = yCor;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

    return super.clone();
    }

    // @Override
    // protected Object clone() throws CloneNotSupportedException {
    //     Location1 duplicate = new Location1(this);
    //     return duplicate;
    // }

    @Override
    public boolean equals(Object a) {
        boolean result = true;

        Location1 s = (Location1) a;

        if ((s.name != name) || (s.xCor != this.xCor) || (s.yCor != yCor)) {
            result = false;
        }
        return result;

    }
}

public class Location {
    public static void main(String[] args) {

        Location1 Pak = new Location1("Pakistan", 123456, 543216);
        Location1 Ind = new Location1("India", 66666, 33333);

        System.out.println("*********Before CLoning***********");

        System.out.println(Pak.getName());
        System.out.println(Ind.getName());

        // Location1 Ind = null;

        // *******Cloning Object*********
        try {
            Ind = (Location1) Pak.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("*********After CLoning***********");

        System.out.println(Ind.getName());
        System.out.println(Pak.getName());
        Ind.setName("sssss");
        System.out.println(Ind.getName());
        System.out.println(Pak.getName());

        // ----------------Equals----------------

        System.out.println("*********Equals***********");

        Location1 Aus = new Location1("Australia", 11111, 22222);
        Location1 Oce = new Location1("Australia", 11111, 22222);
        Location1 Nz = new Location1("NewZealand", 11111, 22223);

        System.out.println(Aus.equals(Oce));
        System.out.println(Aus.equals(Nz));

    }
}
