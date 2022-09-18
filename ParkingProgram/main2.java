import java.util.*;

interface Parking {
    public void insertCar(String name, String num, int st);
    public void parkingStatus();
    public void printCars();
    public void printSlot();
}

class LuckyOneParking implements Parking {
    
    private int parkingLimit = 6;
    private int slots = 6;
    public Car data[];
    public int slot[];
    private int carParked = 0;

    public LuckyOneParking(){
        data = new Car[parkingLimit];
        slot = new int[slots];
    }

    public void insertCar(String name, String num, int st){
        if (parkingLimit == 0)
        {
            System.out.println("Parking is Full");
        }
        else 
        {
            data[carParked] = new Car(name, num, st);
            int i = data[carParked].getSlot();
            if (slot[i-1] == 1){
                System.out.println("Slot is full");
            }
            else {
                carParked++;
                parkingLimit--;
                System.out.println("Car Parked at slot "+i+", Parking Left "+parkingLimit);
                slot[i-1] = 1;
            }
        }
    }

    public void parkingStatus(){
        System.out.println();
        System.out.println("Car Parked: "+ carParked);
        System.out.println("Parking Left: "+ parkingLimit);
        System.out.println();
    }

    public void printCars() {
        System.out.println("");
        for (int i=0; i<carParked; i++){
            
            System.out.println(data[i].toString()); 
            System.out.println("");
        }
    }

    public void printSlot() {
        for (int i=0; i<slots; i++)
        {
            int j = i+1;
            if (slot[i] == 1) {
                System.out.println("Slot "+j+ ": Full");
            }
            else if (slot[i] == 0) {
                System.out.println("Slot "+j+ ": Empty");
            }
        }
    }
}

class Car {
    private String noPlate;
    private String model;
    private int slot;

    
    public Car() {
    }
    public Car(String nP, String mod, int st){
        this.noPlate = nP;
        this.model = mod;
        this.slot = st;
    }


    public String getNoPlate() {
        return noPlate;
    }
    public void setNoPlate(String noPlate) {
        this.noPlate = noPlate;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getSlot() {
        return slot;
    }
    public void setSlot(int slot) {
        this.slot = slot;
    }
    
    @Override
    public String toString() {
        return "Car: " + model + ", Number Plate: " + noPlate + "\nParked at Slot: "+slot;
    }
}

// ---------------------------------------------------
class main2 {
    public static void main(String[] args) {
        System.out.println("\n*****Welcome to LuckyOne Mall Car Parking****");

        LuckyOneParking O = new LuckyOneParking();
        int i = -1;
        while (i != 0)
        {
            Scanner scn = new Scanner(System.in);
            System.out.println("\nEnter\n1. Park a Car\t2. Cars Parked\t3. Slot Status\t4. Parking Status\t0. Exit");
            i = scn.nextInt();
            if (i == 1) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter Car Name: ");
                String j = sc.next();
                System.out.print("Enter Car Number: ");
                String k = sc.next();
                System.out.print("Enter Slot you want to Park a Car: ");
                int l = sc.nextInt();
                O.insertCar(j, k, l);
            }

            if (i == 2){
                O.printCars();
            }
            if (i == 3){
                O.printSlot();
            }
            if (i == 4){
                O.parkingStatus();
            }                        
        }
    }
}