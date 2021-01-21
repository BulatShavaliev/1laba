import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class xmlReading1laba {public static void main(String[] args){
    try {
        File xmlDoc = new File("Games.xml");
        DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuild = dbFact.newDocumentBuilder();
        Document doc = dBuild.parse(xmlDoc);
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("game");
        float avgPrice = 0;
        float Games_num = nList.getLength();
        for(int i=0 ; i<nList.getLength();i++){
              Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("game ID#: " + eElement.getAttribute(("id")));
                System.out.println("game_name: " + eElement.getElementsByTagName(("game_name")).item(0).getTextContent());
                System.out.println("release_date: " + eElement.getElementsByTagName(("release_date")).item(0).getTextContent());
                System.out.println("author: " + eElement.getElementsByTagName(("author")).item(0).getTextContent());
                System.out.println("game_engine: " + eElement.getElementsByTagName(("game_engine")).item(0).getTextContent());
                System.out.println("Price: " + eElement.getElementsByTagName(("price")).item(0).getTextContent());
                avgPrice += Float.parseFloat(eElement.getElementsByTagName(("price")).item(0).getTextContent());
                System.out.println("-------------------------------------------------------------------------");
            }
        }
        System.out.println("avgPrice - " + avgPrice/Games_num);
    }
    catch (Exception e){
    }
}
}
