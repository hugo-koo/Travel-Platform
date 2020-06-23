package cn.edu.bitzh.tp.dao.impl;
/**
 * @author 周锦涛
 * @date 2020年
 * 
 * 产品业务Dao实现类
*/
import java.io.File;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.opensymphony.xwork2.util.finder.Test;

import cn.edu.bitzh.tp.dao.ProduceRequestDao;
import cn.edu.bitzh.tp.model.CostContent;
import cn.edu.bitzh.tp.model.GraphicIntroduction;
import cn.edu.bitzh.tp.model.Produce;
import cn.edu.bitzh.tp.model.ProduceCost;

public class ProduceRequestDaoImpl extends HibernateDaoSupport implements ProduceRequestDao {

	Session session = null;
	Transaction transaction = null;
	@Autowired
	SessionFactory sessionFactory;

	private HibernateTemplate hibernateTemplate;
	private Produce pr;
	private GraphicIntroduction grap;
	private int Id;
	@Override
	public boolean save(Produce produce, ProduceCost produceCost, CostContent costContent,
			List<GraphicIntroduction> graphicIntroductions) {
		
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			// 保存产品基本信息,produce为对应数据库表的实体类
			session.save(produce);
			// 产品消费关联产品基本信息表id
			produceCost.setProduceId(produce.getProduceID());
			// 保存产品消费
			System.out.println(session.save(produceCost));
			// 关联产品消费
			costContent.setCostId(produceCost.getCostId());
			// 保存产品消费具体内容
			session.save(costContent);
			// 保存产品图文介绍和宣传图
			for (int i = 0; i < graphicIntroductions.size(); i++) {

				graphicIntroductions.get(i).setProduceId(produce.getProduceID());
				session.save(graphicIntroductions.get(i));

			}

			//提交事务后才会真正保存到数据库
			transaction.commit();
			// 保存成功返回true
			return true;
		} catch (Exception e) {
			// 保存失败返回false
			e.printStackTrace();
			return false;
		} finally {
			// 关闭格式工厂
			sessionFactory.close();
		}

	}

	@Override 
	public boolean find(String produceId, Produce produce, ProduceCost produceCost, List<CostContent> costContent,
			List<GraphicIntroduction> graphicIntroductions,List<GraphicIntroduction> advertisingMap) {
		//查询数据库表
		try {
			System.out.println(" ProduceRequestDao start\n");
			session = sessionFactory.openSession();
			
			Id=Integer.parseInt(produceId);
			// 查询产品基本信息Produce为Produce实体类，produce为Produce实体类的对象，produceID为produce的属性，Id要为对应数据类型
			String produceHql = "from Produce produce where produce.produceID = "+Id;
			//执行hql语句
			Query<Produce> produeQuery = session.createQuery(produceHql);
			//查询结果为实体类列表
			List<Produce> produeList = produeQuery.list();

			if (produeList.size() == 0) {
				System.out.println("查找produce失败\n");
				return false;
			}
			
			
			
			
			// 将产品基本信息保存到produce对象
			produce.setProduceTitle((produeList.get(0).getProduceTitle()));
			produce.setProduceID(produeList.get(0).getProduceID());
			produce.setProduceMinPrice(produeList.get(0).getProduceMinPrice());
			produce.setProduceMaxPrice(produeList.get(0).getProduceMaxPrice());
			produce.setProduceTelephone(produeList.get(0).getProduceTelephone());
		    produce.setProduceCostDay(produeList.get(0).getProduceCostDay());
		    produce.setProduceLindisfarne(produeList.get(0).getProduceLindisfarne());
		    //System.out.println("查找produce 为"+produce.getProduceLindisfarne());
		    
		    //查询产品费用
			String produceCostHql="from ProduceCost produceCost where produceCost.produceId= "+Id; 
			Query<ProduceCost> produceCostQuery=session.createQuery(produceCostHql);
			List<ProduceCost> produceCostList=produceCostQuery.list();
		    if(produceCostList.size()==0) {
		     System.out.println("查找produceCost失败\n");
			 return false;
			 }
			produceCost=produceCostList.get(0);
			
			 //查询产品费用详情，并保存到costContent对象列表中
			 String
			 costContentHql="from CostContent costContent where costContent.costId="
			 +produceCost.getCostId();
			 Query<CostContent> costContentQuery=session.createQuery(costContentHql);
			 List<CostContent> costContentGet=costContentQuery.list(); 
			 
			 if(costContentGet.size()==0) {
			  System.out.println("查找costContent失败\n");
			  return false; 
			  }
			 costContent.add(costContentGet.get(0));
			 
			// 查询产品图片详情
			String graphicIntroductionHql = "from  GraphicIntroduction graphicIntroduction where graphicIntroduction.produceId="
					+ Id +" and graphicIntroduction.graphicType = 1"; 
			Query<GraphicIntroduction> graphicIntroductionQuery = session.createQuery(graphicIntroductionHql);
			List<GraphicIntroduction> graphicIntroductionGet = graphicIntroductionQuery.list();
			//产品图片详情为空
			if (graphicIntroductionGet.size() == 0) {
				System.out.println("查找graphicIntroductions失败\n");
				return false;
			}
			//保存查询信息到graphicIntroduction列表
			for(int i=0;i<graphicIntroductionGet.size();i++) {
				graphicIntroductions.add(graphicIntroductionGet.get(i));
			}
			
			
			 // 查询产品宣传图
			String advertisingMapHql = "from  GraphicIntroduction graphicIntroduction where graphicIntroduction.produceId="
					+ Id +" and graphicIntroduction.graphicType = 0";
			Query<GraphicIntroduction> advertisingMapQuery = session.createQuery(advertisingMapHql);
			List<GraphicIntroduction> advertisingMapGet = advertisingMapQuery.list();
			//产品宣传图为空
			if (advertisingMapGet.size() == 0) {
				//System.out.println("查找advertisingMapGet失败\n");
				
				return false;
			}
			//保存查询信息到advertisingMap列表
			for(int i=0;i<advertisingMapGet.size();i++) {
				advertisingMap.add(advertisingMapGet.get(i));
			}
			System.out.println(advertisingMap.size());
			
			
			 System.out.println("查找advertisingMap为 "+advertisingMap.get(0).getGraphicIntroductionContent());
			
			 //查询成功
			 return true;
		} catch (Exception e) {
			e.printStackTrace();
			//查询失败
			return false;
		} finally {
			// 关闭格式工厂
			sessionFactory.close();
		}

	}
	
	
	
	@Override
	public List<Produce> findByPage(int begin, int pageSize) {
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Produce");
		
		//从查询结果什么位置开始分页，默认为0
		query.setFirstResult(begin);
		//页面尺寸
		query.setMaxResults(pageSize);
		
		List<Produce> list=query.list();
	
	
		/*
		 * System.out.println("begin is"+ begin); System.out.println(" pageSize is"+
		 * pageSize);
		 */
		
		return list;
	
	
	}

	@Override
	public int countGet() {
		int countNum=0;
		System.out.println(" countGet start \n");
		String hql="select COUNT(*) from Produce";
		List<Long> list=(List<Long>) this.getHibernateTemplate().find(hql);
		//查找成功
		if(list.size()>0) {
			return list.get(0).intValue();
			
		}
		//查找失败
		return 0;
	}
	
	//查找分页中产品宣传头图
	public  List<GraphicIntroduction> findAdvertisingMap(int prduceId) {
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		//查询指定产品宣传头图
		String advertisingMapHql = "from  GraphicIntroduction graphicIntroduction where graphicIntroduction.produceId="
				+ prduceId +" and graphicIntroduction.graphicType = 0"; 
		Query<GraphicIntroduction> advertisingMapQuery = session.createQuery(advertisingMapHql);
		List<GraphicIntroduction> advertisingMapGet = advertisingMapQuery.list();
		
		return advertisingMapGet;
		
	} ;
	
	
	
}
