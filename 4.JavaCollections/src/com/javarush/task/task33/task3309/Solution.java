package com.javarush.task.task33.task3309;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* 
Комментарий внутри xml
*/

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, ParserConfigurationException, IOException, SAXException, TransformerException {
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, writer);

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        builderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(writer.toString().getBytes(StandardCharsets.UTF_8));
        Document document = builderFactory.newDocumentBuilder().parse(byteArrayInputStream);
        document.getDocumentElement().normalize();

        NodeList list = document.getElementsByTagName(tagName);
        for (int i = 0; i < list.getLength(); i++) {
            Node item = list.item(i);

//            if (item.getNodeType() == Node.ELEMENT_NODE) {
//                if (tagName.equalsIgnoreCase(item.getNodeName())) {
            Node parent = item.getParentNode();
            parent.insertBefore(document.createComment(comment), item);
//                }
//            }
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
//        transformer.setOutputProperty(OutputKeys.CDATA_SECTION_ELEMENTS,"yes" );
        StringWriter stringWriter = new StringWriter();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(stringWriter);
        transformer.transform(domSource, streamResult);
        return stringWriter.toString();
    }

    public static void main(String[] args) throws JAXBException, ParserConfigurationException, IOException, TransformerException, SAXException {
        First first = new First();
        first.data.add("some string 1");
        first.data.add("some string 2");
        first.data.add("some string 3");
        first.data.add("<![CDATA[need CDATA because of < and >]]>");
        first.data.add("");
        String xml = toXmlWithComment(first, "second", "it's a comment");
        System.out.println(xml);
    }
    @XmlType(name = "first")
    @XmlRootElement

    public static class First {
        @XmlElement(name = "second")
        public List<String> data;

        public First() {
            data = new ArrayList<>();
        }

    }
}
