public class filereaderstring
{
	public static void main(String args[]) throws Exception
	{String k=null;String m=null;
		java.util.ArrayList<String> fl = llffn.getNames(args[0]);
		java.util.Iterator<String> itr = fl.iterator();
			java.io.FileInputStream fis = new java.io.FileInputStream("folder links.txt");
		java.util.Scanner in = new java.util.Scanner(fis);
		
		while(in.hasNextLine() ){
			k=in.nextLine();
			m=itr.next();
			try
		{
		int pm = piccount.getCount(k);
		GlobalFlags.picCount = pm;
		//System.out.println(pagecount + "   " + pm);
		lmd2.generateLinks(k,m);
		}
		catch(java.util.NoSuchElementException ne)
		{
			System.out.println("all strings copied");
		}
		catch(java.io.FileNotFoundException fe)
		{
			System.out.println("invalid link " + k);
		}
		//lmd2.generateLinks(k,pagecount);
		}
		
		
	}
}