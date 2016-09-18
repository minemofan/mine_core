package org.minemofan.core.biz.demo;

import java.math.BigDecimal;
import java.sql.Time;

import org.minemofan.core.common.utils.date.DateUtil;
import org.minemofan.core.mapper.demo.TestUserMapper;
import org.minemofan.core.pojo.demo.po.TestUserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository("demoBO")
public class DemoBO {
	
	@Autowired
	private TestUserMapper testUserMapper;
	
	public void add() {
		// TODO Auto-generated method stub
		TestUserPO po = new TestUserPO();
		po.setName("姓名BO");
		po.setType("1");
		po.setMoney(new BigDecimal("200000.0000"));
		po.setBirthdate(DateUtil.getCurrentDate());
		po.setTime(new Time(DateUtil.getCurrentDate().getTime()));
		po.setRemark("备注");		
		
		testUserMapper.insert(po);
	}
	
}
