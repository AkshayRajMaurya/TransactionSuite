package maker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import javax.naming.NamingException;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import DbActions.DbClass;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FinalUpdate extends ActionSupport implements ModelDriven<AllUsers>,SessionAware{

	
	private static final long serialVersionUID = 1L;
	private String Customer_Code;
	
	public String getCustomer_Code() {
		return Customer_Code;
	}
	public void setCustomer_Code(String customer_Code) {
		Customer_Code = customer_Code;
		mb.setCustomer_Code(customer_Code);
	}
	SessionMap< String, Object> sm1;
	
	AllUsers mb = new AllUsers();
	Connection con;
	ResultSet rs;

	public AllUsers getMb()
	{
		return mb;
	}
	public void setMb(AllUsers mb)
	{
		this.mb = mb;
	}
	public String execute() throws SQLException, NamingException 
	{
		System.out.println("In Execute of modify");
		if(doOps().equals("valid"))
		{
			addActionMessage("Modification Successful");
			return SUCCESS;
		}
		addActionMessage("Modification Unsuccessful");
		return ERROR;
	}

	@Override
	public AllUsers getModel() {
		// TODO Auto-generated method stub
		return mb;
	}


	public String doOps()throws SQLException, NamingException
	{
		
		System.out.println("In DoOps");
		con = DbClass.getConnection();
		System.out.println(mb.getCustomer_Code());
		
		PreparedStatement pst1=con.prepareStatement("Select * from temporary_records_13742 where Customer_Code='"+mb.getCustomer_Code()+"'");
		ResultSet rs1 = pst1.executeQuery();
		if(rs1.next())
		{
			String record_status = rs1.getString(10);
			if(record_status.equalsIgnoreCase("D"))
			{
				return "request pending for deletion";
			}
			System.out.println("In Temp records");
			PreparedStatement ps = con.prepareStatement("UPDATE temporary_records_13742 SET CUSTOMER_CODE=?,CUSTOMER_NAME=? ,CUSTOMER_ADDRESS1=? ,CUSTOMER_ADDRESS2=? ,CUSTOMER_PIN_CODE=? ,EMAIL_ADDRESS=? ,CONTACT_NO=? ,CONTACT_PERSON=?,MODIFIED_BY=?,MODIFIED_DATE=?,Record_Status=? WHERE CUSTOMER_CODE=?");
			ps.setString(1,mb.getCustomer_Code());
		
			ps.setString(2,mb.getCustomer_Name());
		
			ps.setString(3,mb.getCustomer_Address_1());
			
			ps.setString(4,mb.getCustomer_Address_2());
			
			ps.setInt(5,mb.getCustomer_Pin_Code());
			
			ps.setString(6, mb.getEmail_address());
			
			ps.setLong(7,mb.getContact_Number());
			
			ps.setString(8,mb.getPrimary_Contact_Person());
			
			ps.setString(9, (String) sm1.get("USERNAME"));
			
			ps.setDate(10,  new java.sql.Date(new Date().getTime()));
			ps.setString(11,"M");
			
			ps.setString(12, mb.getCustomer_Code());
			ps.executeUpdate();
			con.commit();	
			
			
			if(record_status.equalsIgnoreCase("DR") || record_status.equalsIgnoreCase("NR") || record_status.equalsIgnoreCase("MR"))
			{
				PreparedStatement pst2 = con.prepareStatement("UPDATE temporary_records_13742 SET Record_Status='M' WHERE Customer_Code='"+mb.getCustomer_Code()+"'");
				pst2.executeUpdate();
			}
			return "valid";
			
		}
		
		PreparedStatement pst2=con.prepareStatement("Select * from permanent_records_13742 where Customer_Code='"+mb.getCustomer_Code()+"'");
		ResultSet rs2 = pst2.executeQuery();
		if(rs2.next())
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
				pst3.setString(10, "M");
				pst3.setString(11, rs2.getString(11));
				pst3.setDate(12, rs2.getDate(12));
				pst3.setString(13, rs2.getString(13));
				pst3.setDate(14, rs2.getDate(14));
				pst3.setString(15, rs2.getString(15));
				pst3.setDate(16, rs2.getDate(16));
				pst3.setString(17, rs2.getString(17));				
				pst3.executeUpdate();
				
				PreparedStatement ps = con.prepareStatement("UPDATE temporary_records_13742 SET Customer_Code =?,Customer_Name =?,Customer_Address1=?,Customer_Address2=?,Customer_Pin_Code=?,Email_Address=?,Contact_No=?,Contact_Person=?,Modified_By=?,Modified_Date=?,Record_Status=? WHERE Customer_Code=?");
				ps.setString(1,mb.getCustomer_Code());
				
				ps.setString(2,mb.getCustomer_Name());
			
				ps.setString(3,mb.getCustomer_Address_1());
				
				ps.setString(4,mb.getCustomer_Address_2());
				
				ps.setInt(5,mb.getCustomer_Pin_Code());
				
				ps.setString(6, mb.getEmail_address());
				
				ps.setLong(7,mb.getContact_Number());
				
				ps.setString(8,mb.getPrimary_Contact_Person());
				
				ps.setString(9, (String) sm1.get("USERNAME"));
				
				ps.setDate(10,  new java.sql.Date(new Date().getTime()));
				
				ps.setString(11,"M");
				
				ps.setString(12, mb.getCustomer_Code());
				ps.executeUpdate();
				con.commit();	
			}
			

		}
		System.out.println("return");
	
		return "valid";
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sm1 = (SessionMap<String, Object>) arg0;
		
	}


}

