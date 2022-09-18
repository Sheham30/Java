class KU
{
    protected String manager = "Asim";

    public void displayUni()
    {
        System.out.println("University is KU");
    }
}

class Ubit extends KU
{
   public String manager = "Nadeem";
    
   public void displayDept()
   {
        System.out.println("Department is Ubit");
   }
}

class BSSE extends Ubit
{
    public void displayFaculty()
    {
         System.out.println("Faculty is BSSE");
    }
}


public class Inheritance {
    public static void main(String[] args) {
        Ubit a = new Ubit();

        a.displayDept();
        a.displayUni();
        System.out.println(a.manager);
    }
}
