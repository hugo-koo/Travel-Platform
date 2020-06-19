package cn.edu.bitzh.tp.service.impl;
/**
 * @author 周锦涛
 * @date 2020年
 * 
 * 产品service实现类
*/
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.edu.bitzh.tp.dao.ProduceRequestDao;
import cn.edu.bitzh.tp.model.CostContent;
import cn.edu.bitzh.tp.model.GraphicIntroduction;
import cn.edu.bitzh.tp.model.Produce;
import cn.edu.bitzh.tp.model.ProduceCost;
import cn.edu.bitzh.tp.model.ProducePage;
import cn.edu.bitzh.tp.service.ProduceRequestService;

public class ProduceRequestServiceImpl implements ProduceRequestService {

	private ProduceRequestDao produceRequestDao;

	@Override
	public boolean save(Produce produce, ProduceCost produceCost, CostContent costContent,
			List<GraphicIntroduction> graphicIntroductions) {// 保存产品申请信息
		// TODO Auto-generated method stub

		System.out.println("ProduceRequestService start\n");

		if (produceRequestDao.save(produce, produceCost, costContent, graphicIntroductions)) {// 保存产品申请信息成功返回true
			//产品保存成功
			return true;
		}
		//产品保存失败
		return false;

	}

	@Override
	public boolean find(String produceId,Produce produce,ProduceCost produceCost ,List<CostContent> costContents,List<GraphicIntroduction> graphicIntroductions,List<GraphicIntroduction> advertisingMap) {
		// TODO Auto-generated method stub
		System.out.println(" ProduceRequestService Start\n");
		if(produceRequestDao.find(produceId,produce, produceCost, costContents,graphicIntroductions, advertisingMap)) {//查找数据成功返回true
			System.out.println(" ProduceRequestService 查找成功\n");
			System.out.println("produce 对象"+produce.getProduceLindisfarne());

			if(graphicIntroductions.size()>0) {
				System.out.println("graphicIntroductions查找"+graphicIntroductions.get(0).getGraphicIntroductionContent());
				
			}
			else {
				System.out.println("graphicIntroductions对象保存失败");
			}
			//产品读取成功
			return true;
			
		}
		
		
		
		
		//产品读取成功
		return false;
	}

	
	
	@Override
	public ProducePage<Produce> findByPage(int currPage) {
		//产品分页查询
		// TODO Auto-generated method stub
		
		//System.out.println("ProduceRequestServiceImpl indByPage start\n");
		ProducePage<Produce> producePage =new ProducePage<Produce>();
		//每页最多显示产品数
		int pageSize=5;
		producePage.setPageSize(pageSize);
		//数据库产品总数
		int total=produceRequestDao.countGet();
		//System.out.println("total is"+total+"\n");
		producePage.setTotalCount(total);
		
		double totalDouble=total;
		Double num=Math.ceil(totalDouble/pageSize);
		//产品总页数
		producePage.setTotalPage(num.intValue());
		
		//产品分页查询起始点
		int begin=(currPage -1)*pageSize;
		//System.out.println("begin is"+begin);
		
		//产品分页查询获得产品对象列表数据
		List<Produce> list=produceRequestDao.findByPage(begin, pageSize);
		//System.out.println("list size is"+list.size()+"\n");
		producePage.setPageList(list);
		
		
		//产品宣传图封装		
		List<String> urlList=new ArrayList();
		for(int i=0;i<producePage.getPageList().size();i++) {
			//查询产品宣传图
			String urls=produceRequestDao.findAdvertisingMap(producePage.getPageList().get(i).getProduceID()).get(0).getGraphicIntroductionContent();
			urlList.add(urls);
		
		}
		producePage.setAdvertisingMap(urlList);
		
		
		
		return producePage;
	}

	public ProduceRequestDao getProduceRequestDao() {
		return produceRequestDao;
	}

	public void setProduceRequestDao(ProduceRequestDao produceRequestDao) {
		this.produceRequestDao = produceRequestDao;
	}

	

}
