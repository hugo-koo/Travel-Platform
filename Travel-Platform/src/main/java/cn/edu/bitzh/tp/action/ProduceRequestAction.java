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
	private String produceTitle;// 产品标题
	private String produceTelephoneString;// 订购电话String
	private long produceTelephone;//订购电话
	private String produceMinPriceString;// 最低价String
	private String produceMaxPriceString;// 最高价String
	private int produceMinPrice;//最低价
	private int produceMaxPrice;//最高价
	private int produceCostDay;// 产品花费时间
	private String produceLindisfarne;// 始发地
	private int mealsCost;// 餐食费用
	private int accommodationFee;// 住宿费用：
	private int landmarkTicket;// 景点门票：
	private int carFare;// 往来交通
	private int guideFee;// 导游服务
	private List<File> graphicIntroductionFile;// 图文介绍上传多文件
	private List<String> graphicIntroductionFileContentType;// 图文介绍上传文件类型
	private List<String> graphicIntroductionFileFileName;//// 图文介绍上传文件名字
	private String savePath;// 文件保存路径
	private List<File> advertisingMap;//宣传图
	private List<String> advertisingMapContentType;//宣传图文件类型
	private List<String> advertisingMapFileName;//宣传图文件名字
	
	private ProduceRequestService produceRequestService;//产品申请service
	
	
	private GraphicIntroduction graphicIntroduction;//图文介绍及宣传图实体类
	private Produce produce;//产品基本信息实体类
	private ProduceCost produceCost;//产品费用实体类
	private CostContent costContent;//产品费用内容实体类
	private List<GraphicIntroduction> graphicIntroductions;//图文介绍及宣传图实体类列表
	private String errorMessage;//校验错误信息
	public String execute() {
		
		
		//System.out.println("ProduceRequestAction start\n");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");//读取配置文件
		produceRequestService = (ProduceRequestService) applicationContext.getBean("ProduceRequestService");//注入ProduceRequestService
		
		//实例化实体类对象
		graphicIntroductions = new ArrayList<GraphicIntroduction>();
		produce=new Produce();
		produceCost =new ProduceCost();
		costContent=new CostContent();
		
		savePath="D:/test/";//设置图片保存路径
		
		
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
	public void test() {//测试属性是否正常传入
		System.out.println("ProduceRequestAction start....\n");
		System.out.println("produceTitle is " + produceTitle + "\n");
		System.out.println("produceTelephone is " + produceTelephone + "\n");
		System.out.println("produceMinPrice is " + produceMinPrice + "\n");
		System.out.println("produceMaxPrice is " + produceMaxPrice + "\n");
		System.out.println("produceCostDay is " + produceCostDay + "\n");
		//System.out.println("produceLindisfarne is " + produceLindisfarne + "\n");
		System.out.println("produceLindisfarne is " + produceLindisfarne + "\n");
		System.out.println("mealsCost is " + mealsCost + "\n");
		System.out.println("landmarkTicket is " + landmarkTicket + "\n");
		System.out.println("carFare is " + carFare + "\n");
	}
	
	public void messageInit(Produce produce,ProduceCost produceCost,CostContent costContent,List<GraphicIntroduction> graphicIntroductions){//将表单信息保存到对应mobel类中
		
		//保存产品基本信息到produce对象
		produceTelephone=Long.parseLong(produceTelephoneString);//将表单获取的produceTelephoneString转化为long类型
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
		
		
		for(int j=0;j<graphicIntroductionFile.size();j++) {//保存文件到指定位置，图文详情

				try {
					FileUtils.copyFile(graphicIntroductionFile.get(j), new File(file, graphicIntroductionFileFileName.get(j)));
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		
		
		for(int j=0;j<graphicIntroductionFile.size();j++) {//生成GraphicIntroduction对象，并保存文件路径和类型
			
			graphicIntroductions.add(new GraphicIntroduction());
			graphicIntroductions.get(j).setGraphicIntroductionContent("D:/test/"+graphicIntroductionFileFileName.get(j));
			graphicIntroductions.get(j).setGraphicType(1);
			
	
		}
		System.out.println("//保存文件到指定位置，图文详情\n");
		
		//保存宣传图到graphicIntroduction对象列表
		for(int i=0; i<advertisingMap.size();i++){//保存文件到指定位置
			
			System.out.println(graphicIntroductionFileFileName.get(i));
			try {
				FileUtils.copyFile(advertisingMap.get(i), new File(file, advertisingMapFileName.get(i)));
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

		for(int j=(graphicIntroductionFile.size());j<(advertisingMap.size()+graphicIntroductionFile.size());j++) {//生成GraphicIntroduction对象，并保存文件路径和类型,宣传图
			
			
			graphicIntroductions.add(new GraphicIntroduction());
			graphicIntroductions.get(j).setGraphicIntroductionContent("D:/test/"+advertisingMapFileName.get(j-graphicIntroductionFile.size()));
			graphicIntroductions.get(j).setGraphicType(0);
			
		}
		System.out.println("//保存宣传图到graphicIntroduction对象列表\n");
		//System.out.println(graphicIntroductions.get(0).getGraphicIntroductionContent()+"\n");
		
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
		
	
		//long produceTelephoneminflag=10000000000L;
		
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
