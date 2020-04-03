package signature;
        
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.commons.io.IOUtils;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;


public class UniversignRPCServerSign
{
	private static final String LOGIN = "semfanou@gmail.com";
	private static final String PASSWORD = "selorD07-";
	private static final String PATH_TO_PDF = "C:\\Users\\semfa\\bureau.pdf"; //path to the PDF to be signed
	private static final String PATH_TO_SIGNED_PDF = "C:\\Users\\bureau.pdf"; //path where to save the signed PDF
	
	public static void main(String[] args)
		throws Exception
	{
		Authenticator.setDefault(new HTTPAuth(LOGIN, PASSWORD));
		byte[] pdf = loadPDF(PATH_TO_PDF);
		serverSign(pdf);
	}
	
	private static void serverSign(byte[] pdf) throws Exception
	{
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setServerURL(new URL("https://ws.universign.eu/sign/rpc/"));
		XmlRpcClient client = new XmlRpcClient();
		client.setConfig(config);
		
		//exemple data for signature field
		Map signField = new HashMap();
		signField.put("page", 1);
		signField.put("x", 100);
		signField.put("y", 500);
		Map options = new HashMap();
		options.put("signatureField", signField);
		
		Object[] params = new Object[2];
		params[0] = pdf;
		params[1] = options;
		
		byte[] result = (byte[])client.execute("signer.signWithOptions", params);
		FileOutputStream fos = new FileOutputStream(PATH_TO_SIGNED_PDF);
		IOUtils.write(result, fos);
		fos.close();
	}
	
	private static byte[] loadPDF(String filename) throws IOException
	{
		FileInputStream fis = new FileInputStream(filename);
		byte[] data = IOUtils.toByteArray(fis);
		fis.close();
		return data;
	}
	
	
	private static class HTTPAuth extends Authenticator
	{
		private String login;
		private char[] password;

		/**
		 * Creates a new <code>HTTPAuth</code>.
		 *
		 * @param login the login
		 * @param password the password
		 */
		public HTTPAuth(String login, String password)
		{
			this.login = login;
			this.password = password.toCharArray();
		}

		/** @see Authenticator */
		protected PasswordAuthentication getPasswordAuthentication()
		{
			return new PasswordAuthentication(login, password);
		}
	}
}

