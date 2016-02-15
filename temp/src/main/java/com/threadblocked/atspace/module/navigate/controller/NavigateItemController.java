/*
 * Web Site: http://www.threadblocked.com
 * Since 2010 - 2016
 */


package com.threadblocked.atspace.module.navigate.controller;

import com.threadblocked.atspace.service.navigate.INavigateItemService;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.threadblocked.atspace.commons.base.BaseController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

@Controller
@RequestMapping("/admin/modules/navigate/navigateitem")
public class NavigateItemController extends BaseController{

	@Autowired
	private INavigateItemService navigateItemService;

	/** binder用于bean属性的设置 */
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));  
	}
	   
	@ModelAttribute
	public void init(ModelMap model) {
		model.put("now", new java.sql.Timestamp(System.currentTimeMillis()));
	}
	
}

