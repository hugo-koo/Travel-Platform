package cn.edu.bitzh.tp.action;
/*
 * @author  周锦涛
 * @date  2020年
 * 
 * 产品分页查询action
 * */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.bitzh.tp.model.Produce;
import cn.edu.bitzh.tp.model.ProducePage;
import cn.edu.bitzh.tp.service.ProduceRequestService;

public class ProducePageAction extends ActionSupport {
	
	private ProduceRequestService produceRequestService;
	private int currPage;
	private ProducePage <Produce> producePage;
	
	public String execute() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");//读取配置文件
		produceRequestService = (ProduceRequestService) applicationContext.getBean("ProduceRequestService");//注入ProduceRequestService
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		//System.out.println("ProducePageAction start");
		
		//System.out.println(currPage);
		
		
		//产品分页查询
		producePage=produceRequestService.findByPage(currPage);
		if(producePage.getPageList().size()==0) {
			
			
			
		}
	    else {
			for(int i=0;i<producePage.getPageList().size();i++) {
				
				System.out.println(producePage.getPageList().get(i).getProduceTitle()+"\n");
				
			}
			
			
			
		}
		ActionContext.getContext().getValueStack().push(producePage);//在值栈内存放producePage
		producePage.getAdvertisingMap().get(0);
		session.setAttribute("totalPage",producePage.getTotalPage());//存放总页数
		session.setAttribute("onePageSize",producePage.getPageList().size());//存放当前页产品数量
		session.setAttribute("pageNum",currPage+1);//存放当前页页数
		return SUCCESS;
		
	}

	public ProduceRequestService getProduceRequestService() {
		return produceRequestService;
	}

	public void setProduceRequestService(ProduceRequestService produceRequestService) {
		this.produceRequestService = produceRequestService;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public ProducePage<Produce> getProducePage() {
		return producePage;
	}

	public void setProducePage(ProducePage<Produce> producePage) {
		this.producePage = producePage;
	}
	
	
	
	
	
	
}
