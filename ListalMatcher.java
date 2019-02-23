import java.io.*;
public class ListalMatcher{
    public static void startMatching(String inputFile, String outputFile) throws IOException,Exception{
        FileInputStream fis = new FileInputStream(inputFile);
        FileOutputStream fos = new FileOutputStream(outputFile,true);
        java.util.Scanner in = new java.util.Scanner(fis);
        String anyString = "lisimg.com/";
        char[] stringChars = new char[anyString.length()];
        PrintWriter pw = new PrintWriter(fos);
        for(int k=0;k<anyString.length();k++){
            stringChars[k] = anyString.charAt(k);
           // System.out.println(stringChars[k]);
        }
        char delimiter = '/';
        String nextChar = "";
        int currentIndex = 0;
        int k = 0;
        double nextLimit = 0.0;
        boolean skipFirst = true;
       System.out.println("Extracting links from :" + inputFile);
       while((k=fis.read())!=-1){
           // System.out.print((char)k);
            if((int)stringChars[currentIndex] == k){
                //System.out.print((char)k);
                currentIndex++;
                if(currentIndex == stringChars.length){
                    //System.out.println("here");
                    if(skipFirst){
                        skipFirst = false;
                        currentIndex = 0;
                        continue;
                    }
                    nextChar = "";
                    while((k=fis.read()) != (int)delimiter){
                     //   System.out.print((char)k);
                        nextChar += (char) k;
                    }
                    try{
                    currentIndex = 0;
                    GlobalFlags.localPicCount++;
                    
                    double temp = Double.parseDouble(nextChar);
                   // Thread.sleep(1000);
                   
                    if(temp > GlobalFlags.nextLatestImageString){
                        System.out.print("upper limit " + temp);
                        GlobalFlags.nextLatestImageString = temp;
                    }
                    if(temp!=GlobalFlags.latestImageString){               //printing only latest images
                        System.out.println("found image "+nextChar);
                       pw.println(nextChar);
                    }else{
                        GlobalFlags.shouldGenerateMoreLinks = false;
                        pw.flush();
                        pw.close();
                        fis.close();
                        return;
                    }
                    
                    }catch(NumberFormatException e){
                        System.out.println("converting this string to double: " + nextChar);
                    }
                }
            }else{
                currentIndex = 0;
            }
        }
        pw.flush();
        pw.close();
    }
}