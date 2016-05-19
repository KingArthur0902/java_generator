<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${moduleName}.service.impl;
import ${basepackage}.${moduleName}.domain.${className};
import ${basepackage}.${moduleName}.service.${className}Service;
import org.junit.Test;
import org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ${basepackage}.${moduleName}.repository.${className}Repository;
import junit.framework.Assert.*;

<#include "/java_imports.include">
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/spring/*.xml"})
public class ${className}ServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Autowired
	private ${className}Service service;
	@Autowired
	private ${className}Repository ${classNameLower}Repo;
	

	@Test
	public void crud() {

		${className} obj = new${className}();
		${classNameLower}Repo.saveAndFlush(obj);

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
