// http://www.listal.com/xenia-deli/pictures
import java.io.File;
 
public class listfolders
{
     static java.util.ArrayList<String> RecursivePrint(File[] arr) 
     {
		 java.util.ArrayList<String> temp=new java.util.ArrayList<String>();
         // terminate condition
        // if(index == arr.length)
        //     return;
          
         // tabs for internal levels
        // for (int i = 0; i < level; i++)
        //     System.out.print("\t");
          
         // for files
		 for(int k=0;k<arr.length;k++)
		 {
			 if(arr[k].isDirectory())
			 {
				 temp.add(arr[k].getName());
			 }
		 }
        /* if(arr[index].isFile())
             System.out.println(arr[index].getName());*/
          
         // for sub-directories
       /*  else if(arr[index].isDirectory())
         {
             System.out.println("[" + arr[index].getName() + "]");
              
             // recursion for sub-directories
            // RecursivePrint(arr[index].listFiles(), 0, level + 1);
         }
           */
         // recursion for main directory
        // RecursivePrint(arr,++index, level);
		return temp;
    }
     
    // Driver Method
    public static java.util.ArrayList<String> getFoldersList(String args)
    {
        // Provide full path for directory(change accordingly)  
        String maindirpath = args;
		java.util.ArrayList<String> fl=null;
                 
        // File object
        File maindir = new File(maindirpath);
          
        if(maindir.exists()/* && maindir.isDirectory()*/)
        {
            // array for files and sub-directories 
            // of directory pointed by maindir
            File arr[] = maindir.listFiles();
             fl = RecursivePrint(arr);
            // Calling recursive method
            //RecursivePrint(arr,0,0); 
       } 
	 /*  for(String k:fl)
	   {
		   System.out.println(k);
	   }*/
	   return fl;
    }
}