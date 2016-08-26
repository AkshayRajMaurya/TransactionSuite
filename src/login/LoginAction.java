package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import DbActions.DbClass;

import com.opensymphony.xwork2.ActionSupport;



public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	public SessionMap<String , Object> sm;



	public String getUsername() {
		return username.trim();
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public void validate() {	
		if(username.isEmpty() ||  username.length()==0)
		{
			addFieldError("username","Please Enter Username");
		}
		if(username.length()>30)
		{
			addFieldError("username","Username Length Exceeded");
		}

		if(password.isEmpty() || password.length()==0)
		{
			addFieldError("password","Please Enter Password");
		}
		else if( password.length()>10 )
		{
			addFieldError("password","Password Length Exceeded");
		}
		else if( Verify(getUsername() , getPassword())==0 )
		{
			addFieldError("password","Incorrect UserName Or Password");
		}
	}


	public int Verify(String U,String P)
	{
		sm.put("USERNAME", U);
		ResultSet rs = null;
		PreparedStatement pstm;
		pstm=null;
		Connection con = null; 
		try {
			con = DbClass.getConnection();
			pstm = con.prepareStatement(" Select * from  users_13742" +
					" where name='"+U+"'");
			rs=pstm.executeQuery();
			while(rs.next())
			{
				if(P.equals(rs.getString(2)) && rs.getString(3).equals("C"))
					{
					addActionMessage("Checker Successfully Logged In");
					return 1;
					}
				if(P.equals(rs.getString(2)) && rs.getString(3).equals("M"))
					{
					addActionMessage("Maker Successfully Logged In");
					return 2;
					}
				else 
					return 0;
			}		
		} catch (NamingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return 0;

	}



	public String execute()
	{

		if( Verify(getUsername() , getPassword())==1 )
		{
			return "CHECKER";
		}

		else if( Verify(getUsername() , getPassword())==2 )
		{
			return "MAKER";
		}
		else if( Verify(getUsername() , getPassword())==0 )
		{
			return "FAIL";
		}
		return "input";
	}
	
	
	@Override
	public void setSession(Map<String, Object> arg0) {
	    this.sm= (SessionMap<String, Object>)arg0;
		
	}

}

