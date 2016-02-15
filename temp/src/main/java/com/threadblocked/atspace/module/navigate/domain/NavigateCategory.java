/*
 * Web Site: http://www.threadblocked.com
 * Since 2010 - 2016
 */

package com.threadblocked.atspace.module.navigate.domain;

import java.util.*;
import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.threadblocked.atspace.commons.base.*;
import com.threadblocked.atspace.commons.util.DateConvertUtils;

import com.threadblocked.atspace.module.navigate.domain.*;

@Entity
@Table(name = "navigate_category")
public class NavigateCategory extends BaseEntity{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "NavigateCategory";
	public static final String CATEGORY_ID = "categoryId";
	public static final String NAME = "name";
	public static final String IS_DELETE = "isDelete";
	public static final String CREATE_DATE = "createDate";
	
	//date formats
	public static final String FORMAT_CREATE_DATE = DATE_FORMAT;
	
	
	//columns START
	/**
	 * categoryId	   db_column: CATEGORY_ID 
	 */	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CATEGORY_ID", unique = true, nullable = false, insertable = true, updatable = true, length = 10)
	private java.lang.Integer categoryId;
	/**
	 * name	   db_column: NAME 
	 */	
	@Column(name = "NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 60)
	private java.lang.String name;
	/**
	 * isDelete	   db_column: IS_DELETE 
	 */	
	@Column(name = "IS_DELETE", unique = false, nullable = false, insertable = true, updatable = true, length = 2)
	private java.lang.String isDelete;
	/**
	 * createDate	   db_column: CREATE_DATE 
	 */	
	@Column(name = "CREATE_DATE", unique = false, nullable = false, insertable = true, updatable = true, length = 19)
	private java.sql.Timestamp createDate;
	//columns END

	public NavigateCategory(){
	}

	public NavigateCategory(
		java.lang.Integer categoryId
	){
		this.categoryId = categoryId;
	}

	public void setCategoryId(java.lang.Integer value) {
		this.categoryId = value;
	}
	
	public java.lang.Integer getCategoryId() {
		return this.categoryId;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setIsDelete(java.lang.String value) {
		this.isDelete = value;
	}
	
	public java.lang.String getIsDelete() {
		return this.isDelete;
	}
	public String getCreateDateString() {
		return DateConvertUtils.format(getCreateDate(), FORMAT_CREATE_DATE);
	}
	public void setCreateDateString(String value) {
		setCreateDate(DateConvertUtils.parse(value, FORMAT_CREATE_DATE,java.sql.Timestamp.class));
	}
	
	public void setCreateDate(java.sql.Timestamp value) {
		this.createDate = value;
	}
	
	public java.sql.Timestamp getCreateDate() {
		return this.createDate;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("CATEGORY_ID",getCategoryId())
			.append("NAME",getName())
			.append("IS_DELETE",getIsDelete())
			.append("CREATE_DATE",getCreateDate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCategoryId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(this.getCategoryId() == null){
			return false;
		}
		if(!(obj instanceof NavigateCategory)){
			return false;
		}
		if(this == obj) {
			return true;
		}
		NavigateCategory other = (NavigateCategory)obj;
		return new EqualsBuilder()
			.append(getCategoryId(),other.getCategoryId())
			.isEquals();
	}
}

