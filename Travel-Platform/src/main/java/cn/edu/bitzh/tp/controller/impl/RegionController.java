package cn.edu.bitzh.tp.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bitzh.tp.controller.IRegionController;
import cn.edu.bitzh.tp.model.Region;
import cn.edu.bitzh.tp.service.IRegionService;

/**
 * @author 古学懂_Victor
 */
@RequestMapping("/Region")
@Controller
public class RegionController implements IRegionController {
	@Autowired
	IRegionService rs;

	@RequestMapping(value = "listContineins", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public List<Region> listContineins() {
		return rs.listContinents();
	}
	
	@RequestMapping(value = "listChildRegions", method = RequestMethod.POST)
	@ResponseBody
	@Override
	public List<Region> listChildRegions(int pid) {
		return rs.listChildRegions(pid);
	}


}
