import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.w3c.dom.DOMConfiguration;
import диспетчер.dispatcher;
import авиакомпания.*;
import авиакомпания.factory.abstractFactory;
import java.util.ArrayList;
import авиакомпания.test_factory.Test;
public class Func {
    static
    {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(Func.class);

    public static void main(String[] args)
    {
        LOG.info("Starting program");
       dispatcher Name=dispatcher.get_instanse();
        airlineBel x=new airlineBel();
        Test st=new Test();
        st.Start("BelAirline");
        Name.addPlane(x.plane1);
        Name.addPlane(x.plane2);
        Name.addPlane(x.plane3);
        Name.addPlane(x.plane4);
        Name.addPlane(x.plane5);
        Name.sort();
       Name.ShowSort();
        Name.ShowZapros();
        Name.all_Gruth();
        Name.all_Vmes();
        dispatcher Name1=dispatcher.get_instanse();
        Name1.all_Vmes();
        ArrayList<abstractFactory> list=new ArrayList<>();
        Test a=new Test();
        a.Start("BelAirline");
        list.add(a.proith);
        Test b=new Test();
        b.Start("RusPlanet");
        list.add(b.proith);
        for(abstractFactory p: list)
        {
            System.out.println(p.getChName());
        }
    }
}