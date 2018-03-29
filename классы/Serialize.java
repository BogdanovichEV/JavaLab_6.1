package авиакомпания;
import javax.xml.bind.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import com.google.gson.*;
import sun.rmi.runtime.Log;
import диспетчер.dispatcher;
import java.io.*;

import java.io.File;
import java.util.ArrayList;

public class Serialize {
    public static void Serializer(dispatcher Dispetcher, String fileName) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(dispatcher.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(Dispetcher, new File(fileName));
    }
    public static ArrayList<airlineBel.Plane> Deserialize(String fileName) throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext.newInstance(dispatcher.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        dispatcher manager = (dispatcher) jaxbUnmarshaller.unmarshal( new File(fileName) );
        return manager.getObj();
    }
    public static void Serialize_in_Json(dispatcher Dispetcher,String fileName)
    {
        try (OutputStreamWriter File = new OutputStreamWriter(new FileOutputStream(fileName)))
        {
            Gson gson = new Gson();
            String data = gson.toJson(Dispetcher);
            File.write(data);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<airlineBel.Plane> Deserialize_from_Json(String fileName)
    {
        dispatcher manager = null;
        try (FileReader isr = new FileReader(fileName))
        {
            Gson gson = new Gson();
            StringBuilder data = new StringBuilder();
            int c;
            while ((c = isr.read()) != -1)
            {
                data.append((char) c);
            }
            manager = gson.fromJson(data.toString(), dispatcher.class);
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return manager.getObj();
    }
}

