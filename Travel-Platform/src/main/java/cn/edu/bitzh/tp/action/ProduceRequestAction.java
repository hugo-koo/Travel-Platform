package cn.edu.bitzh.tp.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.bitzh.tp.dao.impl.ProduceRequestDaoImpl;
import cn.edu.bitzh.tp.service.ProduceRequestService;

import cn.edu.bitzh.tp.service.impl.ProduceRequestServiceImpl;

public class ProduceRequestAction extends ActionSupport {
	private String produceTitle;// 产品标题
	private int produceTelephone;// 订购电话
	private int produceMinPrice;// 最低价
	private int produceMaxPrice;// 最高价
	private int produceCostDay;// 产品花费时间
	private String produceLindisfarne;// 始发地
	private int mealsCost;// 餐食费用
	private int accommodationFee;// 住宿费用：
	private int landmarkTicket;// 景点门票：
	private int carFare;// 往来交通
	private int guideFee;// 导游服务
	private List<File> graphicIntroduction;// 图文介绍上传多文件
	private List<String> graphicIntroductionContentType;// 图文介绍上传文件类型
	private List<String> graphicIntroductionFileName;//// 图文介绍上传文件名字
	private String destPath;// 文件保存路径
	private List<File> advertisingMap;
	private List<String> advertisingMapContentType;
	private List<String> advertisingMapFileName;
	private ProduceRequestService produceRequestService;

	
	
	

	
	
	@SuppressWarnings("resource")
	public String execute() {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		produceRequestService = (ProduceRequestService) applicationContext.getBean("ProduceRequestService");
		
		
		//System.out.println("上传的文件数量为" + graphicIntroductionContentType.get(0) + "\n");
		System.out.println("ProduceRequestAction start....\n");
		System.out.println("produceTitle is " + produceTitle + "\n");
		System.out.println("produceTelephone is " + produceTelephone + "\n");
		System.out.println("produceMinPrice is " + produceMinPrice + "\n");
		System.out.println("produceMaxPrice is " + produceMaxPrice + "\n");
		System.out.println("produceCostDay is " + produceCostDay + "\n");
		System.out.println("produceLindisfarne is " + produceLindisfarne + "\n");
		System.out.println("produceLindisfarne is " + produceLindisfarne + "\n");
		System.out.println("mealsCost is " + mealsCost + "\n");
		System.out.println("landmarkTicket is " + landmarkTicket + "\n");
		System.out.println("carFare is " + carFare + "\n");
        System.out.println(produceRequestService.save());
		
		/*String destPath = "D:/test/";
		File file = new File(destPath);// 新建保存文件夹
		// 不存在则创建
		if (!file.exists()) {// 保存文件夹不存在新建
			file.mkdir();
		}

		if (graphicIntroduction.size() != 0) {// 获取上传文件数

			for (int i = 0; i < graphicIntroduction.size(); i++) {

				try {
					FileUtils.copyFile(graphicIntroduction.get(i), new File(file, graphicIntroductionFileName.get(i)));// 将文件保存到保存文件夹中
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				;

			}

		} else {

			System.out.println("上传图文详情文件为空");

		}

		System.out.println();*/
		return SUCCESS;

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

	public int getProduceTelephone() {
		return produceTelephone;
	}

	public void setProduceTelephone(int produceTelephone) {
		this.produceTelephone = produceTelephone;
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

	public List<File> getGraphicIntroduction() {
		return graphicIntroduction;
	}

	public void setGraphicIntroduction(List<File> graphicIntroduction) {
		this.graphicIntroduction = graphicIntroduction;
	}

	public List<String> getGraphicIntroductionContentType() {
		return graphicIntroductionContentType;
	}

	public void setGraphicIntroductionContentType(List<String> graphicIntroductionContentType) {
		this.graphicIntroductionContentType = graphicIntroductionContentType;
	}

	public List<String> getGraphicIntroductionFileName() {
		return graphicIntroductionFileName;
	}

	public void setGraphicIntroductionFileName(List<String> graphicIntroductionFileName) {
		this.graphicIntroductionFileName = graphicIntroductionFileName;
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




	
	
	/*
	 * private String produceTitle;//产品标题 private int produceTelephone;//订购电话
	 * private int produceMinPrice;//最低价 private int produceMaxPrice;//最高价 private
	 * int produceCostDay;//产品花费时间 private String produceLindisfarne;//始发地 private
	 * int mealsCost;//餐食费用 private int accommodationFee;//住宿费用： private int
	 * landmarkTicket;//景点门票： private int carFare;//往来交通 private int guideFee;//导游服务
	 * private List<File> graphicIntroduction;//图文介绍上传文件 private
	 * List<String>graphicIntroductionContentType; private List<String>
	 * graphicIntroductionFileName; private String destPath;//文件保存路径 private
	 * List<File> advertisingMap; private List<String> advertisingMapContentType;
	 * private List<String> advertisingMapFileName;
	 * 
	 */

}
