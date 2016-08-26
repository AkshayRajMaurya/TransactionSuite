package maker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import DbActions.DbClass;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetRecordToUpdate extends ActionSupport implements ServletRequestAware,ApplicationAware
{
	private static final long serialVersionUID = 1L;

	static Connection conn;
	ResultSet rs12 = null;
	Statement st12 = null;

	HttpServletRequest request;
	Map m;
	public String execute() throws NamingException, SQLException 
	{
		String str = request.getParameter("CustomerCode");

		conn = DbClass.getConnection();   
		if(conn!=null)
		{
			PreparedStatement ps=conn.prepareStatement("(select * from temporary_records_13742 where CUSTOMER_CODE='"+str+"') union (select * from permanent_records_13742 where CUSTOMER_CODE='"+str+"')");
			
			rs12 = ps.executeQuery();
			while(rs12.next())
			{
				System.out.println(rs12.getString("CUSTOMER_ID"));
				m.put("id",rs12.getString("CUSTOMER_ID"));
				m.put("code",rs12.getString("CUSTOMER_CODE"));
				m.put("name",rs12.getString("CUSTOMER_NAME"));
				m.put("add1",rs12.getString("CUSTOMER_ADDRESS1"));
				m.put("add2",rs12.getString("CUSTOMER_ADDRESS2"));
				m.put("pin", rs12.getInt("CUSTOMER_PIN_CODE"));
				m.put("email", rs12.getString("EMAIL_ADDRESS"));
				m.put("record", rs12.getString("RECORD_STATUS"));
				m.put("number",rs12.getLong("CONTACT_NO"));
				m.put("person",rs12.getString("CONTACT_PERSON"));
			}

			return SUCCESS;
		}

		return ERROR;

	}

	@Override
	public void setApplication(Map m) {
		// TODO Auto-generated method stub
		this.m = m; 
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	public HttpServletRequest getServletRequest()
	{
		return request;
	}
}
