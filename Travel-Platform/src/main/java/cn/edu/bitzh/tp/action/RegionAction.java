package cn.edu.bitzh.tp.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.bitzh.tp.model.Region;
import cn.edu.bitzh.tp.service.IRegionService;
import cn.edu.bitzh.tp.service.impl.RegionService;

/**
 * @author 古学懂_Victor
 */
public class RegionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
	IRegionService rs = (RegionService) applicationContext.getBean("regionService");
	private Region region;
	private List<Region> regions;
	/**
	 * type可以取值"listContineins", "listChildren"
	 */
	private String type = "";
	/**
	 * 若type为"listChildren", 需要提供pid
	 */
	private int pid = 0;
	/**
	 * 若type为空, 需要提供id
	 */
	private int id = 1;

	public RegionAction() {
		System.out.println("RA");
		System.out.println("Param " + this.type);
	}

	/**
	 * 
	 */
	public String execute() {
		if (type.equals("listContineins")) {
			regions = rs.listContineins();
		} else if (type.equals("listChildren")) {
			regions = rs.listChildRegions(pid);
		} else if (type.equals("")) {
			region = rs.get(id);
		}
		System.out.println("ParamEx " + this.type);
		return Action.SUCCESS;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public void listContineins() {
		this.regions = rs.listContineins();
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}