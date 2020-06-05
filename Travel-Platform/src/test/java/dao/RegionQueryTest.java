package dao;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.bitzh.tp.model.Region;
import cn.edu.bitzh.tp.service.IRegionService;
import cn.edu.bitzh.tp.service.impl.RegionService;

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
		IRegionService rs=(RegionService)ctx.getBean("regionService");
		regions = rs.listChildRegions(265);
		Iterator<Region> it=regions.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	@Test
	void testListContineins() {
		System.out.println("JUnit Test: Region query test");
		Region region;
		List<Region> regions;
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		IRegionService rs=(RegionService)ctx.getBean("regionService");
		regions = rs.listContineins();
		Iterator<Region> it=regions.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
