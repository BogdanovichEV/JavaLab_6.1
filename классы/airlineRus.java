package авиакомпания;
import авиакомпания.BEL_and_Rus.Rusairline;
import авиакомпания.BEL_and_Rus.chName;
import авиакомпания.characteristics.characteristicsPlane;
import авиакомпания.factory.abstractFactory;

public class airlineRus extends abstractFactory {
    @Override
    public chName getChName() {
        return new Rusairline();
    }
    public Plane plane1;
    public Plane plane2;
    public Plane plane3;
    public Plane plane4;
    public Plane plane5;
    enum TypePlane {
        PassengerPlane,
        CargoPlane
    }

    public airlineRus() {
        airlineRus.TypePlane a = airlineRus.TypePlane.PassengerPlane;
        airlineRus.TypePlane b = airlineRus.TypePlane.CargoPlane;
        plane1 = new airlineRus.Plane(a.toString(), "P1", 56, 120, 14, 11);
        plane2 = new airlineRus.Plane(a.toString(), "P2", 10, 30, 31, 22);
        plane3 = new airlineRus.Plane(b.toString(), "P3", 1500, 95, 13, 51);
        plane4 = new airlineRus.Plane(b.toString(), "P4", 660, 115, 22, 73);
        plane5 = new airlineRus.Plane(a.toString(), "P5", 120, 44, 47, 34);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    private String Name;
    public int all_gruth;
    public int all_vmes;
    public String type;

    public class Plane  {
        int ves;
        int vmes;
        public int dist;
        //топливо
        public int Fuel;
        private String TypeName;
        public String type;

        public Plane() {

        }

        public Plane(String type, String name, int gruth, int vmes, int dist, int Fuel) {
            this.type = type;
            this.TypeName = name;
            all_gruth += gruth;
            all_vmes += vmes;
            this.dist = dist;
            this.Fuel = Fuel;
        }

        public String ShowName() {
            return TypeName;
        }


        public double Getdistanse() {
            return dist;
        }


        public int getFuel() {
            return Fuel;
        }
    }
}
