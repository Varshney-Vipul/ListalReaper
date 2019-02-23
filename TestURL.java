import java.net.*;
public class TestURL
{
	public static void main(String[] args) throws Exception
	{
		URL u = new URL("https://www.listal.com/holly-peers/pictures");
		String num = "";
		URLConnection con = u.openConnection();
		con.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		//urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

		java.io.InputStream is = con.getInputStream();
	//java.io.InputStream is = u.openStream();
	int k=0;
		while((k=is.read())!=-1)
		{
			System.out.print((char)k);
		}
		
	}
}