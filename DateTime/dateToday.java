import java.util.*;
import java .text.*;

public class dateToday {
    public static void main(String[] args) {
        Date now;
        SimpleDateFormat fmt;
        now = new Date();
        fmt = new SimpleDateFormat("dd MMMM yyyy");
        System.out.println("Today's Date: "+fmt.format(now));
    }
}
