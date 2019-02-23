import java.net.*;
import java.io.*;
public class htmllistal
{                  // first argument file , second is url
    public static void generate(String outputfile , String inputurl ,String nameOfFile) throws Exception{
    URL url;
    InputStream in = null;
        int k=0;
        FileOutputStream out = new FileOutputStream(outputfile);
   try {
       System.out.println("Received Page URL: " + inputurl);
        url = new URL(inputurl);
        URLConnection urlConn = url.openConnection();
   // urlConn.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");

        in = urlConn.getInputStream();  // throws an IOException
        while ((k = in.read()) != -1) {
           // Thread.sleep(200);
           // System.out.print((char) k);
			out.write(k);
        }
        System.out.println(inputurl + " downloaded in htmltemp.txt");
    } catch (MalformedURLException mue) {
         mue.printStackTrace();
    } catch (IOException ioe) {
         ioe.printStackTrace();
    } finally {
        //out.write((char)126);
        out.flush();
        out.close();
        try {
            
            if (in != null) in.close();
        } catch (IOException ioe) {
            // nothing to see here
        }
    }
       
        ListalMatcher.startMatching(outputfile,nameOfFile+".txt");
       
}
    
}