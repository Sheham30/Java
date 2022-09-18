import java.util.ArrayList;

public class arraylistclone implements Cloneable
{
    int[] anarray = {1,2,3,4,5};
    int value = 6;

    void changearray()
    {
        anarray[0] = 11;
        value = 8;

        // return anarray;
    }
    public void setAnarray(int[] anarray) {
        this.anarray = anarray;
    }
    public int[] getAnarray() {
        return anarray;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        arraylistclone duplicate = (arraylistclone) super.clone();
        duplicate.setAnarray((int []) duplicate.getAnarray().clone());
        return duplicate;
    }

    public String toString()
    {
        String info = "The array is:";
        for (int i = 0; i < anarray.length; i++) {
             info += anarray[i] + " ";
        }
        info += "and the value is " + value;
        return info;
    }


    public static void main(String[] args) {
        arraylistclone a1 = new arraylistclone();
        System.out.println(a1);
        arraylistclone a2 = null;
        try
        {
            a2 = (arraylistclone) a1.clone();
            System.out.println(a2);
        }
        catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        a1.changearray();
        System.out.println(a1);
        System.out.println(a2);

    }
}