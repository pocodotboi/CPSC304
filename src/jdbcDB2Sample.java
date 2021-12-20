//Project File for CPSC 304 101 (Lab Section: T1K)
//Team: Richarde, John, Jane 
import java.sql.*; 
 
class jdbcDB2Sample 
{
    public static void main(String argv[]) 
    {
       Connection con = null;

       if (argv.length != 2)
       {
	   System.out.println("Usage: jdbcDB2Sample test <userid> <pass>");
	   System.exit(-1);
       }

       String userid = argv[0];
       String passwd = argv[1];
       
       String url = "jdbc:example.com" + userid;

       try
       {
	   System.out.println("Loading driver ...");

	   Class.forName("COM.ibm.db2.jdbc.net.DB2Driver");

	   System.out.println("Driver loaded.");
       }
       catch (Exception e)
       {
	   System.out.println("Unable to load driver\n" + e);
	   System.exit(-1);
       }

       try 
       {  
	   System.out.println("Connecting to NetDB2 ...");
 
	   con = DriverManager.getConnection(url, userid, passwd);
 
	   System.out.println("Connection successful.");
	    
       } 
       catch( Exception e ) 
       {
	   System.out.println("Connection failed\n" + e);
       }

       try
       {
	   System.out.println("Selecting branch_name from branch table");

	   Statement stmt = con.createStatement();
	   ResultSet rs = stmt.executeQuery("SELECT branch_name FROM branch");

	   while(rs.next())
	   {
	       System.out.println(rs.getString(1));
	   }
       }
       catch (SQLException ex)
       {
	   System.out.println(ex);
       }
    }
}


  
   
