/**
 * 
 */
package com.bbw.jk.controller.basicinfo.factory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bbw.jk.controller.BaseController;
import com.bbw.jk.domain.Factory;
import com.bbw.jk.service.FactoryService;

/**
 * @author ItYunTeng
 * @descrip 
 * @createDate 2018年8月27日
 * @return 
 */
@Controller
public class FactoryController extends BaseController{
	@Autowired//resource javax 自带注入注解
	FactoryService factoryService;
	/*请求路径名,请求路径中可以包含各种参数，并且不同的请求可以绑定到同一个请求方法上*/
	@RequestMapping(value="/basicinfo/factory/list.action",method = RequestMethod.GET)
	public String list(Factory factory,Model model){
		List<Factory> listdata = factoryService.find(factory);
		System.out.println(listdata.toString());
		model.addAttribute("obj",listdata);
		return "/basicinfo/factory/jFactoryList.jsp";//逻辑视图名
	}
}
