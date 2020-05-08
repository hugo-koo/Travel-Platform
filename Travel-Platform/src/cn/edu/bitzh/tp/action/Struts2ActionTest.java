package cn.edu.bitzh.tp.action;
import com.opensymphony.xwork2.*;
public class Struts2ActionTest extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3998922255627522722L;
	private String result;
	public String test() {
		this.result=Action.SUCCESS;
		return result;
	}
}
