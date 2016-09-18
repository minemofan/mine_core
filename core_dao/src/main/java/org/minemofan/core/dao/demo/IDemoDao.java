package org.minemofan.core.dao.demo;


import java.util.List;
import java.util.Map;

import org.minemofan.core.pojo.demo.dto.TestMobileDTO;
import org.minemofan.core.pojo.demo.dto.TestUserDTO;

public interface IDemoDao {
	
	public List<TestUserDTO> queryOne2One(Map<String,Object> param);
	
	public List<TestUserDTO> queryOne2Many(Map<String,Object> param);
	
	public List<TestMobileDTO> queryMany2One(Map<String,Object> param);
	
	public List<TestUserDTO> queryMany2Many1(Map<String,Object> param);
	
	public List<TestUserDTO> queryMany2Many2(Map<String,Object> param);
}
