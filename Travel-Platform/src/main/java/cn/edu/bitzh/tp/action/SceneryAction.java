package cn.edu.bitzh.tp.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.bitzh.tp.model.Scenery;
import cn.edu.bitzh.tp.model.SceneryContent;
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
	
//=========发布景点信息读取S=========================
	private String publish_scenery_name;
	private String publish_scenery_dtl;
	//=========获取景点地区信息S=====================
	private int publish_scenery_region_1;
	private int publish_scenery_region_2;
	private int publish_scenery_region_3;
	private int publish_scenery_region_4;
	//=========获取景点地区信息E=====================
	private String publish_scenery_location;
	private String publish_scenery_phone;
	private String publish_scenery_email;
	
	public String getPublish_scenery_name() {
		return publish_scenery_name;
	}
	public void setPublish_scenery_name(String publish_scenery_name) {
		this.publish_scenery_name = publish_scenery_name;
	}
	public String getPublish_scenery_dtl() {
		return publish_scenery_dtl;
	}
	public void setPublish_scenery_dtl(String publish_scenery_dtl) {
		this.publish_scenery_dtl = publish_scenery_dtl;
	}
	//=========获取景点地区信息S=====================
	public int getPublish_scenery_region_1() {
		return publish_scenery_region_1;
	}
	public void setPublish_scenery_region_1(int publish_scenery_region_1) {
		this.publish_scenery_region_1 = publish_scenery_region_1;
	}
	public int getPublish_scenery_region_2() {
		return publish_scenery_region_2;
	}
	public void setPublish_scenery_region_2(int publish_scenery_region_2) {
		this.publish_scenery_region_2 = publish_scenery_region_2;
	}
	public int getPublish_scenery_region_3() {
		return publish_scenery_region_3;
	}
	public void setPublish_scenery_region_3(int publish_scenery_region_3) {
		this.publish_scenery_region_3 = publish_scenery_region_3;
	}
	public int getPublish_scenery_region_4() {
		return publish_scenery_region_4;
	}
	public void setPublish_scenery_region_4(int publish_scenery_region_4) {
		this.publish_scenery_region_4 = publish_scenery_region_4;
	}
	//=========获取景点地区信息E=====================
	public String getPublish_scenery_location() {
		return publish_scenery_location;
	}
	public void setPublish_scenery_location(String publish_scenery_location) {
		this.publish_scenery_location = publish_scenery_location;
	}
	public String getPublish_scenery_phone() {
		return publish_scenery_phone;
	}
	public void setPublish_scenery_phone(String publish_scenery_phone) {
		this.publish_scenery_phone = publish_scenery_phone;
	}
	public String getPublish_scenery_email() {
		return publish_scenery_email;
	}
	public void setPublish_scenery_email(String publish_scenery_email) {
		this.publish_scenery_email = publish_scenery_email;
	}
//=========发布景点信息读取E=========================
	private Scenery scenery;
	private int sceneryid;
	private Region region;
	private List<Scenery> scenerys;
	private List<Review> reviews;

	public Scenery getScenery() {
		return scenery;
	}
	public void setScenery(Scenery scenery) {
		this.scenery = scenery;
	}
	public int getSceneryid() {
		return sceneryid;
	}
	public void setSceneryid(int sceneryid) {
		this.sceneryid = sceneryid;
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
	 * 展示单个景点详细内容
	 * @author 陈君锐
	 */
	@SkipValidation
	public String getSceneryDtl() {
		this.scenery = scenerySrv.getDtl( scenery.getScenery_id() );
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * （按发布时间顺序）地区内展示景点列表
	 * @author 陈君锐
	 */
	@SkipValidation
	public String getSceneryByRegion() {
		List<Scenery> scenerylist = scenerySrv.listByRegion( region.getId() );
		if ( scenerylist != null ){
			this.scenerys = scenerylist;
			System.out.println("景点数：" + scenerys.size() );
			return ActionSupport.SUCCESS;
		}
		System.out.println("没有成功发布的景点");
		return ActionSupport.SUCCESS;
	}

	/**
	 * （按发布时间顺序）展示所有景点列表
	 * @author 陈君锐
	 */
	@SkipValidation
	public String getSceneryList() {
		List<Scenery> scenerylist = scenerySrv.list();
		if ( scenerylist != null ){
			this.scenerys = scenerylist;
			System.out.println("景点数：" + scenerys.size() );
			return ActionSupport.SUCCESS;
		}
		System.out.println("没有成功发布的景点");
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * 发布景点信息
	 * @author 陈君锐
	 */
	public String publishScenery() {
		//=============获取选中地区ID=S=====================
		int regionId = publish_scenery_region_1;
		if( publish_scenery_region_4 > 0)
			regionId = publish_scenery_region_4;
		if( publish_scenery_region_3 > publish_scenery_region_4)
			regionId = publish_scenery_region_3;
		if( publish_scenery_region_2 > publish_scenery_region_3)
			regionId = publish_scenery_region_2;
		//=============获取选中地区ID=E=====================
		//====================数据写入S=====================
		Scenery sceneryinpublish = new Scenery();
		SceneryContent scenerycontentinpublish = new SceneryContent();
		System.out.println("进入action");
		sceneryinpublish.setSceneryContent(scenerycontentinpublish);
		sceneryinpublish.setScenery_author(1000);
		sceneryinpublish.setScenery_region(regionId);
		sceneryinpublish.setScenery_publish_time(new Date());
		sceneryinpublish.getSceneryContent().setScenery_content_name(publish_scenery_name);
		sceneryinpublish.getSceneryContent().setScenery_content_dtl(publish_scenery_dtl);
		sceneryinpublish.getSceneryContent().setScenery_content_location(publish_scenery_location);
		if( !(publish_scenery_phone.equals("")) )
			sceneryinpublish.getSceneryContent().setScenery_content_phone(publish_scenery_phone);
		if( !(publish_scenery_email.equals("")) )
			sceneryinpublish.getSceneryContent().setScenery_content_email(publish_scenery_email);
		//====================数据写入E=====================
		//====================状态写入S=====================
		sceneryinpublish.setScenery_ispulish("true");
		sceneryinpublish.setScenery_ischecked("pass");
		//====================状态写入E=====================
		System.out.println("进入srv");
		int id = this.scenerySrv.publishScenery(sceneryinpublish);
		if (id != 0) {
			this.sceneryid = id;
		}else{
			return ActionSupport.INPUT;
		}
		return ActionSupport.SUCCESS;
	}
}
