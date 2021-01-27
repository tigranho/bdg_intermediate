package jaxb_example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

public class JavaToXml {
    public static void main(String[] args) {
        try {
           Student  student=new Student();
           student.setId(1);
           student.setFirstName("John");
           student.setLastName("Smith");

           JAXBContext jaxbContext= JAXBContext.newInstance(Student.class);
            Marshaller marshaller=jaxbContext.createMarshaller();
            File file=new File("src\\main\\resources\\student.xml");
            marshaller.marshal(student,file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
