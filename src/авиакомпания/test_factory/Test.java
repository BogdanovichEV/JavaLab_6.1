package авиакомпания.test_factory;

import авиакомпания.BEL_and_Rus.chName;
import авиакомпания.airlineBel;
import авиакомпания.airlineRus;
import авиакомпания.factory.abstractFactory;

public class Test
{
    public abstractFactory proith;
    public void Start(String str)
    {
        proith=null;
        if(str.equals("BelAirline"))
            proith=new airlineBel();
        if(str.equals("RusPlanet"))
            proith=new airlineRus();
        if(proith!=null)
        {
            chName name=proith.getChName();
            name.Name();
        }
        else
        {
            System.out.println("Данныйх авиакомпаний неcуществует");
        }
    }
}
