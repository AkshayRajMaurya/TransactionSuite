package maker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import DbActions.DbClass;

import com.opensymphony.xwork2.ActionSupport;

public class SearchForMaker extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private String CustomerInfo;
	ArrayList<AllUsers> list=new ArrayList<AllUsers>(); 
	
	
	public ArrayList<AllUsers> getList() {
		return list;
	}

	public void setList(ArrayList<AllUsers> list) {
		this.list = list;
	}

	public String getCustomerInfo() {
		return CustomerInfo;
	}

	public void setCustomerInfo(String customerInfo) {
		CustomerInfo = customerInfo;
	}
	
	
	
	public String execute1()
	{
		int num;
		String st=getCustomerInfo()+" null ";
		if(st.equals(" null ")||(getCustomerInfo()==null))
			num=0;
		else
			num=1;
		int i=searchCustomer(num);
		if(i==1)
		return SUCCESS;
		else
		return ERROR;
	}
	
	public String execute2()
	{
		int num=2;
		int i=searchCustomer(num);
		if(i==1)
			{
			
		 return SUCCESS;}
		else
		return ERROR;
	} 
	public String execute3()
	{
		int num=0;
		int i=searchCustomer(num);
		if(i==1)
		return SUCCESS;
		else
		return ERROR;
	} 
	public int searchCustomer(int i)
	{
		
		int select=i;
		String s=getCustomerInfo();
		ResultSet rs = null;
		PreparedStatement pstm;
		pstm=null;
		Connection con = null; 
		try {
			con = DbClass.getConnection();
			if(select==1)
			    pstm = con.prepareStatement(" (Select * from  permanent_records_13742 where CUSTOMER_CODE='"+s+"') union (Select * from  temporary_records_13742 where CUSTOMER_CODE='"+s+"')");
			else if(select==2)
				pstm = con.prepareStatement("(Select * from  permanent_records_13742) union (Select * from  temporary_records_13742)");
			else
				pstm = con.prepareStatement(" (Select * from  permanent_records_13742) union (Select * from  temporary_records_13742)");	
			rs=pstm.executeQuery();
			while(rs.next())
			{
				AllUsers user=new AllUsers();  
				
			    user.setCustomer_ID(rs.getInt(1));
			    user.setCustomer_Code(rs.getString(2));
			    
			    user.setCustomer_Name(rs.getString(3));  
			    user.setCustomer_Address_1(rs.getString(4)); 
			   
			    user.setCustomer_Address_2(rs.getString(5)); 
			    user.setCustomer_Pin_Code(rs.getInt(6));
			   
			    user.setEmail_address(rs.getString(7)); 
			    user.setContact_Number(rs.getLong(8)); 
			    
			    user.setPrimary_Contact_Person(rs.getString(9)); 
			    user.setRecord_Status(rs.getString(10)); 
			    user.setActive_Inactive_Flag(rs.getString(11)); 
			    user.setCreate_Date(rs.getString(12)); 
			    
			    user.setCreated_By(rs.getString(13)); 
			    user.setModified_Date(rs.getString(14)); 
			    user.setModified_By(rs.getString(15)); 
			    user.setAuthorized_Date(rs.getString(16)); 
			    user.setAuthorized_By(rs.getString(17)); 
			    list.add(user);     
				
				
			}	
			return 1;
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

	
	

}
