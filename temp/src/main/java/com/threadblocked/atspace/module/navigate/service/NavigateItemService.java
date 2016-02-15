/*
 * Web Site: http://www.threadblocked.com
 * Since 2010 - 2016
 */

package com.threadblocked.atspace.module.navigate.service;
import com.threadblocked.atspace.service.navigate.INavigateItemService;
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
public class NavigateItemService extends BaseEntityManager<NavigateItem,java.lang.Integer> implements INavigateItemService{


    private Logger logger = LoggerFactory.getLogger(NavigateItem.class);
	private NavigateItemDao navigateItemDao;

    @Autowired
	public void setNavigateItemDao(NavigateItemDao dao) {
		this.navigateItemDao = dao;
	}

	public EntityDao<NavigateItem,java.lang.Integer> getEntityDao() {
		return this.navigateItemDao;
	}

	
}
