/*
 * Web Site: http://www.threadblocked.com
 * Since 2010 - 2016
 */

package com.threadblocked.atspace.module.navigate.service;
import com.threadblocked.atspace.service.navigate.INavigateCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.threadblocked.atspace.commons.base.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

@Service
public class NavigateCategoryService extends BaseEntityManager<NavigateCategory,java.lang.Integer> implements INavigateCategoryService{


    private Logger logger = LoggerFactory.getLogger(NavigateCategory.class);
	private NavigateCategoryDao navigateCategoryDao;

    @Autowired
	public void setNavigateCategoryDao(NavigateCategoryDao dao) {
		this.navigateCategoryDao = dao;
	}

	public EntityDao<NavigateCategory,java.lang.Integer> getEntityDao() {
		return this.navigateCategoryDao;
	}

	
}
