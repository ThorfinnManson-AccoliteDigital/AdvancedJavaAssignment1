package JAXB;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class main {
    private static final String employeesXML = "./employees-jaxb.xml";

    public static void main(String[] args) throws JAXBException, IOException {
        employee emp1 = new employee("001", "thorfinn", "30000");

        JAXBContext context = JAXBContext.newInstance(employee.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(emp1, System.out);
        m.marshal(emp1, new File(employeesXML));

        Unmarshaller um = context.createUnmarshaller();
        employee emp1_copy = (employee) um.unmarshal(new FileReader(employeesXML));

        System.out.print("first emp: \n" + emp1.toString() + "\n");
        System.out.print("emp copy: \n" + emp1_copy.toString());
    }
}
