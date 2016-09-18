package org.minemofan.core.service.demo.impl;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.minemofan.core.biz.demo.DemoBO;
import org.minemofan.core.common.utils.date.DateUtil;
import org.minemofan.core.dao.demo.IDemoDao;
import org.minemofan.core.mapper.demo.TestUserMapper;
import org.minemofan.core.pojo.demo.dto.TestMobileDTO;
import org.minemofan.core.pojo.demo.dto.TestUserDTO;
import org.minemofan.core.pojo.demo.po.TestUserPO;
import org.minemofan.core.pojo.demo.vo.DemoVO;
import org.minemofan.core.service.demo.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("iDemoService")
public class DemoServiceImpl implements IDemoService{
	
	private Logger log = Logger.getLogger(DemoServiceImpl.class);
	
	
	@Autowired
	private TestUserMapper testUserMapper;
	
	@Autowired
	private IDemoDao demoDao;
	
	@Autowired
	private DemoBO demoBO;
	
	@Override
	public void add(TestUserPO po) {
		// TODO Auto-generated method stub
		testUserMapper.insert(po);
		log.info("add 插入：1条数据！");
	}
	
	
	@Override
	public List<TestUserDTO> queryAll() {
		// TODO Auto-generated method stub
		List<TestUserDTO> list = testUserMapper.queryAll();
		log.info("queryInfo 查询："+ list.size() +"条数据！");
		return list;
	}


	@Override
	public List<TestUserDTO> queryAllById(Integer id) {
		// TODO Auto-generated method stub
		List<TestUserDTO> list = testUserMapper.queryAllById(id);
		log.info("queryAllById 查询："+ list.size() +"条数据！");
		return list;
	}
	
	
	@Override
	public List<TestUserDTO> queryAllByMap(Map<String,Object> param) {
		// TODO Auto-generated method stub
		List<TestUserDTO> list = testUserMapper.queryAllByMap(param);
		log.info("queryAllByMap 查询："+ list.size() +"条数据！");
		return list;
	}


	@Override
	public boolean updateById(DemoVO vo) {
		// TODO Auto-generated method stub
		testUserMapper.updateById(vo);
		return false;
	}


	@Override
	public boolean deleteByName(String name) {
		// TODO Auto-generated method stub
		testUserMapper.deleteByName(name);
		return false;
	}


	@Override
	public List<TestUserDTO> queryByLimit(Map<String, Object> param) {
		// TODO Auto-generated method stub
		List<TestUserDTO> list = testUserMapper.queryByLimit(param);
		return list;
	}


	@Override
	public List<TestUserDTO> queryOne2One(Map<String, Object> param) {
		// TODO Auto-generated method stub
		List<TestUserDTO> list = demoDao.queryOne2One(param);
		return list;
	}


	@Override
	public List<TestUserDTO> queryOne2Many(Map<String, Object> param) {
		// TODO Auto-generated method stub
		List<TestUserDTO> list = demoDao.queryOne2Many(param);
		return list;
	}


	@Override
	public List<TestMobileDTO> queryMany2One(Map<String, Object> param) {
		// TODO Auto-generated method stub
		List<TestMobileDTO> list = demoDao.queryMany2One(param);
		return list;
	}


	@Override
	public List<TestUserDTO> queryMany2Many1(Map<String, Object> param) {
		// TODO Auto-generated method stub
		List<TestUserDTO> list = demoDao.queryMany2Many1(param);
		return list;
	}
	

	@Override
	public List<TestUserDTO> queryMany2Many2(Map<String, Object> param) {
		// TODO Auto-generated method stub
		List<TestUserDTO> list = demoDao.queryMany2Many2(param);
		return list;
	}
	

	@Override
	public boolean valiTransationByAOP() {
		
		// TODO Auto-generated method stub
		TestUserPO po = new TestUserPO();
		po.setName("姓名AOP");
		po.setType("1");
		po.setMoney(new BigDecimal("200000.0000"));
		po.setBirthdate(DateUtil.getCurrentDate());
		po.setTime(new Time(DateUtil.getCurrentDate().getTime()));
		po.setRemark("备注");		
		this.add(po);
		
		TestUserPO po2 = new TestUserPO();
		po2.setName("姓名AOP");
		po2.setType("1");
		po2.setMoney(new BigDecimal("200000.0000"));
		po2.setBirthdate(DateUtil.getCurrentDate());
		po2.setTime(new Time(DateUtil.getCurrentDate().getTime()));
		po2.setRemark("备注");		
		this.add(po2);
		
		Integer.parseInt("ssss");
		return false;
	}


	/**
	 * Title 注解事务 （不能跟AOP同时使用，会冲突）
	 * @Transactional(propagation= Propagation.NOT_SUPPORTED,readOnly=true)
	 * @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	 * @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = DataAccessException.class)
	 */
	public boolean valiTransationByAnnotation() {
		// TODO Auto-generated method stub
		TestUserPO po = new TestUserPO();
		po.setName("姓名AOP");
		po.setType("1");
		po.setMoney(new BigDecimal("200000.0000"));
		po.setBirthdate(DateUtil.getCurrentDate());
		po.setTime(new Time(DateUtil.getCurrentDate().getTime()));
		po.setRemark("备注");		
		this.add(po);
		
		TestUserPO po2 = new TestUserPO();
		po2.setName("姓名AOP");
		po2.setType("1");
		po2.setMoney(new BigDecimal("200000.0000"));
		po2.setBirthdate(DateUtil.getCurrentDate());
		po2.setTime(new Time(DateUtil.getCurrentDate().getTime()));
		po2.setRemark("备注");		
		this.add(po2);
		
		Integer.parseInt("ssss");
		return false;
	}


	@Override
	public boolean valiTransationByBO() {
		// TODO Auto-generated method stub
		TestUserPO po = new TestUserPO();
		po.setName("姓名AOP");
		po.setType("1");
		po.setMoney(new BigDecimal("200000.0000"));
		po.setBirthdate(DateUtil.getCurrentDate());
		po.setTime(new Time(DateUtil.getCurrentDate().getTime()));
		po.setRemark("备注");		
		this.add(po);
		
		demoBO.add();
		//Integer.parseInt("ssss");
		return false;
	}


}
