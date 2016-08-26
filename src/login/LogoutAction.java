package login;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	public SessionMap<String , Object> sm;

	public String execute()
	{
		sm.invalidate();
		addActionMessage("You Have Been SuccessFully Logged Out");
		return SUCCESS;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sm= (SessionMap<String, Object>)arg0;

	}
}
