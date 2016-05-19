<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${moduleName}.service.impl;
import ${basepackage}.${moduleName}.service.${className}Service;
import ${basepackage}.${moduleName}.repository.${className}Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
<#include "/java_imports.include">
@Service
public class ${className}ServiceImpl  implements ${className}Service{

    private Logger logger = LoggerFactory.getLogger(${className}ServiceImpl.class);
	@Autowired
	private ${className}Repository ${classNameLower}Repo;



	

}
