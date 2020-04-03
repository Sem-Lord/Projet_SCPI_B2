package signature;

import interface_scpi.souscription;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;


public class UniversignRPCRequest {

	private static final String PATH_TO_PDF = "C:\\Users\\semfa\\"+interface_scpi.souscription.nom_pdf+".pdf"; //path to the PDF to be signed

	public static void main(String[] args) throws IOException {
		doRequest("semfanou@gmail.com", "selorD07-", loadDoc());
	}

	public static byte[] loadDoc() throws IOException {
		FileInputStream fis = new FileInputStream(PATH_TO_PDF);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] data = new byte[1024];
		while (fis.read(data) > -1) {
			baos.write(data, 0, data.length);
		}
		fis.close();
		return baos.toByteArray();
	}

	public static String doRequest(String login, String password, byte[] pdfData) {
		try {

			XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
			config.setServerURL(new URL("https://ws.universign.eu/sign/rpc/"));
			config.setBasicUserName(login);
			config.setBasicPassword(password);
			XmlRpcClient client = new XmlRpcClient();
			client.setConfig(config);

			// first call to request a signature
			Map req = new HashMap();
			Map signer = new HashMap();
			Map doc = new HashMap();
			Map signField = new HashMap();

			req.put("signers", new Object[] { signer });
			req.put("documents", new Object[] { doc });
			req.put("certificateType", "simple" );
			req.put("language", "fr");

			// the signer information
			signer.put("firstname", "A");
			signer.put("lastname", "B");
			signer.put("successURL", "http://www.google.fr/search?q=success");
			signer.put("failURL", "http://www.google.fr/search?q=fail");
			signer.put("cancelURL", "http://www.google.fr/search?q=cancel");
			signer.put("signatureField", signField);
			// the signature field placement
			signField.put("x", 0);
			signField.put("y", 0);
			signField.put("page", -1);

			// the document information
			doc.put("content", pdfData);
			doc.put("name", "test.pdf");

			Map res = (Map) client.execute("requester.requestTransaction",
					new Object[] { req });

			// must be saved for the second call
			System.out.println("ID: " + res.get("id"));
			// the URL where the client should be redirected to
                       
			System.out.println("ID: " + res.get("url"));
                        String lien = res.get("url").toString();
			return lien;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	private static void getDocuments(String login, String password, String id) throws Exception
	{
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setServerURL(new URL("https://ws.universign.eu/sign/rpc/"));
		config.setBasicUserName(login);
        config.setBasicPassword(password);
		XmlRpcClient client = new XmlRpcClient();
		client.setConfig(config);
		
		Object[] params = new Object[1];
		params[0] = id;
		
		Object[] result = (Object[])client.execute("requester.getDocuments", params);
		for (Object o : result) {
			Map m = (Map)o;
			System.out.println("fileName: " + m.get("fileName"));
			//The key "content" leads to the binary content of the signed document
		}
	}
}
