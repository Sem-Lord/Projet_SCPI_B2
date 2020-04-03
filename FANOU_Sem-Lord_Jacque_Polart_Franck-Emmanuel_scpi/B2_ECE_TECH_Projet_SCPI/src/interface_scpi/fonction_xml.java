/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_scpi;

//Ceci importe la classe Scanner du package java.util
import java.io.IOException;
import java.util.Scanner; 
//Ceci importe toutes les classes du package java.util
import java.util.*;
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
public class fonction_xml {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SAXException, IOException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir un livre :");
        String str="";
        str = sc.nextLine();
        System.out.println(str);
        
        if(str == "sem"){
            
            System.out.println("passe incorrect");
        }
        else{
            f_xml.query();
        }
     
        
  } 
      
        
 }    
    
    

