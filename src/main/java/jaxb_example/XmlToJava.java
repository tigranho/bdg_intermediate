package jaxb_example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlToJava {
    public static void main(String[] args) {
        try{

            File file=new File("src//main//resources//student.xml");
            JAXBContext jaxbContext=JAXBContext.newInstance(Student.class);
            Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
             Student student=(Student) unmarshaller.unmarshal(file);
            System.out.println(student.getFirstName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
