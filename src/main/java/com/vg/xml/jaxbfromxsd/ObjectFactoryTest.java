package com.vg.xml.jaxbfromxsd;

import java.io.File;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * This class uses auto-generated jaxb classes in order to unmarshall java
 * objects from generated xml file jaxb classes and xml file was generated based
 * on SimpleSchema.xsd from Eclipse
 * 
 * @author vladimir
 *
 */
public class ObjectFactoryTest {
	public static void main(String[] args) throws Exception {

		ClassLoader classLoader = new ObjectFactoryTest().getClass().getClassLoader();
		File file = new File(classLoader.getResource("Simple.xml").getFile());

		FileReader reader = new FileReader(file);
		JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Object obj = unmarshaller.unmarshal(reader);

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(obj, System.out);
	}
}
