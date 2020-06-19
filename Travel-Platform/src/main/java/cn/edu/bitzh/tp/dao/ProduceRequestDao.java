package cn.edu.bitzh.tp.dao;
/**
 * @author 周锦涛
 * @date 2020年
 * 
 * 产品Dao
*/
import java.io.File;
import java.util.List;

import cn.edu.bitzh.tp.model.*;

public interface ProduceRequestDao {
	//保存产品信息到数据库
	public boolean save(Produce produce,ProduceCost produceCost ,CostContent costContent,List<GraphicIntroduction> graphicIntroductions);//产品信息保存到数据库
	//从数据库读取指定产品相关信息
	public boolean find(String produceId, Produce produce, ProduceCost produceCost, List<CostContent> costContent,
			List<GraphicIntroduction> graphicIntroduction,List<GraphicIntroduction> advertisingMap);
	
	
}
