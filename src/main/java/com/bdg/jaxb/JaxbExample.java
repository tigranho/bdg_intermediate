package com.bdg.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JaxbExample {

    private final String XML_PATH = "src/main/resources/user.xml";

    public void marshal(User user) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(User.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(user, new File(XML_PATH));
    }


    public User unMarshal() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(User.class);

        return (User) context.createUnmarshaller()
                .unmarshal(new FileReader(XML_PATH));
    }


}
