package maker;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import DbActions.DbClass;
import java.sql.*;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteForMaker extends ActionSupport implements ServletRequestAware
{
	private static final long serialVersionUID = 1L;


	static Connection con;
	ResultSet rs3 = null;
	PreparedStatement ps1 = null;
	HttpServletRequest request; 
	public String execute() 
	{
		if(doOPs().equals("valid"))
			{
			addActionMessage("Requested Records Deletion Successfull");
			return SUCCESS;
			}
		else if(doOPs().equals("Pending"))
			{
			addActionMessage("CANNOT DELETE ... PREVIOUS REQUEST STATUS PENDING... WAIT TILL CONFIRMATION");
			return SUCCESS;
			}
		addActionMessage("Requested Records Deletion Unsuccessfull");
		return ERROR;
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return request;
	}


	public String doOPs() 
	{
		try {
			con = DbClass.getConnection();
		} catch (NamingException e) {
			
			e.printStackTrace();
		}  	
		String cv[] = request.getParameterValues("rdel");

		if(con!=null)
		{
			for(int i=0;i<cv.length;i++)
			{
				String q=null;
				String received = cv[i];
				String exp[]=received.split("~~~");
				String code=exp[0];
				
				String status=exp[1];
				
				PreparedStatement pst2;
				try {
					pst2 = con.prepareStatement("Select * from permanent_records_13742 where Customer_Code='"+code+"'");
				
				ResultSet rs2 = pst2.executeQuery();
				if(rs2.next())
				{
					if(status.equals("A"))
					{
						System.out.println("In Permanent records");
						if(rs2.getString(10).equalsIgnoreCase("A"))
						{
							PreparedStatement pst3 = con.prepareStatement("INSERT INTO temporary_records_13742 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
							pst3.setInt(1, rs2.getInt(1));
							pst3.setString(2, rs2.getString(2));
							pst3.setString(3, rs2.getString(3));
							pst3.setString(4, rs2.getString(4));
							pst3.setString(5, rs2.getString(5));
							pst3.setInt(6, rs2.getInt(6));
							pst3.setString(7, rs2.getString(7));
							pst3.setLong(8, rs2.getLong(8));
							pst3.setString(9, rs2.getString(9));
							pst3.setString(10, "D");
							pst3.setString(11, rs2.getString(11));
							pst3.setDate(12, rs2.getDate(12));
							pst3.setString(13, rs2.getString(13));
							pst3.setDate(14, rs2.getDate(14));
							pst3.setString(15, rs2.getString(15));
							pst3.setDate(16, rs2.getDate(16));
							pst3.setString(17, rs2.getString(17));				
							pst3.executeUpdate();

							con.commit();

						}
						return "valid";
					}
				}
				System.out.println("In Temporary records");
				ps1=con.prepareStatement("delete from temporary_records_13742 where CUSTOMER_CODE=(?)");
				ps1.setString(1, code);
				ps1.executeUpdate();
				con.commit();
				return "valid";
				} catch (SQLException e) {
					
					e.printStackTrace();
					return "Pending";
				}

			}
		}
		return "invalid";

	}
	

}
