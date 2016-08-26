package DbActions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DbClass 
{
	static Connection con = null;
	static PreparedStatement pt = null;
	static ResultSet rs = null;
	public static Connection getConnection() throws NamingException
	{
		
		try
		{
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/orcl");
			con = ds.getConnection();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}

	public static void freeConnection(Connection c) {
	    try {
	        c.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
