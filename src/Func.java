import jdk.internal.org.xml.sax.SAXException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import диспетчер.dispatcher;
import авиакомпания.*;
import авиакомпания.factory.abstractFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import авиакомпания.test_factory.Test;
import авиакомпания.Serialize;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import SAXparser.SAX;
public class Func {
    static
    {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(Func.class);

    public static void main(String[] args) throws JAXBException {
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
        /////////////////////////////////////////////////////////
        try {
            SAXParserFactory factory=SAXParserFactory.newInstance();
            SAXParser parser=factory.newSAXParser();
            SAX ob = new SAX();
            parser.parse(new File("S://Java_lab//JavaLab_3//src//files//doc.xml"),ob);
            System.out.println("SAX");
            for (airlineBel.Plane plane:ob.list)
            {
                System.out.print("Дистанция: "+plane.getDist()+" ");
                System.out.print("Топливо:"+ plane.getFuel()+" ");
                System.out.print("Номер :"+plane.getTypeName()+" ");
                System.out.print("Тип: "+plane.GetType()+'\n'+" ");
            }
            System.out.println("---------------------------------------------------");
            ob.sort();
            for (airlineBel.Plane plane:ob.list)
            {
                System.out.print("Дистанция: "+plane.getDist()+" ");
                System.out.print("Топливо:"+ plane.getFuel()+" ");
                System.out.print("Номер :"+plane.getTypeName()+" ");
                System.out.print("Тип: "+plane.GetType()+'\n'+" ");
            }
            System.out.println("---------------------------------------------------");
            System.out.println("Диссериализация");
            Serialize.Serializer(Name,"docyment.xml");
            for (airlineBel.Plane plane: Serialize.Deserialize("docyment.xml"))
            {
                System.out.print("Дистанция: "+plane.getDist()+" ");
                System.out.print("Топливо:"+ plane.getFuel()+" ");
                System.out.print("Номер :"+plane.getTypeName()+" ");
                System.out.print("Тип: "+plane.GetType()+'\n'+" ");
            }
            Serialize.Serialize_in_Json(Name,"docyment1.json");
            System.out.println("---------------------------------------------------");
            System.out.println("Диссериализация из Json");
            for (airlineBel.Plane plane: Serialize.Deserialize_from_Json("docyment1.json"))
            {
                System.out.print("Дистанция: "+plane.getDist()+" ");
                System.out.print("Топливо:"+ plane.getFuel()+" ");
                System.out.print("Номер :"+plane.getTypeName()+" ");
                System.out.print("Тип: "+plane.GetType()+'\n'+" ");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}