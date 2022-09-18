public class patientclone {
    public static void main(String[] args) {
        patient a1 = new patient(44,"Ali");
        System.out.println(a1);
        patient a2 = null;

        try
        {
            a2 = (patient) a1.clone();
            System.out.println(a2);            

        } catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        if(a1.equals(a2))
        {
            System.out.println("a2 is a deep copy of java");
        }

        System.out.println("----------------------");
        // *changing values of a2*
        a2.patient = "Sheham";

        System.out.println(a1.patient);
        System.out.println(a2.patient);
    }
}

class patient implements Cloneable{
 
    public int patientId;
    public String patientName;
    
     public patient()
     {
         patientId = 0;
         patientName = 0;
     }
     
    public patient(int apatientId, String apatientName)
    {
        patientId = apatientId;
        patientName = apatientName;
    }
    
    public patient(patient originala)
    {
        this.patientId = originala.patientId;
        this.patientName = originala.patientName;
    }
    
    public int getX(){
        return patientId;
    }
    
     public int getY(){
        return patientName;
    }
    
   public String toString() {
        return patientId + " " + patientName;
   }
    
   @Override
   protected Object clone() throws CloneNotSupportedException
   {
    patient duplicate = (patient) super.clone();
    return duplicate;
   }
   
   @Override
   public boolean equals(Object obj)
   {
       boolean result = false;
       if(obj instanceof patient)
       {
           patient that = (point) obj;
            result = (this.getX() == that.getX() && this.getY() == that.getY());
       }
       return result;
   }
    
  }