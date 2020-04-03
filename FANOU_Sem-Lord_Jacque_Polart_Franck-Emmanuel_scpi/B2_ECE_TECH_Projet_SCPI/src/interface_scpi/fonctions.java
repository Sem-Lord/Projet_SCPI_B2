/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_scpi;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author semfa
 */
public class fonctions {
    public static void insert_inscrire(String id, String passe, String email){
        
        try {
			File xmlFile = new File("C:\\Users\\semfa\\OneDrive\\Documents\\NetBeansProjects\\B2_ECE_TECH_Projet_SCPI\\src\\XML_code\\bdd_id.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFile);
			
			Element documentElement = document.getDocumentElement();
			Element textNode = document.createElement("identifiant");
			textNode.setTextContent(id);
			Element textNode1 = document.createElement("password");
			textNode1.setTextContent(passe);
			Element textNode2 = document.createElement("email");
			textNode2.setTextContent(email);
			Element nodeElement = document.createElement("users");
			nodeElement.appendChild(textNode);
			nodeElement.appendChild(textNode1);
			nodeElement.appendChild(textNode2);
			documentElement.appendChild(nodeElement);
			document.replaceChild(documentElement, documentElement);
			Transformer tFormer =
			TransformerFactory.newInstance().newTransformer();
			tFormer.setOutputProperty(OutputKeys.METHOD, "xml");
			Source source = new DOMSource(document);
			Result result = new StreamResult(xmlFile);
			tFormer.transform(source, result);
		
		
		} catch (Exception ex) {
			System.out.println(ex);
			}
    }
    
    public static boolean read(String id, String passe) throws ParserConfigurationException, SAXException, IOException{
        File fXmlFile = new File("C:\\Users\\semfa\\OneDrive\\Documents\\NetBeansProjects\\B2_ECE_TECH_Projet_SCPI\\src\\XML_code\\bdd_id.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
        
        doc.getDocumentElement().normalize();

	NodeList nList = doc.getElementsByTagName("users");

	for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		Element eElement = (Element) nNode;
                if (eElement.getElementsByTagName("identifiant").item(0).getTextContent().equals(id)
                    && eElement.getElementsByTagName("password").item(0).getTextContent().equals(passe)){
                   
                    return true;
                    
                }		
		}
	}
        return false;
    }
    
    public static boolean readname(String id, String passe) throws ParserConfigurationException, SAXException, IOException{
        File fXmlFile = new File("C:\\Users\\semfa\\OneDrive\\Documents\\NetBeansProjects\\B2_ECE_TECH_Projet_SCPI\\src\\XML_code\\bdd_id.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
        
        doc.getDocumentElement().normalize();

	NodeList nList = doc.getElementsByTagName("users");

	for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		Element eElement = (Element) nNode;
                if (eElement.getElementsByTagName("identifiant").item(0).getTextContent().equals(id)
                    && eElement.getElementsByTagName("password").item(0).getTextContent().equals(passe)){
                   
                    return eElement.getElementsByTagName("identifiant").item(0).getTextContent().equals(id);
                    
                }		
		}
	}
        return false;
    }


    public static void insert_souscription(String nom, String prenom, String enfant, String email, String telephone, String matrimoniale){
        
        try {
			File xmlFile = new File("C:\\Users\\semfa\\OneDrive\\Documents\\NetBeansProjects\\B2_ECE_TECH_Projet_SCPI\\src\\XML_code\\bdd_souscription.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFile);
			
			Element documentElement = document.getDocumentElement();
			Element textNode = document.createElement("nom");
			textNode.setTextContent(nom);
			Element textNode1 = document.createElement("prenom");
			textNode1.setTextContent(prenom);
			Element textNode2 = document.createElement("email");
			textNode2.setTextContent(email);
                        Element textNode3 = document.createElement("enfant");
			textNode3.setTextContent(enfant);
                        Element textNode4 = document.createElement("matrimoniale");
			textNode4.setTextContent(matrimoniale);
                        Element textNode5 = document.createElement("telephone");
			textNode5.setTextContent(telephone);
			Element nodeElement = document.createElement("page0");
			nodeElement.appendChild(textNode);
			nodeElement.appendChild(textNode1);
			nodeElement.appendChild(textNode2);
                        nodeElement.appendChild(textNode3);
                        nodeElement.appendChild(textNode4);
                        nodeElement.appendChild(textNode5);
			documentElement.appendChild(nodeElement);
			document.replaceChild(documentElement, documentElement);
			Transformer tFormer =
			TransformerFactory.newInstance().newTransformer();
			tFormer.setOutputProperty(OutputKeys.METHOD, "xml");
			Source source = new DOMSource(document);
			Result result = new StreamResult(xmlFile);
			tFormer.transform(source, result);
		
		
		} catch (Exception ex) {
			System.out.println(ex);
			}
    }
    
    
    public static void insert_souscription1(String personne, String adresse, String ville, String proprietaire, String activite, String duree, String pays, String code_postal, String investir, String objectif ){
        
        try {
			File xmlFile = new File("C:\\Users\\semfa\\OneDrive\\Documents\\NetBeansProjects\\B2_ECE_TECH_Projet_SCPI\\src\\XML_code\\bdd_souscription.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFile);
			
			Element documentElement = document.getDocumentElement();
			Element textNode = document.createElement("type_de_personne");
			textNode.setTextContent(personne);
			Element textNode1 = document.createElement("adresse");
			textNode1.setTextContent(adresse);
			Element textNode2 = document.createElement("ville");
			textNode2.setTextContent(ville);
                        Element textNode3 = document.createElement("proprietaire");
			textNode3.setTextContent(proprietaire);
                        Element textNode4 = document.createElement("activite");
			textNode4.setTextContent(activite);
                        Element textNode5 = document.createElement("duree");
			textNode5.setTextContent(duree);
                        Element textNode6 = document.createElement("pays");
			textNode6.setTextContent(pays);
                        Element textNode7 = document.createElement("code_postal");
			textNode7.setTextContent(code_postal);
                        Element textNode8 = document.createElement("investissement");
			textNode8.setTextContent(investir);
                        Element textNode9 = document.createElement("objectif");
			textNode9.setTextContent(objectif);
			Element nodeElement = document.createElement("page1");
			nodeElement.appendChild(textNode);
			nodeElement.appendChild(textNode1);
			nodeElement.appendChild(textNode2);
                        nodeElement.appendChild(textNode3);
                        nodeElement.appendChild(textNode4);
                        nodeElement.appendChild(textNode5);
                        nodeElement.appendChild(textNode6);
                        nodeElement.appendChild(textNode7);
                        nodeElement.appendChild(textNode8);
                        nodeElement.appendChild(textNode9);
			documentElement.appendChild(nodeElement);
			document.replaceChild(documentElement, documentElement);
			Transformer tFormer =
			TransformerFactory.newInstance().newTransformer();
			tFormer.setOutputProperty(OutputKeys.METHOD, "xml");
			Source source = new DOMSource(document);
			Result result = new StreamResult(xmlFile);
			tFormer.transform(source, result);
		
		
		} catch (Exception ex) {
			System.out.println(ex);
			}
    }
    
    public static void insert_souscription2(String nationalite, String date_naissance, String montant,
            String revenue, String pays_naissance, String ville_naissance, String patrimonial, String charge, String politique, String us){
        
        try {
			File xmlFile = new File("C:\\Users\\semfa\\OneDrive\\Documents\\NetBeansProjects\\B2_ECE_TECH_Projet_SCPI\\src\\XML_code\\bdd_souscription.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFile);
			
			Element documentElement = document.getDocumentElement();
			Element textNode = document.createElement("nationalite");
			textNode.setTextContent(nationalite);
			Element textNode1 = document.createElement("date_de_naissance");
			textNode1.setTextContent(date_naissance);
			Element textNode2 = document.createElement("montant");
			textNode2.setTextContent(montant);
                        Element textNode3 = document.createElement("revenue_annuel");
			textNode3.setTextContent(revenue);
                        Element textNode4 = document.createElement("pays_de_naissance");
			textNode4.setTextContent(pays_naissance);
                        Element textNode5 = document.createElement("ville_de_naisssance");
			textNode5.setTextContent(ville_naissance);
                        Element textNode6 = document.createElement("situation_patrimonial");
			textNode6.setTextContent(patrimonial);
                        Element textNode7 = document.createElement("autre_charge");
			textNode7.setTextContent(charge);
                        Element textNode8 = document.createElement("personnage_politique");
			textNode8.setTextContent(politique);
                        Element textNode9 = document.createElement("us_person");
			textNode9.setTextContent(us);
			Element nodeElement = document.createElement("page2");
			nodeElement.appendChild(textNode);
			nodeElement.appendChild(textNode1);
			nodeElement.appendChild(textNode2);
                        nodeElement.appendChild(textNode3);
                        nodeElement.appendChild(textNode4);
                        nodeElement.appendChild(textNode5);
                        nodeElement.appendChild(textNode6);
                        nodeElement.appendChild(textNode7);
                        nodeElement.appendChild(textNode8);
                        nodeElement.appendChild(textNode9);
			documentElement.appendChild(nodeElement);
			document.replaceChild(documentElement, documentElement);
			Transformer tFormer =
			TransformerFactory.newInstance().newTransformer();
			tFormer.setOutputProperty(OutputKeys.METHOD, "xml");
			Source source = new DOMSource(document);
			Result result = new StreamResult(xmlFile);
			tFormer.transform(source, result);
		
		
		} catch (Exception ex) {
			System.out.println(ex);
			}
    }
    
    public static void insert_souscription3(String transaction, String nbr_transaction, String investir,
             String paiement, String provenance, String capital, String baisse, String limite, String variation){
        
        try {
			File xmlFile = new File("C:\\Users\\semfa\\OneDrive\\Documents\\NetBeansProjects\\B2_ECE_TECH_Projet_SCPI\\src\\XML_code\\bdd_souscription.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFile);
			
			Element documentElement = document.getDocumentElement();
			Element textNode = document.createElement("frequence_transaction");
			textNode.setTextContent(transaction);
			Element textNode1 = document.createElement("nombre_transaction");
			textNode1.setTextContent(nbr_transaction);
			Element textNode2 = document.createElement("investissement_sur_12_ans");
			textNode2.setTextContent(investir);
                        Element textNode3 = document.createElement("type_paiement");
			textNode3.setTextContent(paiement);
                        Element textNode4 = document.createElement("provenance_des_fond");
			textNode4.setTextContent(provenance);
                        Element textNode5 = document.createElement("risque_capital");
			textNode5.setTextContent(capital);
                        Element textNode6 = document.createElement("risque_baisse_revenu");
			textNode6.setTextContent(baisse);
                        Element textNode7 = document.createElement("limite_de_revenu");
			textNode7.setTextContent(limite);
                        Element textNode8 = document.createElement("variation_du_revenu");
			textNode8.setTextContent(variation);
             
			Element nodeElement = document.createElement("page3");
			nodeElement.appendChild(textNode);
			nodeElement.appendChild(textNode1);
			nodeElement.appendChild(textNode2);
                        nodeElement.appendChild(textNode3);
                        nodeElement.appendChild(textNode4);
                        nodeElement.appendChild(textNode5);
                        nodeElement.appendChild(textNode6);
                        nodeElement.appendChild(textNode7);
                        nodeElement.appendChild(textNode8);
                        
			documentElement.appendChild(nodeElement);
			document.replaceChild(documentElement, documentElement);
			Transformer tFormer =
			TransformerFactory.newInstance().newTransformer();
			tFormer.setOutputProperty(OutputKeys.METHOD, "xml");
			Source source = new DOMSource(document);
			Result result = new StreamResult(xmlFile);
			tFormer.transform(source, result);
		
		
		} catch (Exception ex) {
			System.out.println(ex);
			}
    }
    
    public static void insert_souscription4(String montant, String nom_banque, String code_postal){
        
        try {
			File xmlFile = new File("C:\\Users\\semfa\\OneDrive\\Documents\\NetBeansProjects\\B2_ECE_TECH_Projet_SCPI\\src\\XML_code\\bdd_souscription.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFile);
			
			Element documentElement = document.getDocumentElement();
			Element textNode = document.createElement("montant_envoyer");
			textNode.setTextContent(montant);
			Element textNode1 = document.createElement("nom_banque");
			textNode1.setTextContent(nom_banque);
			Element textNode2 = document.createElement("code_postal_banque");
			textNode2.setTextContent(code_postal);
                        
			
			Element nodeElement = document.createElement("page4");
			nodeElement.appendChild(textNode);
			nodeElement.appendChild(textNode1);
			nodeElement.appendChild(textNode2);
                        
			documentElement.appendChild(nodeElement);
			document.replaceChild(documentElement, documentElement);
			Transformer tFormer =
			TransformerFactory.newInstance().newTransformer();
			tFormer.setOutputProperty(OutputKeys.METHOD, "xml");
			Source source = new DOMSource(document);
			Result result = new StreamResult(xmlFile);
			tFormer.transform(source, result);
		
		
		} catch (Exception ex) {
			System.out.println(ex);
			}
    }
    
       
}
