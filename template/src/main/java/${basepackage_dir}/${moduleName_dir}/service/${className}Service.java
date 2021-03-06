<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${moduleName}.service;
import ${servicepackage}.${moduleName}.I${className}Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.threadblocked.atspace.commons.base.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

<#include "/java_imports.include">
@Service
public class ${className}Service extends BaseEntityManager<${className},${table.idColumn.javaType}> implements I${className}Service{

    private Logger logger = LoggerFactory.getLogger(${className}.class);
	private ${className}Dao ${classNameLower}Dao;

    @Autowired
	public void set${className}Dao(${className}Dao dao) {
		this.${classNameLower}Dao = dao;
	}

	public EntityDao<${className},${table.idColumn.javaType}> getEntityDao() {
		return this.${classNameLower}Dao;
	}

	
<#list table.columns as column>
	<#if column.unique && !column.pk>
	@Transactional(readOnly=true)
	public ${className} getBy${column.columnName}(${column.javaType} v) {
		return ${classNameLower}Dao.getBy${column.columnName}(v);
	}	
	
	</#if>
</#list>
}
