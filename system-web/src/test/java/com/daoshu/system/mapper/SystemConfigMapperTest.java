package com.daoshu.system.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.daoshu.resourceTest.AppTest;

public class SystemConfigMapperTest extends AppTest{
	
	@Autowired
	private SystemConfigMapper systemConfigMapper;

	@Test
	public void test() {
		System.out.println(systemConfigMapper.getByTypeAndKey("FILE_UOLOAD_SERVER", "URL"));
	}

}
