package org.minemofan.core.facade.demo;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
//@RequestMapping("/monitor")
public class AspectFacade {
	
	private static Logger log = Logger.getLogger(AspectFacade.class);
	
	/**
	 * Title	
	 * Description http://127.0.0.1:8080/core_web/monitor/aspect2.mvc
	 * @param request
	 * @param response
	 * @param modelAndView
	 * @return String
	 * @author mosh
	 * @update [日期YYYY-MM-DD] [更改人姓名]
	 */
	@RequestMapping(value = "/aspect2.mvc",method = {RequestMethod.POST,RequestMethod.GET}
		,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String aspectTest2(String jsonStr){		
		log.info("请求参数facade："+ jsonStr);
		
		return "新增成功2！";
	}
	
}
