import java.util.*;
import java.text.*;

public class DemoDate {
    public static void main(String[] args) {
        // (a)
        Date today = new Date();
        // (b)
        Locale[] locales = { Locale.US, Locale.UK, Locale.FRANCE, Locale.GERMANY };
        // (c)
        int[] styles = { DateFormat.FULL, DateFormat.LONG, DateFormat.MEDIUM, DateFormat.SHORT };
        // (d)
        String[] arr = { "FULL", "LONG", "MEDIUM", "SHORT" };
        // (e)
        DateFormat fmt2;
        // (f)
        for (Locale i : locales) {
            int k = 0;
            System.out.println(i.getDisplayCountry());

            for (int j : styles) {
                fmt2 = DateFormat.getDateInstance(j, i);
                System.out.println(arr[k] + ": " + fmt2.format(today));
                k++;
            }
            System.out.println("------------------------------------");
        }
    }
}

// fmt2 = DateFormat.getDateInstance(styles[2], locales[2]);
// System.out.println(fmt2.format(today));
// System.out.println(locales[1].getDisplayCountry());