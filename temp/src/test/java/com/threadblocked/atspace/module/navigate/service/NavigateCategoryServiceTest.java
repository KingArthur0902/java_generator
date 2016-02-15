/*
 * Web Site: http://www.threadblocked.com
 * Since 2010 - 2016
 */

package com.threadblocked.atspace.module.navigate.service;
import cn.org.rapid_framework.page.Page;
import com.threadblocked.atspace.module.navigate.domain.navigate;
import com.threadblocked.atspace.service.navigate.Inavigate;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.org.rapid_framework.test.context.TestMethodContext;
import static junit.framework.Assert.*;

import java.util.*;

import cn.org.rapid_framework.util.*;
import cn.org.rapid_framework.web.util.*;
import cn.org.rapid_framework.page.*;
import cn.org.rapid_framework.page.impl.*;

import com.threadblocked.atspace.module.navigate.domain.*;
import com.threadblocked.atspace.module.navigate.dao.*;
import com.threadblocked.atspace.module.navigate.service.*;
import com.threadblocked.atspace.service.*;

/**
 * @key gen www.threadblocked.com
 * @version 1.0
 * @since 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/spring/*.xml"})
public class NavigateCategoryServiceTest extends AbstractTransactionalJUnit4SpringContextTests{

	private NavigateCategoryService service;
	
	@Autowired
	public void setNavigateCategoryService(NavigateCategoryService service) {
		this.service = service;
	}

	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void crud() {

		NavigateCategory obj = newNavigateCategory();
		service.save(obj);
		service.getEntityDao().flush();
		
		service.update(obj);
		service.getEntityDao().flush();
		
		assertNotNull(obj.getCategoryId());
		
		service.removeById(obj.getCategoryId());
		service.getEntityDao().flush();
	
	}
	
	public static NavigateCategory newNavigateCategory() {
		NavigateCategory obj = new NavigateCategory();
		
	  	obj.setName(new java.lang.String("1"));
	  	obj.setIsDelete(new java.lang.String("1"));
	  	obj.setCreateDate(new java.sql.Timestamp(System.currentTimeMillis()));
		return obj;
	}
}
