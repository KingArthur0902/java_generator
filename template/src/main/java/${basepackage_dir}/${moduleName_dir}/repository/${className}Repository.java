<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.${moduleName}.repository;
import com.zhiyou.infra.spring.data.repo.BaseRepository;
import org.springframework.data.jpa.repository.Query;

public class ${className}Repository BaseRepository<${className},Long>{

}
