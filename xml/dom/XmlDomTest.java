package xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by crist on 2021/5/24
 *
 * @author cc
 */
public class XmlDomTest {

    public static void main(String[] args)throws Exception {
        //Get Document Builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Build Document
        Document document = builder.parse(new File("employee.xml"));

        //Normalize the XML Structure; It's just too important !!
        document.getDocumentElement().normalize();

        //Here comes the root node
        Element root = document.getDocumentElement();
        System.out.println(root.getNodeName());

        //Get all employees
        NodeList nList = document.getElementsByTagName("employee");
        System.out.println("============================");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            System.out.println("");    //Just a separator
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                //Print each employee's detail
                Element eElement = (Element) node;
                System.out.println("Employee id : " + eElement.getAttribute("id"));
                System.out.println("First Name : " + eElement.getElementsByTagName("firstName").item(0).getTextContent());
                System.out.println("Last Name : " + eElement.getElementsByTagName("lastName").item(0).getTextContent());
                System.out.println("Location : " + eElement.getElementsByTagName("location").item(0).getTextContent());
            }
        }
    }

    private static List<Employee> parseEmployeesXML() throws ParserConfigurationException, SAXException, IOException
    {
        //Initialize a list of employees
        List<Employee> employees = new ArrayList<>();
        Employee employee = null;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("employee.xml"));
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("employee");
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                //Create new Employee Object
                employee = new Employee();
                employee.setId(Integer.parseInt(eElement.getAttribute("id")));
                employee.setFirstName(eElement.getElementsByTagName("firstName").item(0).getTextContent());
                employee.setLastName(eElement.getElementsByTagName("lastName").item(0).getTextContent());
                employee.setLocation(eElement.getElementsByTagName("location").item(0).getTextContent());

                //Add Employee to list
                employees.add(employee);
            }
        }
        return employees;
    }
}
