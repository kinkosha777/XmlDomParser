package kg.megacom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException {


        try {


            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse("http://www.geoplugin.net/xml.gp?base_currency=USD");
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            Node node = doc.getFirstChild();
            NodeList nList = node.getChildNodes();
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node1 = nList.item(temp);

                if(node1.getNodeType() == Node.ELEMENT_NODE){
                    Element oElement = (Element) node1;
                    System.out.println(oElement.getNodeName()+":"+oElement.getTextContent());
                }



            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}