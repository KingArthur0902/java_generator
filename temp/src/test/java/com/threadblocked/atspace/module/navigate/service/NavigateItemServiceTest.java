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
public class NavigateItemServiceTest extends AbstractTransactionalJUnit4SpringContextTests{

	private NavigateItemService service;
	
	@Autowired
	public void setNavigateItemService(NavigateItemService service) {
		this.service = service;
	}

	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void crud() {

		NavigateItem obj = newNavigateItem();
		service.save(obj);
		service.getEntityDao().flush();
		
		service.update(obj);
		service.getEntityDao().flush();
		
		assertNotNull(obj.getItemId());
		
		service.removeById(obj.getItemId());
		service.getEntityDao().flush();
	
	}
	
	public static NavigateItem newNavigateItem() {
		NavigateItem obj = new NavigateItem();
		
	  	obj.setCategoryId(new java.lang.Integer("1"));
	  	obj.setName(new java.lang.String("1"));
	  	obj.setUrl(new java.lang.String("1"));
	  	obj.setCreateDate(new java.sql.Timestamp(System.currentTimeMillis()));
		return obj;
	}
}
