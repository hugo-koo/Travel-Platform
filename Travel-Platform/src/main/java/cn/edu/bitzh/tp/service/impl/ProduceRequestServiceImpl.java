package cn.edu.bitzh.tp.service.impl;
/**
 * @author 周锦涛
 * @date 2020年
 * 
 * 产品service实现类
*/
import java.io.File;
import java.util.List;

import cn.edu.bitzh.tp.dao.ProduceRequestDao;
import cn.edu.bitzh.tp.model.CostContent;
import cn.edu.bitzh.tp.model.GraphicIntroduction;
import cn.edu.bitzh.tp.model.Produce;
import cn.edu.bitzh.tp.model.ProduceCost;
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

	public ProduceRequestDao getProduceRequestDao() {
		return produceRequestDao;
	}

	public void setProduceRequestDao(ProduceRequestDao produceRequestDao) {
		this.produceRequestDao = produceRequestDao;
	}

}
