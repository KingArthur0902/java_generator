
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.threadblocked.atspace.service.${moduleName};

import com.threadblocked.atspace.commons.base.IBaseEntityManager;
import ${basepackage}.${moduleName}.domain.${className};

public interface I${className}Service extends IBaseEntityManager<${className}, ${table.idColumn.javaType}>{

}
