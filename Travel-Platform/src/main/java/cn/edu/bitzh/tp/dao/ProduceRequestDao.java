package cn.edu.bitzh.tp.dao;
/**
 * @author 周锦涛
 * @date 2020年
 * 
 * 产品业务Dao
*/
import java.io.File;
import java.util.List;

import cn.edu.bitzh.tp.model.*;

public interface ProduceRequestDao {
	//产品信息保存到数据库
	public boolean save(Produce produce,ProduceCost produceCost ,CostContent costContent,List<GraphicIntroduction> graphicIntroductions);
	//从数据库读取指定产品相关信息
	public boolean find(String produceId, Produce produce, ProduceCost produceCost, List<CostContent> costContent,
			List<GraphicIntroduction> graphicIntroduction,List<GraphicIntroduction> advertisingMap);
	
	//产品分页查询
	public List<Produce>findByPage(int begin,int pageSize);
	
	//返回数据库produce总数
	public int countGet() ;
	//返回分页查询产品宣传图
	public List<GraphicIntroduction> findAdvertisingMap(int produceId) ;
	
	
	
	
}
