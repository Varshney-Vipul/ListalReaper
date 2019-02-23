import java.io.*;
public class lmd2 // listal mass downloader
{
    public static void generateLinks(String iurl,String nameOfFile) throws Exception
    {
        int picCount = 0;
        String initial = iurl;
        int k=2;
        double upperLimit = 0;
        FileInputStream fis = null;
        GlobalFlags.shouldGenerateMoreLinks = true;
        try{
            fis = new FileInputStream(nameOfFile + "-UpperLimit.txt");
            System.out.println("Received file name: " + nameOfFile);
            java.util.Scanner in = new java.util.Scanner(fis);
            upperLimit = Double.parseDouble(in.nextLine());
            GlobalFlags.latestImageString = upperLimit;
            GlobalFlags.nextLatestImageString = upperLimit;
        }catch(IOException e){
            GlobalFlags.latestImageString = upperLimit;
            GlobalFlags.nextLatestImageString = upperLimit;
            System.out.println("Upper limit file not found: "+nameOfFile + "-UpperLimit.txt  .. starting with upperLimit "+   GlobalFlags.latestImageString );
            if(fis != null)
            fis.close();
        }
        k=2;
        htmllistal.generate("htmltemp.txt",initial,nameOfFile);
        while((GlobalFlags.isPicCountAchieved() && GlobalFlags.shouldGenerateMoreLinks))
        {
            String temp = initial + "/" +k;
            htmllistal.generate("htmltemp.txt",temp,nameOfFile);
            k++;
            System.out.println(k);
        }
        System.out.println(GlobalFlags.nextLatestImageString);
        GlobalFlags.localPicCount = 0;
        GlobalFlags.picCount = 0;
        ListalFilter.filterLinks(nameOfFile+".txt");
        PrintWriter pw = new PrintWriter(nameOfFile + "-UpperLimit.txt");
        pw.printf("%.0f\n", GlobalFlags.nextLatestImageString);
        pw.flush();
        pw.close();
    }
}