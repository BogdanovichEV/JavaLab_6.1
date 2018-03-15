package авиакомпания;
import авиакомпания.BEL_and_Rus.Belairline;
import авиакомпания.BEL_and_Rus.chName;
import авиакомпания.characteristics.characteristicsPlane;
import авиакомпания.factory.abstractFactory;

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
    public  int all_gruth;
    public  int all_vmes;
    public String type;

    public class Plane
    {
         int ves;
         int vmes;
        public int dist;
        //топливо
        public int Fuel;
        private String TypeName;
        public String type;
        public Plane()
        {

        }
         public Plane(String type,String name,int gruth,int vmes,int dist,int Fuel)
         {
             this.type=type;
             this.TypeName=name;
             all_gruth+=gruth;
             all_vmes+=vmes;
             this.dist=dist;
             this.Fuel=Fuel;
         }
         public String ShowName()
         {
             return TypeName;
         }

        public int getDist() {
            return dist;
        }

        public double Getdistanse() {
            return dist;
        }


        public int getFuel() {
            return Fuel;
        }
    }
}
