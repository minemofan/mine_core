package org.minemofan.core.mapper.demo;

import java.util.List;
import java.util.Map;

import org.minemofan.core.pojo.demo.dto.TestUserDTO;
import org.minemofan.core.pojo.demo.po.TestUserPO;
import org.minemofan.core.pojo.demo.vo.DemoVO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
@Repository("testUserMapper")
public interface TestUserMapper {
	
	public void insert(TestUserPO po);
	
	public List<TestUserDTO> queryAll();
	
	public List<TestUserDTO> queryAllById(Integer id);
	
	public List<TestUserDTO> queryAllByMap(Map<String,Object> param);
	
	public void updateById(DemoVO vo);
	
	public void deleteByName(String name);
	
	public List<TestUserDTO> queryByLimit(Map<String,Object> param);
}
