
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.iloosen.imall.service.${moduleName};

import com.iloosen.imall.commons.base.IBaseEntityManager;
import ${basepackage}.${moduleName}.domain.${className};

public interface I${className}Service extends IBaseEntityManager<${className}, ${table.idColumn.javaType}>{

}
