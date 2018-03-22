package авиакомпания;
import авиакомпания.BEL_and_Rus.Belairline;
import авиакомпания.BEL_and_Rus.chName;
import авиакомпания.characteristics.characteristicsPlane;
import авиакомпания.factory.abstractFactory;
import java.io.*;
public class airlineBel extends abstractFactory
{
    public Plane  plane1;
    public Plane  plane2;
    public Plane  plane3;
    public Plane  plane4;
    public Plane plane5;
    @Override
    public chName getChName() {
        return new Belairline();
    }
    enum TypePlane
    {
        PassengerPlane,
        CargoPlane
    }

    public airlineBel()
    {
       TypePlane a=TypePlane.PassengerPlane;
       TypePlane b=TypePlane.CargoPlane;
         plane1=new Plane(a.toString(),"P1",100,110,53,10);
         plane2=new Plane(a.toString(),"P2",80,10,3,20);
         plane3=new Plane(b.toString(),"P3",1100,15,53,11);
         plane4=new Plane(b.toString(),"P4",600,165,1,33);
         plane5=new Plane(a.toString(),"P5",300,70,113,12);
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    private String Name;
    public  static int all_gruth;
    public  static int all_vmes;
    public String type;

    public static class Plane implements Serializable
    {
        public int ves;
        public int vmes;
        public int dist;
        public int Fuel;
        public String type;
        public String TypeName;

        public Plane()
        {

        }

        public Plane(String type, String name, int gruth, int vmes, int dist, int Fuel) {
            this.type = type;
            this.TypeName = name;
            all_gruth += gruth;
            all_vmes += vmes;
            this.dist = dist;
            this.Fuel = Fuel;
        }
        public void setVes(int ves) {
            this.ves = ves;
        }

        public String getTypeName() {
            return TypeName;
        }
        public void setVmes(int vmes) {
            this.vmes = vmes;
        }

        public int GetVes()
        {
            return ves;
        }

        public String GetType()
        {
            return  type;
        }

         public String ShowName()
         {
             return TypeName;
         }

        public int getDist() {
            return dist;
        }

        public int getFuel() {
            return Fuel;
        }

        public void setDist(Integer dist) {
            this.dist = dist;
        }

        public void setFuel(Integer Fuel) {
            this.Fuel = Fuel;
        }

        public void setTypeName(String TypeName) {
            this.TypeName = TypeName;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
