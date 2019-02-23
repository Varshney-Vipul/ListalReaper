public class llffn //listal links from folder names

{
	public static java.util.ArrayList<String> getNames(String args) throws Exception
	{
		java.util.ArrayList<String> fl = listfolders.getFoldersList(args);
		java.io.FileOutputStream fos = new java.io.FileOutputStream("folder links.txt");
		java.io.PrintWriter pw = new java.io.PrintWriter(fos);
		for(String k:fl)
		{
			pw.println("https://www.listal.com/" + k.replaceAll(" ","-") + "/pictures/");
		}
		pw.flush();
		return fl;
	}
	
}