package диспетчер;
import org.apache.log4j.Logger;
import авиакомпания.airlineBel;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

import диспетчер.InterfaceDispatcher.workDispatcher;

public class dispatcher  extends airlineBel implements workDispatcher
{
    private static final Logger LOG = Logger.getLogger(dispatcher.class);
    private static final dispatcher _instanse=new dispatcher();
    public static dispatcher get_instanse()
    {
        return _instanse;
    }
    private dispatcher()
    {

    }

    ArrayList<Plane> obj=new ArrayList<Plane>();
    //ArrayList<> obj1=new ArrayList<Plane>();
     public void addPlane(Plane ob)
    {
        obj.add(ob);
        LOG.info("Элемент добавлен");
        //System.out.println("Элемент добавлен");
    }
    public void sort()
    {
        Collections.sort(obj, new Comparator<Plane>() {
            @Override
            public int compare(Plane o1, Plane o2) {
                if(o1.dist==o2.dist) return 0;
                else
                {
                    if(o1.dist>o2.dist) return 1;
                    else
                        return -1;
                }
            }
        });
    }
    public void ShowSort()
    {
        LOG.info("Сортировка");
        //System.out.println("Сортировка");
        for (Plane p: obj)
        {
            LOG.info("Тип: "+p.type+p.ShowName()+" Дальность полёта "+p.dist +" Топливо: "+p.getFuel());
            //System.out.println("Тип: "+p.type+p.ShowName()+" Дальность полёта "+p.dist +" Топливо: "+p.getFuel());
        }
    }
    public void ShowZapros()
    {
        try {
        Scanner in=new Scanner(System.in);
        LOG.info("Поиск");
        System.out.println("Поиск");
        System.out.println("Введите количество топлива");
        int i=in.nextInt();
        LOG.info("Топливо>"+i);
        for (Plane p: obj)
        {
                if(i<=0)
                {
                    LOG.info("Количество топлива должно быть больше 0");
                    throw new Exception("Количество топлива должно быть больше 0");
                }
                if (p.getFuel() > i)
                    LOG.info("Тип: " + p.type + p.ShowName() + " Дальность полёта " + p.dist + " Топливо: " + p.getFuel());
        //            System.out.println("Тип: " + p.type + p.ShowName() + " Дальность полёта " + p.dist + " Топливо: " + p.getFuel());
        }
        }
            catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }


    public String getNameD() {
        return NameD;
    }

    public void setNameD(String nameD) {
        NameD = nameD;
    }

    private String NameD;

    @Override
    public void all_Vmes() {
        LOG.info("Сумарное количество мест в самалётах "+all_vmes);
         //System.out.println("Сумарное количество мест в самалётах "+all_vmes);
    }

    @Override
    public void all_Gruth() {
        LOG.info("Сумарная грузаподёмность самалётов: "+all_gruth);
        //System.out.println("Сумарная грузаподёмность самалётов: "+all_gruth);
    }
}
