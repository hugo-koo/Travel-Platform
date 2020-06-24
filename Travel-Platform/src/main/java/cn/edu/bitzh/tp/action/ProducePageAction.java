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
		//读取配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		//注入ProduceRequestService
		produceRequestService = (ProduceRequestService) applicationContext.getBean("ProduceRequestService");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		
		//产品分页查询
		producePage=produceRequestService.findByPage(currPage);
		//查找失败
		if(producePage.getPageList().size()==0) {
			return ERROR;
		}
		
		//查找成功
		//在值栈内存放producePage
		ActionContext.getContext().getValueStack().push(producePage);
		producePage.getAdvertisingMap().get(0);
		//存放总页数
		session.setAttribute("totalPage",producePage.getTotalPage());
		//存放当前页产品数量
		session.setAttribute("onePageSize",producePage.getPageList().size());
		//存放当前页页数
		session.setAttribute("pageNum",currPage);
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
