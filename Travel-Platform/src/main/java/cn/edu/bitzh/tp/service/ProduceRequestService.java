package cn.edu.bitzh.tp.service;
/**
 * @author 周锦涛
 * @date 2020年
 * 
 * 产品Service
*/

import java.util.List;

import cn.edu.bitzh.tp.model.CostContent;
import cn.edu.bitzh.tp.model.GraphicIntroduction;
import cn.edu.bitzh.tp.model.Produce;
import cn.edu.bitzh.tp.model.ProduceCost;
import cn.edu.bitzh.tp.model.ProducePage;

public interface ProduceRequestService {//产品申请service
	//保存产品信息到数据库
	public boolean save(Produce produce,ProduceCost produceCost ,CostContent costContent,List<GraphicIntroduction> graphicIntroductions);//产品存入数据库
	//读取数据库产品信息
	public boolean find(String produceId,Produce produce,ProduceCost produceCost ,List<CostContent> costContents,List<GraphicIntroduction> graphicIntroductions,List<GraphicIntroduction> advertisingMap);//产品存入数据库
	//读取产品信息并分页显示
	public ProducePage<Produce> findByPage(int currPage);
	
	
}
