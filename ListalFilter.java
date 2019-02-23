import java.io.*;
public class ListalFilter
{
    public static void filterLinks(String nameOfFile) throws Exception
    {
        FileInputStream fis = new FileInputStream(nameOfFile);
        java.util.Scanner in = new java.util.Scanner(fis);
        PrintWriter pw = new PrintWriter(nameOfFile + " filtered.txt");
        String line="";
        while(in.hasNextLine())
        {
            line = in.nextLine();
            line = "https://ilarge.lisimg.com/image/" + line + "/1020full.jpg";
            pw.println(line);
            
        }
        pw.flush();
        pw.close();
        
    }
}