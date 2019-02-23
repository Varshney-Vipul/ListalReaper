import java.net.*;
public class piccount
{
	public static int getCount(String args) throws Exception
	{
		String num = "";
		URL u = null;
		URLConnection con = null;
		
		java.io.InputStream is = null;
		try{
		u = new URL(args);
		System.out.println(args);
		con = u.openConnection();
		is = con.getInputStream();
		}catch(Exception e)
		{
		System.out.println("yoyoy");
		}
	//java.io.InputStream is = u.openStream();
	int k=0;
	
	System.out.println(args);
	if(is!=null)
		while((k=is.read())!=-1)
		{
		//	System.out.print((char)k);
		//	System.out.println("herhehr");
			if(k==112)
			{
				if((k=is.read())==105)
			{
					if((k=is.read())==99)
			{
				if((k=is.read())==116)
			{
			if((k=is.read())==117)
			{
			if((k=is.read())==114)
			{
			if((k=is.read())==101)
			{
			if((k=is.read())==99)
			{
			if((k=is.read())==111)
			{
			if((k=is.read())==117)
			{
			if((k=is.read())==110)
			{
			if((k=is.read())==116)
			{
				//System.out.println(args);
				while((k=is.read())!=62);
				//System.out.print((char)k + "");
				while((k=is.read())!=60)
				{
					//System.out.println((char)k + "");
				
					num = num + (char)k;
					//System.out.println(num);
				}
				break;
			}	
			}	
			}	
			}	
			}	
			}	
			}	
			}	
			}
			}		
			}
			}
			
		}
		//System.out.println(num);
		if(!num.equals(""))
		return Integer.parseInt(num);
		else
		return 0;
	}
}