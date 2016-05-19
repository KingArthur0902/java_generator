<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${moduleName}.domain;
import javax.persistence.*;
import com.zhiyou.infra.spring.data.entity.AbstractEntity;

@Entity
@Table(name = "${table.sqlName}")
public class ${className} extends AbstractEntity<Long>{

	//alias
	public static final String TABLE_ALIAS = "${table.tableAlias}";
	<#list table.columns as column>
	public static final String ${column.constantName} = "${column.columnAlias}";
	</#list>
	
	//columns START
	<#list table.columns as column>
	/**
	 * ${column.columnAlias!}	   db_column: ${column.sqlName} 
	 */	
	<#if column.pk>
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	</#if>
	@Column(name = "${column.sqlName}", unique = ${column.unique?string}, nullable = ${column.nullable?string}, insertable = true, updatable = true, length = ${column.size})
	private ${column.javaType} ${column.columnNameLower};
	</#list>
	//columns END

	<@generateConstructor className/>
	<@generateJavaColumns/>
	<@generateJavaOneToMany/>
	<@generateJavaManyToOne/>

}

<#macro generateJavaColumns>
<#list table.columns as column>
	<#if column.pk>
	public void setId(${column.javaType} ${column.columnName}) {
		this.${column.columnNameLower} = ${column.columnName};
	}

	public ${column.javaType} getId() {
		return this.${column.columnNameLower};
	}
	<#if column.columnName != 'Id'>
	public void set${column.columnName}(${column.javaType} ${column.columnName}) {
		this.${column.columnNameLower} = ${column.columnName};
	}
	@Transient
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	</#if>



	</#if>
	<#if !column.pk>
	public void set${column.columnName}(${column.javaType} ${column.columnName}) {
		this.${column.columnNameLower} = ${column.columnName};
	}

	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	</#if>


</#list>
</#macro>

<#macro generateJavaOneToMany>
	<#list table.exportedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable	= fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "${classNameLower}")
	private Set<${fkPojoClass}> ${fkPojoClassVar}s = new HashSet<${fkPojoClass}>(0);
	public void set${fkPojoClass}s(Set<${fkPojoClass}> ${fkPojoClassVar}){
		this.${fkPojoClassVar}s = ${fkPojoClassVar};
	}
	
	public Set<${fkPojoClass}> get${fkPojoClass}s() {
		return ${fkPojoClassVar}s;
	}
	</#list>
</#macro>

<#macro generateJavaManyToOne>
	<#list table.importedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable	= fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumns({
	<#list foreignKey.parentColumns?values as fkColumn>
		@JoinColumn(name = "${fkColumn}",nullable = false, insertable = false, updatable = false) <#if fkColumn_has_next>,</#if>
	</#list>
	})
	private ${fkPojoClass} ${fkPojoClassVar};
	
	public void set${fkPojoClass}(${fkPojoClass} ${fkPojoClassVar}){
		<#list fkSqlTable.columns as column>
			<#if column.pk>
		this.set${column.columnName}(${fkPojoClassVar} == null ? null : ${fkPojoClassVar}.get${column.columnName}());
			</#if>
		</#list>
		this.${fkPojoClassVar} = ${fkPojoClassVar};
	}
	
	public ${fkPojoClass} get${fkPojoClass}() {
		return ${fkPojoClassVar};
	}
	</#list>
</#macro>
