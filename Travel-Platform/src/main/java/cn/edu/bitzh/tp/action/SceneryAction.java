package cn.edu.bitzh.tp.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.bitzh.tp.model.Scenery;
import cn.edu.bitzh.tp.model.Region;
import cn.edu.bitzh.tp.model.Review;
import cn.edu.bitzh.tp.service.ISceneryService;
import cn.edu.bitzh.tp.service.impl.SceneryService;

/**
 * @author 陈君锐
 */
public class SceneryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
	ISceneryService scenerySrv = (SceneryService) applicationContext.getBean("sceneryService");
	
	private Scenery scenery;
//=========发布景点信息读取S=========================
	private int sceneryid;
	private String scenery_region;
	
	public int getSceneryid() {
		return sceneryid;
	}
	public void setSceneryid(int sceneryid) {
		this.sceneryid = sceneryid;
	}
	public String getScenery_region() {
		return scenery_region;
	}
	public void setScenery_region(String scenery_region) {
		this.scenery_region = scenery_region;
	}
//=========发布景点信息读取E=========================
	private Region region;
	private List<Scenery> scenerys;
	private List<Review> reviews;
	

	
	public Scenery getScenery() {
		return scenery;
	}
	public void setScenery(Scenery scenery) {
		this.scenery = scenery;
	}
	public List<Scenery> getScenerys() {
		return scenerys;
	}
	public void setScenerys(List<Scenery> scenerys) {
		this.scenerys = scenerys;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
//==================================================
	/**
	 * @author 陈君锐
	 * 展示单个景点详细内容
	 */
	public String getSceneryDtl() {
		this.scenery = scenerySrv.getDtl( scenery.getScenery_id() );
		System.out.println(scenery.getSceneryContent().getScenery_content_name());
		ServletActionContext.getRequest().setAttribute("scenery", scenery);
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * @author 陈君锐
	 * （按发布时间顺序）地区内展示景点列表
	 */
	public String getSceneryByRegion() {
		this.scenerys = scenerySrv.listByRegion( region.getId() );
		System.out.println(scenerys.size());
		System.out.println(scenerys.get(0).getSceneryContent().getScenery_content_name());
		return ActionSupport.SUCCESS;
	}

	/**
	 * @author 陈君锐
	 * （按发布时间顺序）展示所有景点列表
	 */
	public String getSceneryList() {
		this.scenerys = scenerySrv.list();
		System.out.println("景点数" + scenerys.size());
		System.out.println("第一个景点名" + scenerys.get(0).getSceneryContent().getScenery_content_name());
		ServletActionContext.getRequest().setAttribute("s", scenery);
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * @author 陈君锐
	 * 发布景点信息
	 */
	public String publishScenery() {
		System.out.println("action");
		System.out.println(scenery_region);
		/*
		this.scenery.setScenery_pid(null);
		this.scenery.setScenery_pulish_time(new Date());
		System.out.println(scenery.getScenery_pulish_time());
		this.scenery.setScenery_author(1000);
		System.out.println(scenery.getScenery_author());
		int id = this.scenerySrv.publishScenery(this.scenery);
		if (id != 0) {
			this.sceneryid = id;
		} else {
			return ActionSupport.INPUT;
		}*/
		return ActionSupport.SUCCESS;
	}
	
}
