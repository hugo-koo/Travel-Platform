package dao;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.bitzh.tp.dao.IRegionDao;
import cn.edu.bitzh.tp.dao.impl.RegionDao;
import cn.edu.bitzh.tp.model.Region;

/**
* @author 古学懂_Victor
*/
class RegionQueryTest {

	@Test
	void test() {
		System.out.println("JUnit Test: Region query test");
		Region region;
		List<Region> regions;
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IRegionDao rd=(RegionDao)ctx.getBean("regionDao");
		regions = rd.listChildRegions(265);
		Iterator<Region> it=regions.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
