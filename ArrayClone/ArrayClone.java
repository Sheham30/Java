class Array implements Cloneable{
    private int[] anArray = {1,2,3,4,5,6};
    private int value;

    public void increment() {
        for (int i=0; i<anArray.length; i++) {
            ++anArray[i];
        }
        value++;
    }
    
    public String toString() {
        String info = "The array contains "+anArray.length+ "numbers:";

        for (int i=0; i<anArray.length; i++){
            info += anArray[i] + "";
        }
        info += " and value is "+value;
        return info;
    }

    public void setAnArray(int[] anArray) {
        this.anArray = anArray;
    }
    public int[] getAnArray() {
        return anArray;
    }

    protected Object clone() throws CloneNotSupportedException {
        Array duplicate = (Array) super.clone();
        duplicate.setAnArray((int []) duplicate.getAnArray().clone());
        return duplicate;
    }
}

public class ArrayClone {
    public static void main(String[] args) {
        Array v1 = new Array();
        Array v2 = null;

        // v1.toString();
        // System.out.println(v1.toString());

        try{
            v2 = (Array) v1.clone();
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("v1" + v1);
        System.out.println("v2" + v2);

        System.out.println("----------------");

        v2.increment();
        System.out.println("v1" + v1);
        System.out.println("v2" + v2);

    }
}
