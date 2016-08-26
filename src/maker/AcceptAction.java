package maker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import DbActions.DbClass;

import com.opensymphony.xwork2.ActionSupport;

public class AcceptAction extends ActionSupport implements SessionAware
{
	private String [] checks;
	private String buttonA;
	private String buttonR;

	SessionMap<String, Object> sm2;
	
	public String[] getChecks() {
		return checks;
	}

	public void setChecks(String[] checks) {
		this.checks = checks;
	}

	public String getButtonA() {
		return buttonA;
	}

	public void setButtonA(String buttonA) {
		this.buttonA = buttonA;
	}

	public String getButtonR() {
		return buttonR;
	}

	public void setButtonR(String buttonR) {
		this.buttonR = buttonR;
	}

	public String execute()
	{
		if(getButtonA() != null)
		{
			accepting();
			addActionMessage("Requested Records Accepted");
			return SUCCESS;
		}
		if(getButtonR() != null)
		{
			rejecting();
			addActionMessage("Requested Records Rejected");
			return SUCCESS;
		}
		addActionMessage("Request Unsuccessful");
		return ERROR;
	}
	
	public void accepting()
	{
		try
		{
			
			Connection con = DbClass.getConnection();  
			
			for(int i=0;i<checks.length;i++)
			{
				PreparedStatement pst = con.prepareStatement("SELECT * from temporary_records_13742 where Customer_Code ='"+checks[i]+"'");
				ResultSet rs = pst.executeQuery();
				while(rs.next())
				{
					if(rs.getString(10).equalsIgnoreCase("N")) 
					{
						PreparedStatement pst1 = con.prepareStatement("INSERT INTO permanent_records_13742 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						pst1.setInt(1, rs.getInt(1));
						pst1.setString(2, rs.getString(2));
						pst1.setString(3, rs.getString(3));
						pst1.setString(4, rs.getString(4));
						pst1.setString(5, rs.getString(5));
						pst1.setInt(6, rs.getInt(6));
						pst1.setString(7, rs.getString(7));
						pst1.setLong(8, rs.getLong(8));
						pst1.setString(9, rs.getString(9));
						pst1.setString(10, "A");
						pst1.setString(11, rs.getString(11));
						pst1.setDate(12, rs.getDate(12));
						pst1.setString(13, rs.getString(13));
						pst1.setDate(14, rs.getDate(14));
						pst1.setString(15, rs.getString(15));
						pst1.setDate(16,  new java.sql.Date(new Date().getTime()));
						pst1.setString(17, (String) sm2.get("USERNAME"));						
						pst1.executeUpdate();
						
						PreparedStatement pst2 = con.prepareStatement("DELETE from temporary_records_13742 where Customer_Code='"+checks[i]+"'");
						pst2.executeUpdate();
					}
					if(rs.getString(10).equalsIgnoreCase("M"))
					{
						int a=0;
						
						PreparedStatement pst1=con.prepareStatement("SELECT COUNT(*) FROM permanent_records_13742 WHERE Customer_Code='"+checks[i]+"'");
						ResultSet rs1 = pst1.executeQuery();
						rs1.next();
						int count = rs1.getInt(1);
						
						if(count>0)
						{
						pst1 = con.prepareStatement("UPDATE permanent_records_13742 SET Customer_ID=?,Customer_Code=?,Customer_Name=?,Customer_Address1=,Customer_Address2=?,Customer_Pin_Code=?,Email_Address=?,Contact_No='?,Contact_Person=?,Record_Status=?,Flag=?,Create_Date=?,Created_By=?,Modified_Date=?,Modified_By=?,Auth_Date=?,Auth_By=? WHERE Customer_Code='"+checks[i]+"'");
						pst1.setInt(1, rs.getInt(1));
						pst1.setString(2, rs.getString(2));
						pst1.setString(3, rs.getString(3));
						pst1.setString(4, rs.getString(4));
						pst1.setString(5, rs.getString(5));
						pst1.setInt(6, rs.getInt(6));
						pst1.setString(7, rs.getString(7));
						pst1.setLong(8, rs.getLong(8));
						pst1.setString(9, rs.getString(9));
						pst1.setString(10, "A");
						pst1.setString(11, rs.getString(11));
						pst1.setDate(12, rs.getDate(12));
						pst1.setString(13, rs.getString(13));
						pst1.setDate(14, rs.getDate(14));
						pst1.setString(15, rs.getString(15));
						pst1.setDate(16, rs.getDate(16));
						pst1.setString(17, rs.getString(17));				
						a=pst1.executeUpdate();
						}
						if(a==0)
						{
						pst1 = con.prepareStatement("INSERT INTO permanent_records_13742 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						pst1.setInt(1, rs.getInt(1));
						pst1.setString(2, rs.getString(2));
						pst1.setString(3, rs.getString(3));
						pst1.setString(4, rs.getString(4));
						pst1.setString(5, rs.getString(5));
						pst1.setInt(6, rs.getInt(6));
						pst1.setString(7, rs.getString(7));
						pst1.setLong(8, rs.getLong(8));
						pst1.setString(9, rs.getString(9));
						pst1.setString(10, "A");
						pst1.setString(11, rs.getString(11));
						pst1.setDate(12, rs.getDate(12));
						pst1.setString(13, rs.getString(13));
						pst1.setDate(14, rs.getDate(14));
						pst1.setString(15, rs.getString(15));
						pst1.setDate(16,  new java.sql.Date(new Date().getTime()));
						pst1.setString(17, (String) sm2.get("USERNAME"));						
						pst1.executeUpdate();
						}
						
						PreparedStatement pst2 = con.prepareStatement("DELETE from temporary_records_13742 where Customer_Code='"+checks[i]+"'");
						pst2.executeUpdate();
					}
					if(rs.getString(10).equalsIgnoreCase("D"))
					{
						PreparedStatement pst1 = con.prepareStatement("UPDATE permanent_records_13742 SET Flag='I' where Customer_Code='"+checks[i]+"'");
						pst1.executeUpdate();
						PreparedStatement pst2 = con.prepareStatement("DELETE from temporary_records_13742 where Customer_Code='"+checks[i]+"'");
						pst2.executeUpdate();
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public void rejecting()
	{
		try
		{
			Context c = new InitialContext();  //Step-1
			DataSource d = (DataSource) c.lookup("java:/comp/env/jdbc/orcl");  //Step-2
			Connection con = d.getConnection();  //Step-3
			
			for(int i=0;i<checks.length;i++)
			{
				PreparedStatement pst = con.prepareStatement("SELECT * from temporary_records_13742 where Customer_Code ='"+checks[i]+"'");
				ResultSet rs = pst.executeQuery();
				while(rs.next())
				{ 
					
				   	
					if(rs.getString(10).equalsIgnoreCase("N"))
					{
						PreparedStatement pst1 = con.prepareStatement("UPDATE temporary_records_13742 SET Record_Status='NR'where Customer_Code='"+checks[i]+"'");
						pst1.executeUpdate();
					}
					if(rs.getString(10).equalsIgnoreCase("M"))
					{
						PreparedStatement pst1 = con.prepareStatement("UPDATE temporary_records_13742 SET Record_Status='MR'where Customer_Code='"+checks[i]+"'");
						pst1.executeUpdate();
					}
					if(rs.getString(10).equalsIgnoreCase("D"))
					{
						PreparedStatement pst1 = con.prepareStatement("UPDATE temporary_records_13742 SET Record_Status='DR'where Customer_Code='"+checks[i]+"'");
						pst1.executeUpdate();
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void setSession(Map<String, Object> arg0) 
	{
		this.sm2 = (SessionMap<String, Object>) arg0;
	}
}