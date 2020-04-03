/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_scpi;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author semfa
 */
public class f_xml {
    
    public static void query() throws SAXException, IOException {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();            
            
            try {
         DocumentBuilder builder = factory.newDocumentBuilder();
        
             
             //la première chose qui change, nous n'allons pas lire un fichier
         //mais nous allons en créer un de toutes pièces
         File fileXML = new File("C:\\Users\\semfa\\OneDrive\\Documents\\NetBeansProjects\\SCPI_test\\src\\scpi_test\\auth_xml.xml");
         Document xml;

         xml = builder.parse(fileXML);
         
         //Création de notre élément racine
         Element root = xml.createElement("sem sem");
         
         //ensuite nous créons tous les nœuds de notre fichier XML
         Element trunk = xml.createElement("livre");
         trunk.setAttribute("auteur", "lord");
         
         
         Element branche = xml.createElement("titre");
         branche.setTextContent("jeux video");
         
         
         
         
         
         
         //Nous lions les nœuds les uns aux autres pour faire notre structure XML
         //nous ajoutons donc les nœuds "titre" aux nœuds "livre"
         trunk.appendChild(branche);
         

         
         
         //nous ajoutons donc les nœuds "livre" aux nœuds "bibliothèque"
         root.appendChild(trunk);
         
                     
         //On crée un fichier xml correspondant au résultat
         //construire la transformation inactive
         //Transformer t = TransformerFactory.newInstance().newTransformer();
         //définir les propriétés de sortie pour obtenir un nœud DOCTYPE
         //t.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "maDtdBibon.dtd");
         //t.setOutputProperty(OutputKeys.INDENT, "yes");
         // appliquer la transformation 
         //String resultFile = "C:\\Users\\semfa\\OneDrive\\Documents\\NetBeansProjects\\Test\\src\\test\\monTest.xml"; 
         //StreamResult XML = new StreamResult(resultFile);
         
         //t.transform(new DOMSource(root), XML);       
         
         
      } catch (DOMException e) {
         e.printStackTrace();
      } catch (ParserConfigurationException e) {
         e.printStackTrace();
      }catch (TransformerFactoryConfigurationError e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
        // TODO Auto-generated catch block
       
   
        
    }
    
}
