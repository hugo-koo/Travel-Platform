package cn.edu.bitzh.tp.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.edu.bitzh.tp.model.CostContent;
import cn.edu.bitzh.tp.model.GraphicIntroduction;
import cn.edu.bitzh.tp.model.Produce;
import cn.edu.bitzh.tp.model.ProduceCost;
import cn.edu.bitzh.tp.service.ProduceRequestService;

public class ProduceShowAction extends ActionSupport{

	private Produce produce;
	private CostContent costContent;
	private List<GraphicIntroduction> graphicIntroductions;
	private List<CostContent> costContents;
	private ProduceCost produceCost;
	private GraphicIntroduction graphicIntroduction;
	private String prouceId;//页面传来产品编号
	private ProduceRequestService produceRequestService;//产品显示service
	
	
	public String execute(){
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		produceRequestService = (ProduceRequestService) applicationContext.getBean("ProduceRequestService");
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		//String test="test";
		session.setAttribute("test", "test");
		session.setAttribute("demo_num", 3);
		session.setAttribute("carousel_num", 3);
		//session.setAttribute(name, value);
		System.out.println("ProduceShowAction Start");
		
		
		graphicIntroductions = new ArrayList<GraphicIntroduction>();
		produce=new Produce();
		produceCost =new ProduceCost();
		costContent=new CostContent();
		costContents=new ArrayList<CostContent>();
		prouceId="1";
		
		
		boolean flag=produceRequestService.find(prouceId, produce, produceCost, costContents, graphicIntroductions);
		
		
		if(!flag) {
		
		  System.out.println("查找失败\n");
		  return ERROR;
		}
		//System.out.println("url is"+graphicIntroductions.get(0).getGraphicIntroductionContent()+"\n");
		
		if(graphicIntroductions.size()>0) {
			System.out.println("ProduceShowAction +graphicIntroduction is"+graphicIntroductions.get(0).getGraphicIntroductionContent());
			
		}
		else {
			System.out.println("graphicIntroductions对象保存失败");
		}
		
		
		
		for(int i=0;i<graphicIntroductions.size();i++) {
			
			session.setAttribute("graphicIntroductionContent"+i, graphicIntroductions.get(i).getGraphicIntroductionContent());
			
		}
			
			
		
		produce.getProduceMinPrice();
		
		
		
		
		return SUCCESS;
		
		
		
		
	}
	
	
	
	public void test(Produce produce, ProduceCost produceCost, List<CostContent> costContent,List<GraphicIntroduction> graphicIntroductions) {
		
		
		System.out.println(produce+"\n");
		for(int i=0;i<costContent.size();i++) {
			System.out.println(costContent.get(i)+"\n");
			
		}
		for(int i=0;i<graphicIntroductions.size();i++) {
			System.out.println(graphicIntroductions.get(i)+"\n");
			
		}
		
		
	}



	
	
	
	
	
	public String getProuceId() {
		return prouceId;
	}



	public void setProuceId(String prouceId) {
		this.prouceId = prouceId;
	}



	public Produce getProduce() {
		return produce;
	}



	public void setProduce(Produce produce) {
		this.produce = produce;
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



	public ProduceCost getProduceCost() {
		return produceCost;
	}



	public void setProduceCost(ProduceCost produceCost) {
		this.produceCost = produceCost;
	}



	public GraphicIntroduction getGraphicIntroduction() {
		return graphicIntroduction;
	}



	public void setGraphicIntroduction(GraphicIntroduction graphicIntroduction) {
		this.graphicIntroduction = graphicIntroduction;
	}



	public ProduceRequestService getProduceRequestService() {
		return produceRequestService;
	}



	public void setProduceRequestService(ProduceRequestService produceRequestService) {
		this.produceRequestService = produceRequestService;
	}
	
	

	


	
	
	
	
	
}
