package org.minemofan.core.web.demo;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.minemofan.core.common.utils.date.DateUtil;
import org.minemofan.core.pojo.demo.dto.TestMobileDTO;
import org.minemofan.core.pojo.demo.dto.TestRoleDTO;
import org.minemofan.core.pojo.demo.dto.TestUserDTO;
import org.minemofan.core.pojo.demo.dto.TestUserRoleDTO;
import org.minemofan.core.pojo.demo.po.TestUserPO;
import org.minemofan.core.pojo.demo.vo.DemoVO;
import org.minemofan.core.service.demo.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created on 2016-01-01
 * <p>Title:       增删改查Demo</p>
 * <p>Description: 增加、删除、修改、简单查询、service-dao事务、service-bo-dao事务、翻页查询</p>
 * <p>Copyright:   Copyright (c) 2016</p>
 * <p>Company:     科技中心</p>
 * <p>Department:  研发部</p>
 * @author         mosh
 * @version        1.0
 */
@Controller
@RequestMapping("/demoController")
public class DemoController {
	
	private static Logger log = Logger.getLogger(DemoController.class);
	
	@Autowired
	private IDemoService iDemoService;
	
		
	/**
	 * Title	增加
	 * Description 增http://127.0.0.1:8080/core_web/demoController/add.mvc
	 * @return 
	 * @author mosh
	 * @update [日期YYYY-MM-DD] [更改人姓名]
	 */
	@RequestMapping(value = "/add.mvc",method = {RequestMethod.POST,RequestMethod.GET}
		,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String add(HttpServletRequest request
			,HttpServletResponse response,ModelAndView modelAndView){		
		TestUserPO po = new TestUserPO();
		po.setName("姓名2");
		po.setType("1");
		po.setMoney(new BigDecimal("100000.0000"));
		po.setBirthdate(DateUtil.getCurrentDate());
		po.setTime(new Time(DateUtil.getCurrentDate().getTime()));
		po.setRemark("备注");		
		iDemoService.add(po);
		return "新增成功！";
	}
	
	/**
	 * Title 删除
	 * Description http://127.0.0.1:8080/core_web/demoController/del.mvc
	 * @return 
	 * @author mosh
	 * @update [日期YYYY-MM-DD] [更改人姓名]
	 */
	@RequestMapping(value = "/del.mvc",method = RequestMethod.GET
			,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String del(HttpServletRequest request
			,HttpServletResponse response,ModelAndView modelAndView){
		String name = "姓名2";
		boolean flag = iDemoService.deleteByName(name);
		String msg = "删除名称为："+ name +"的数据。"+ flag;
		return "删除成功！"+ msg;
	}
	
	/**
	 * Title 更新
	 * Description http://127.0.0.1:8080/core_web/demoController/up.mvc
	 * @return 
	 * @author mosh
	 * @update [日期YYYY-MM-DD] [更改人姓名]
	 */
	@RequestMapping(value = "/up.mvc",method = RequestMethod.GET
			,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String modify(HttpServletRequest request
			,HttpServletResponse response,ModelAndView modelAndView){
		DemoVO vo = new DemoVO();
		vo.setId(new Integer(1));
		vo.setName("姓名2");
		vo.setRemark("更新数据备注");
		boolean flag = iDemoService.updateById(vo);
		String msg = "修改名称为："+ vo.getName() +"的数据。"+ flag;
		return "更新成功！"+ msg;
	}	
	
	/**  
	 * Title 简单查询、翻页、一对多、多对一、一对一、多对多
     * Description http://127.0.0.1:8080/core_web/demoController/queryAll.mvc
     * @return ModelAndView
     * @author mosh 
     * @update:	[日期YYYY-MM-DD] [更改人姓名]
     */ 
	@RequestMapping(value = "/queryAll.mvc",method = RequestMethod.GET)
	public ModelAndView query(HttpServletRequest request
			,HttpServletResponse response,ModelAndView modelAndView){
		
		//查询
		List<TestUserDTO> allList = iDemoService.queryAll();
		modelAndView.addObject("allList", allList);
		log.info("简单查询："+ allList);
		
		//条件查询1
		int id = 1;
		List<TestUserDTO> listByUid = iDemoService.queryAllById(new Integer(id));
		modelAndView.addObject("listByUid", listByUid);
		log.info("条件查询1："+ listByUid);
		
		//条件查询2
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("ids", new long[]{1,2,3,4,5,6,7});
		param.put("name", "名");
		List<TestUserDTO> listByMap = iDemoService.queryAllByMap(param);
		modelAndView.addObject("listByMap", listByMap);
		log.info("条件查询2："+ listByMap);
		
		//翻页查询
		Map<String,Object> limitMap = new HashMap<String,Object>();
		limitMap.put("offset", "10");	//从第十一条开始
		limitMap.put("pageSize", "10"); //取10条数据
		List<TestUserDTO> limitList = iDemoService.queryByLimit(limitMap);
		modelAndView.addObject("limitList", limitList);
		log.info("翻页查询："+ limitList);
				
		//一对一
		Map<String,Object> one2OneMap = new HashMap<String,Object>();
		one2OneMap.put("name", "");
		List<TestUserDTO> one2OneList = iDemoService.queryOne2One(one2OneMap);
		log.info("一对一查询："+ one2OneList);
		for(int i=0;i<one2OneList.size();i++){
			TestUserDTO dto = one2OneList.get(i);
			Integer uid = dto.getId();
			String name = dto.getName();
			log.debug("一对一查询：id:"+ uid +",name:"+ name +",idCardDTO:"+ dto.getIdCard());
		}
		
		//一对多
		Map<String,Object> one2ManyMap = new HashMap<String,Object>();
		one2ManyMap.put("name", null);
		List<TestUserDTO> one2ManyList = iDemoService.queryOne2Many(one2ManyMap);
		log.info("一对多查询："+ one2ManyList);
		for(int i=0;i<one2ManyList.size();i++){
			TestUserDTO dto = one2ManyList.get(i);
			Integer uid = dto.getId();
			String name = dto.getName();
			log.debug("一对多查询：id:"+ uid +",name:"+ name +",Mobiles:"+ dto.getMobiles().size());
		}
		
		//多对一
		Map<String,Object> Many2OneMap = new HashMap<String,Object>();
		Many2OneMap.put("name", null);
		List<TestMobileDTO> Many2OneList = iDemoService.queryMany2One(Many2OneMap);
		log.info("多对一查询："+ Many2OneList);
		for(int i=0;i<Many2OneList.size();i++){
			TestMobileDTO dto = Many2OneList.get(i);
			Integer mid = dto.getId();
			Long mobileNum = dto.getMobileNum();
			log.debug("多对一查询：id:"+ mid +",mobileNum:"+ mobileNum +",user:"+ dto.getUser().getId());
		}
		
		//多对多1
		Map<String,Object> Many2ManyMap = new HashMap<String,Object>();
		List<TestUserDTO> Many2ManyList = iDemoService.queryMany2Many1(Many2ManyMap);
		log.info("多对多查询："+ Many2ManyList);
		for(int i=0;i<Many2ManyList.size();i++){
			TestUserDTO dto = Many2ManyList.get(i);
			Integer uid = dto.getId();
			String uname = dto.getName();
			log.debug("多对多查询：id:"+ uid +",user:"+ uname +",Role:"+ dto.getRoles().size());
		}
		//多对多2
		Map<String,Object> Many2ManyMap2 = new HashMap<String,Object>();
		List<TestUserDTO> Many2ManyList2 = iDemoService.queryMany2Many2(Many2ManyMap2);
		log.info("多对多查询："+ Many2ManyList2);
		for(int i=0;i<Many2ManyList2.size();i++){
			TestUserDTO dto = Many2ManyList2.get(i);
			Integer uid = dto.getId();
			String uname = dto.getName();
			
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			List<TestUserRoleDTO> userRoles = dto.getUserRoles();
			for(int j=0;j<userRoles.size();j++){
				TestUserRoleDTO urDto = userRoles.get(j);
				TestRoleDTO role = urDto.getRole();
				sb.append("角色："+ role.getRoleName() +"—");
			}
			sb.append("]");
			log.debug("多对多查询：id:"+ uid +",user:"+ uname +",Role:"+ sb.toString());
		}
		
		modelAndView.setViewName("index");		//返回JSP
		return modelAndView;
	}
	
	/**
	 * Title	Service事务
	 * Description
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/traAop.mvc",method = RequestMethod.GET)
	public void valiTransationByAOP(HttpServletRequest request,HttpServletResponse response){
		//AOP事务
		iDemoService.valiTransationByAOP();		
	}
	
	/**
	 * Title	Service事务
	 * Description
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/traAnn.mvc",method = RequestMethod.GET)
	public void valiTransationByAnnotation(HttpServletRequest request,HttpServletResponse response){
		//结合BO的事务
		iDemoService.valiTransationByAnnotation();
		
	}
	
	/**
	 * Title	Service事务
	 * Description
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/traBo.mvc",method = RequestMethod.GET)
	public void valiTransationByBO(HttpServletRequest request,HttpServletResponse response){
		//结合BO的事务
		iDemoService.valiTransationByBO();
		
	}
	
}
