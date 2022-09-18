class Airplane {

    private final Wings wng;

    public Airplane() {
        wng = new Wings();
    }
}

class Wings {

    public String model;
    public int num;

}

// *****The relationship between Airplane class and Wings class is
// Composition********

public class Composition {
    public static void main(String[] args) {

        Airplane f16 = new Airplane();

    }
}
