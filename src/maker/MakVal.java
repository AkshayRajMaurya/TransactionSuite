package maker;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.catalina.Session;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import DbActions.DbClass;

import com.opensymphony.xwork2.ActionSupport;

public class MakVal extends ActionSupport implements SessionAware
{
	private String cust_code,cust_name,cust_add1,cust_add2,cust_pincode,email,contact_num
	,primary_contact_person,active_flag;

	public SessionMap<String , Object> sm;
	
	@Override
	public void setSession(Map<String, Object> arg0) 
	{
		this.sm = (SessionMap<String, Object>) arg0;
	}
	
	public String getCust_code() {
		return cust_code;
	}

	public void setCust_code(String cust_code) {
		this.cust_code = cust_code;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_add1() {
		return cust_add1;
	}

	public void setCust_add1(String cust_add1) {
		this.cust_add1 = cust_add1;
	}

	public String getCust_add2() {
		return cust_add2;
	}

	public void setCust_add2(String cust_add2) {
		this.cust_add2 = cust_add2;
	}

	public String getCust_pincode() {
		return cust_pincode;
	}

	public void setCust_pincode(String cust_pincode) {
		this.cust_pincode = cust_pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact_num() {
		return contact_num;
	}

	public void setContact_num(String contact_num) {
		this.contact_num = contact_num;
	}

	public String getPrimary_contact_person() {
		return primary_contact_person;
	}

	public void setPrimary_contact_person(String primary_contact_person) {
		this.primary_contact_person = primary_contact_person;
	}

	public String getActive_flag() {
		return active_flag;
	}

	public void setActive_flag(String active_flag) {
		this.active_flag = active_flag;
	}

	public String execute()
	{
		if(adding().equalsIgnoreCase("valid"))
		{
			addActionMessage("Record Added Successfully");
			return SUCCESS;
		}
		addActionMessage("Record Addition Unsucessful");
		return ERROR;
	}
	
	public String adding()
	{
		try
		{
			
			Connection con = DbClass.getConnection();  //Step-3
			
			PreparedStatement pst = con.prepareStatement("INSERT INTO temporary_records_13742 VALUES(seq_13778.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			System.out.println((String)sm.get("USERNAME"));
			
			pst.setString(1, getCust_code());
			pst.setString(2, getCust_name());
			pst.setString(3, getCust_add1());
			pst.setString(4, getCust_add2());
			pst.setInt(5, Integer.parseInt(getCust_pincode()));
			pst.setString(6, getEmail());
			pst.setLong(7, Long.parseLong(getContact_num()));
			pst.setString(8, getPrimary_contact_person());
			pst.setString(9,"N");
			pst.setString(10,"A");
			pst.setDate(11,new java.sql.Date(new Date().getTime()));
			pst.setString(12,(String)sm.get("USERNAME"));
			pst.setString(13,null);
			pst.setString(14,null);
			pst.setString(15,null);
			pst.setString(16,null);
			pst.executeUpdate();
			DbClass.freeConnection(con);
				return "valid";
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "invalid";
	}

	}
