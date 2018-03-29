package SAXparser;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;
import авиакомпания.airlineBel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SAX extends DefaultHandler{

    public ArrayList<airlineBel.Plane> list=new ArrayList<>();
    airlineBel.Plane plane;
    String thisElement = "";

    public void sort()
    {
        Collections.sort(list, new Comparator<airlineBel.Plane>() {
            @Override
            public int compare(airlineBel.Plane o1, airlineBel.Plane o2) {
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

    public airlineBel.Plane getResult(){
        return plane;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML...");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("dist")) {
            plane = new airlineBel.Plane();
            plane.setDist(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("Fuel")) {
            plane.setFuel(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("TypeName")) {
            plane.setTypeName(new String(ch, start, length));
        }
        if (thisElement.equals("type")) {
            plane.setType(new String(ch, start, length));
            list.add(plane);
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Stop parse XML...");
    }
}
