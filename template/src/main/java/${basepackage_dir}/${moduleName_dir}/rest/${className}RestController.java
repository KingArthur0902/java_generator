<#include "/custom.include">
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameFirstLower = className?uncap_first>   
<#assign classNameLowerCase = className?lower_case>   
<#assign pkJavaType = table.idColumn.javaType>   
package ${basepackage}.${moduleName}.rest;

import ${basepackage}.${moduleName}.service.${className}Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.zhiyou.infra.base.vo.GeneralResult;
import com.zhiyou.infra.spring.data.util.PageToGeneralResult;
import com.zhiyou.infra.spring.web.bind.annotation.CurrentUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

<#include "/java_imports.include">
@Controller
@RequestMapping("/${classNameLowerCase}s")
public class ${className}RestController {

	@Autowired
	private ${className}Service ${classNameFirstLower}Service;

	/** binder用于bean属性的设置 */
	/*@InitBinder
	public void initBinder(WebDataBinder binder) {  
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));  
	}*/
	   
	/*@ModelAttribute
	public void init(ModelMap model) {
		model.put("now", new java.sql.Timestamp(System.currentTimeMillis()));
	}*/
	
}

