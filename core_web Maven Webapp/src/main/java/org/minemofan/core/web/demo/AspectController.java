package org.minemofan.core.web.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/monitor")
public class AspectController {
		
	private static Logger log = Logger.getLogger(AspectController.class);
	
	/** 
	 * Title	
	 * Description http://127.0.0.1:8080/core_web/monitor/aspect.mvc
	 * @param request
	 * @param response
	 * @param modelAndView
	 * @return String
	 * @author mosh
	 * @update [日期YYYY-MM-DD] [更改人姓名]
	 */
	@RequestMapping(value = "/aspect.mvc",method = {RequestMethod.POST,RequestMethod.GET}
		,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String aspectTest(HttpServletRequest request
			,HttpServletResponse response,ModelAndView modelAndView){		
		
		return "新增成功！";
	}
	
	
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
		log.info("请求参数："+ jsonStr);
		
		return "新增成功2！";
	}
	
}
