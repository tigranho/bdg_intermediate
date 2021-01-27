package com.bdg.jaxb;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        User user = new User();
        user.setId(1L);
        user.setFirstName("arsen");
        user.setLastName("sargsyan");
          user.setAddress(new Address("Armenia","Vanandzor"));

        JaxbExample jaxb = new JaxbExample();

        try {
            jaxb.marshal(user);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            User userFromXmlFile = jaxb.unMarshal();
            System.out.println(userFromXmlFile);
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
