<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${moduleName}.service;
import cn.org.rapid_framework.page.Page;
import ${basepackage}.${moduleName}.domain.${moduleName};
import com.threadblocked.atspace.service.${moduleName}.I${moduleName};
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.org.rapid_framework.test.context.TestMethodContext;
import static junit.framework.Assert.*;

<#include "/java_imports.include">
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/spring/*.xml"})
public class ${className}ServiceTest extends AbstractTransactionalJUnit4SpringContextTests{

	private ${className}Service service;
	
	@Autowired
	public void set${className}Service(${className}Service service) {
		this.service = service;
	}

	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void crud() {

		${className} obj = new${className}();
		service.save(obj);
		service.getEntityDao().flush();
		
		service.update(obj);
		service.getEntityDao().flush();
		
	<#if table.compositeId>
		assertNotNull(service.getById(obj.getId()));
		
		service.removeById(obj.getId());
		service.getEntityDao().flush();
	<#else>
		assertNotNull(obj.get${table.idColumn.columnName}());
		
		service.removeById(obj.get${table.idColumn.columnName}());
		service.getEntityDao().flush();
	</#if>
	
	}
	
	public static ${className} new${className}() {
		${className} obj = new ${className}();
		
		<#list table.columns as column>
	  		<#if column.isNotIdOrVersionField>
	  			<#if column.isDateTimeColumn>
	  	obj.set${column.columnName}(new ${column.javaType}(System.currentTimeMillis()));
	  			<#else>
	  	obj.set${column.columnName}(new ${column.javaType}("1"));
	  			</#if>
			</#if>
		</#list>
		return obj;
	}
}
