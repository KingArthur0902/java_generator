<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.${moduleName}.repository;
import com.zhiyou.infra.spring.data.repo.BaseRepository;
import ${basepackage}.${moduleName}.domain.${className};
import org.springframework.data.jpa.repository.Query;

public interface  ${className}Repository extends BaseRepository<${className},Long>{

}
