package xml.sax;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Created by crist on 2021/5/24
 *
 * @author cc
 */
public class Test {

    public static void main(String[] args) throws Exception
    {
        //Locate the file
        File xmlFile = new File("user.xml");

        //Create the parser instance
        UsersXmlParser parser = new UsersXmlParser();

        //Parse the file
        ArrayList users = parser.parseXml(new FileInputStream(xmlFile));

        //Verify the result
        System.out.println(users);
    }
}
