package cn.edu.bitzh.tp.action;
/**
 * @author 周锦涛
 * @date 2020年
 * 
 * 产品申请表单处理
*/






import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.bitzh.tp.dao.impl.ProduceRequestDaoImpl;
import cn.edu.bitzh.tp.model.*;
import cn.edu.bitzh.tp.service.ProduceRequestService;

import cn.edu.bitzh.tp.service.impl.ProduceRequestServiceImpl;

public class ProduceRequestAction extends ActionSupport {
	/* 产品标题 */
	private String produceTitle;
	/* 订购电话String */
	private String produceTelephoneString;
	/* 订购电话 */
	private long produceTelephone;
	/* 最低价String */
	private String produceMinPriceString;
	/* 最高价String */
	private String produceMaxPriceString;
	/* 最低价 */
	private int produceMinPrice;
	/* 产品花费时间 */
	private int produceCostDay;
	/* 最高价 */
	private int produceMaxPrice;
	/* 始发地 */
	private String produceLindisfarne;
	/* 餐食费用 */
	private int mealsCost;
	/* 住宿费用 */
	private int accommodationFee;
	/* 景点门票： */
	private int landmarkTicket;
	/* 往来交通 */
	private int carFare;
	/* 导游服务 */
	private int guideFee;
	/* 图文介绍上传多文件 */
	private List<File> graphicIntroductionFile;
	/* 图文介绍上传文件类型 */
	private List<String> graphicIntroductionFileContentType;
	/* 图文介绍上传文件名字 */
	private List<String> graphicIntroductionFileFileName;
	/* 文件保存路径 */
	private String savePath;
	/* 宣传图 */
	private List<File> advertisingMap;
	/* 宣传图文件类型 */
	private List<String> advertisingMapContentType;
	/* 宣传图文件名字 */
	private List<String> advertisingMapFileName;
	/* 产品申请service */
	private ProduceRequestService produceRequestService;
	/* 图文介绍及宣传图实体类 */
	private GraphicIntroduction graphicIntroduction;
	/* 产品基本信息实体类 */
	private Produce produce;
	/* 产品费用实体类 */
	private ProduceCost produceCost;
	/* 产品费用内容实体类 */
	private CostContent costContent;
	/* 图文介绍及宣传图实体类列表 */
	private List<GraphicIntroduction> graphicIntroductions;
	/* 校验错误信息 */
	private String errorMessage;
	
	public String execute() {
		
		//System.out.println("ProduceRequestAction start\n");
		//读取配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		//注入ProduceRequestService
		produceRequestService = (ProduceRequestService) applicationContext.getBean("ProduceRequestService");
		
		//实例化实体类对象
		graphicIntroductions = new ArrayList<GraphicIntroduction>();
		produce=new Produce();
		produceCost =new ProduceCost();
		costContent=new CostContent();
		//设置图片保存路径
		savePath="D:\\tomcat9_file\\apache-tomcat-9.0.35\\webapps\\uploadfile\\images";
		
		
		System.out.println("messageInit start\n");
		//实体类对象信息设置
		messageInit(produce,produceCost,costContent,graphicIntroductions);
		
		//调取表单提交服务
		if(produceRequestService.save(produce, produceCost, costContent, graphicIntroductions))
		{
		
			//表单成功保存到数据库
			return SUCCESS;
		}
		//表单未成功保存到数据库
		return ERROR;
		
		
	}

	//将表单信息保存到对应mobel类中
	public void messageInit(Produce produce,ProduceCost produceCost,CostContent costContent,List<GraphicIntroduction> graphicIntroductions){
		
		//保存产品基本信息到produce对象
		//将表单获取的produceTelephoneString转化为long类型
		produceTelephone=Long.parseLong(produceTelephoneString);
		produce.setProduceTitle(produceTitle);
		produce.setProduceTelephone(produceTelephone);
		produce.setProduceLindisfarne(produceLindisfarne);
		produce.setProduceMinPrice(produceMinPrice);
		produce.setProduceMaxPrice(produceMaxPrice);
		produce.setProduceCostDay(produceCostDay);
		System.out.println("保存产品基本信息到produce对象\n");
		
		//保存产品花费内容到produce对象
		costContent.setAccommodationFee(accommodationFee);
		costContent.setCarFare(carFare);
		costContent.setGuideFee(guideFee);
		costContent.setLandmarkTicket(landmarkTicket);
		costContent.setMealsCost(mealsCost);
		System.out.println("保存产品花费内容到produce对象\n");
		//保存图文详情到graphicIntroduction对象列表
		
		
		
		
		
		File file = new File(savePath);
		 if (!file.exists()) {
			 file.mkdir();
		 }
		
		// 保存文件到指定位置，图文详情
		for(int j=0;j<graphicIntroductionFile.size();j++) {

				try {
					FileUtils.copyFile(graphicIntroductionFile.get(j), new File(file, graphicIntroductionFileFileName.get(j)));
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}

			}
		
		// 生成GraphicIntroduction对象，并保存文件路径和类型 
		for(int j=0;j<graphicIntroductionFile.size();j++) {
			
			graphicIntroductions.add(new GraphicIntroduction());
			graphicIntroductions.get(j).setGraphicIntroductionContent("http://localhost:8081/uploadfile/images/"+graphicIntroductionFileFileName.get(j));
			graphicIntroductions.get(j).setGraphicType(1);
			
	
		}
		//System.out.println("//保存文件到指定位置，图文详情\n");
		
		//保存宣传图到graphicIntroduction对象列表
		for(int i=0; i<advertisingMap.size();i++){
			
			//System.out.println(graphicIntroductionFileFileName.get(i));
			try {
				//保存文件到指定位置
				FileUtils.copyFile(advertisingMap.get(i), new File(file, advertisingMapFileName.get(i)));
			
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
		/* 生成GraphicIntroduction对象，并保存文件路径和类型,宣传图 */
		for(int j=(graphicIntroductionFile.size());j<(advertisingMap.size()+graphicIntroductionFile.size());j++) {
			
			
			graphicIntroductions.add(new GraphicIntroduction());
			graphicIntroductions.get(j).setGraphicIntroductionContent("http://localhost:8081/uploadfile/images/"+advertisingMapFileName.get(j-graphicIntroductionFile.size()));
			graphicIntroductions.get(j).setGraphicType(0);
			
		}
		
		
		
	}
	

	public GraphicIntroduction getGraphicIntroduction() {
		return graphicIntroduction;
	}

	public void setGraphicIntroduction(GraphicIntroduction graphicIntroduction) {
		this.graphicIntroduction = graphicIntroduction;
	}

	public Produce getProduce() {
		return produce;
	}

	public void setProduce(Produce produce) {
		this.produce = produce;
	}

	public ProduceRequestService getProduceRequestService() {
		return produceRequestService;
	}

	public void setProduceRequestService(ProduceRequestService produceRequestService) {
		this.produceRequestService = produceRequestService;
	}

	public String getProduceTitle() {
		return produceTitle;
	}

	public void setProduceTitle(String produceTitle) {
		this.produceTitle = produceTitle;
	}

	
	public int getProduceMinPrice() {
		return produceMinPrice;
	}

	public void setProduceMinPrice(int produceMinPrice) {
		this.produceMinPrice = produceMinPrice;
	}

	public int getProduceMaxPrice() {
		return produceMaxPrice;
	}

	public void setProduceMaxPrice(int produceMaxPrice) {
		this.produceMaxPrice = produceMaxPrice;
	}

	public int getProduceCostDay() {
		return produceCostDay;
	}

	public void setProduceCostDay(int produceCostDay) {
		this.produceCostDay = produceCostDay;
	}

	public String getProduceLindisfarne() {
		return produceLindisfarne;
	}

	public void setProduceLindisfarne(String produceLindisfarne) {
		this.produceLindisfarne = produceLindisfarne;
	}

	public int getMealsCost() {
		return mealsCost;
	}

	public void setMealsCost(int mealsCost) {
		this.mealsCost = mealsCost;
	}

	public int getAccommodationFee() {
		return accommodationFee;
	}

	public void setAccommodationFee(int accommodationFee) {
		this.accommodationFee = accommodationFee;
	}

	public int getLandmarkTicket() {
		return landmarkTicket;
	}

	public void setLandmarkTicket(int landmarkTicket) {
		this.landmarkTicket = landmarkTicket;
	}

	public int getCarFare() {
		return carFare;
	}

	public void setCarFare(int carFare) {
		this.carFare = carFare;
	}

	public int getGuideFee() {
		return guideFee;
	}

	public void setGuideFee(int guideFee) {
		this.guideFee = guideFee;
	}

	

	public long getProduceTelephone() {
		return produceTelephone;
	}
	public void setProduceTelephone(long produceTelephone) {
		this.produceTelephone = produceTelephone;
	}
	public List<File> getGraphicIntroductionFile() {
		return graphicIntroductionFile;
	}
	public void setGraphicIntroductionFile(List<File> graphicIntroductionFile) {
		this.graphicIntroductionFile = graphicIntroductionFile;
	}
	
	public List<String> getGraphicIntroductionFileContentType() {
		return graphicIntroductionFileContentType;
	}
	public void setGraphicIntroductionFileContentType(List<String> graphicIntroductionFileContentType) {
		this.graphicIntroductionFileContentType = graphicIntroductionFileContentType;
	}
	public List<String> getGraphicIntroductionFileFileName() {
		return graphicIntroductionFileFileName;
	}
	public void setGraphicIntroductionFileFileName(List<String> graphicIntroductionFileFileName) {
		this.graphicIntroductionFileFileName = graphicIntroductionFileFileName;
	}
	public List<File> getAdvertisingMap() {
		return advertisingMap;
	}

	public void setAdvertisingMap(List<File> advertisingMap) {
		this.advertisingMap = advertisingMap;
	}

	public List<String> getAdvertisingMapContentType() {
		return advertisingMapContentType;
	}

	public void setAdvertisingMapContentType(List<String> advertisingMapContentType) {
		this.advertisingMapContentType = advertisingMapContentType;
	}

	public List<String> getAdvertisingMapFileName() {
		return advertisingMapFileName;
	}

	public void setAdvertisingMapFileName(List<String> advertisingMapFileName) {
		this.advertisingMapFileName = advertisingMapFileName;
	}

	public ProduceCost getProduceCost() {
		return produceCost;
	}

	public void setProduceCost(ProduceCost produceCost) {
		this.produceCost = produceCost;
	}

	public CostContent getCostContent() {
		return costContent;
	}

	public void setCostContent(CostContent costContent) {
		this.costContent = costContent;
	}

	public List<GraphicIntroduction> getGraphicIntroductions() {
		return graphicIntroductions;
	}

	public void setGraphicIntroductions(List<GraphicIntroduction> graphicIntroductions) {
		this.graphicIntroductions = graphicIntroductions;
	}
	public String getProduceTelephoneString() {
		return produceTelephoneString;
	}
	public void setProduceTelephoneString(String produceTelephoneString) {
		this.produceTelephoneString = produceTelephoneString;
	}
	public String getProduceMinPriceString() {
		return produceMinPriceString;
	}
	public void setProduceMinPriceString(String produceMinPriceString) {
		this.produceMinPriceString = produceMinPriceString;
	}
	public String getProduceMaxPriceString() {
		return produceMaxPriceString;
	}
	public void setProduceMaxPriceString(String produceMaxPriceString) {
		this.produceMaxPriceString = produceMaxPriceString;
	}
	
	
	
	
	public void validate() {//产品申请表单信息校验
		System.out.println("validate start");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		long produceTelephonemaxflag=99999999999L;//产品电话最大位数为11位
		
		
		
		if(produceTitle.equals("")) {//校验产品标题
			request.setAttribute("errorMessage", "产品标题为空");
			addFieldError("Esg","产品标题为空");
		}
		
	
		
		
		try {//校验电话号码是否为整数
			
			produceTelephone=Long.parseLong(produceTelephoneString);
		}catch(NumberFormatException e){
			System.out.println("produceTelephone  电话号码为非数字\n");
		
			request.setAttribute("errorMessage", "电话号码为非数字");
			addFieldError("Esg","电话号码为非数字");
		}
		
		
		
		if(produceTelephone>produceTelephonemaxflag) {//校验电话号码是否超出11位
			System.out.println("produceTelephone>produceTelephonemaxflag \n");
			request.setAttribute("errorMessage", "电话号码位数超过11位");
			addFieldError("Esg","电话号码位数超过11位");
		}
		
		
		if(produceTelephone < 0) {////校验电话号码是否为负数
			System.out.println("produceTelephone<0 \n");
			request.setAttribute("errorMessage", "电话号码位数为非数字");
			addFieldError("Esg","电话号码位数为非数字");
		}
		
		
		try {//校验最高价或最低价格是否为整数
				
				produceMinPrice=Integer.parseInt(produceMinPriceString);
				produceMaxPrice=Integer.parseInt(produceMaxPriceString);
			}catch(NumberFormatException e){
				System.out.println("produceMinPriceString try\n");
				request.setAttribute("errorMessage", "最高价或最低价格为非整数数字字");
				
				addFieldError("Esg","最高价或最低价格为非整数数字字");
			}
		
		
		
		if((produceMaxPrice<=0)||(produceMinPrice<=0)) {//校验最高价或最低价格是否为正整数
			System.out.println("produceMaxPrice<0)||(produceMinPrice<0\n");
			request.setAttribute("errorMessage", "最高价或最低价格为非整数数字");
			addFieldError("Esg","最高价或最低价格为非整数数字字");	
			}
		
		if(produceMaxPrice<produceMinPrice) {//校验最低价格高于最高价格
			System.out.println("produceMaxPrice<produceMinPrice\n");
			request.setAttribute("errorMessage", "最低价格高于最高价格");
			addFieldError("Esg","最低价格高于最高价格");
		}
		
		if(produceLindisfarne.equals("")) {//校验始发地是否为空
			System.out.println("produceLindisfarne.equals\n");
			request.setAttribute("errorMessage", "始发地为空");
			addFieldError("Esg","始发地为空");
		}
		
		
		try {
		if(graphicIntroductionFile.size()==0) {//校验图文详情是否为空
			
			request.setAttribute("errorMessage", "图文详情不能为空");
			addFieldError("Esg","图文详情不能为空");
			
			
		}
		}catch(NullPointerException e) {
			
			request.setAttribute("errorMessage", "图文详情不能为空");
			addFieldError("Esg","图文详情不能为空");
			
			
		}
		
		
		try {
		if(advertisingMap.size()==0) {//校验宣传图是否为空
			
			request.setAttribute("errorMessage", "宣传图不能为空");
			addFieldError("Esg","宣传图不能为空");
			
		}	
		}catch(NullPointerException e) {
			
			request.setAttribute("errorMessage", "宣传图不能为空");
			addFieldError("Esg","宣传图不能为空");
			
			
		}
	
	
	}
	


}
