package com.threadblocked;

import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;

/**
 * Hello world!
 *
 */
public class GeneratorMain
{
    /**
	 * 请直接修改以下代码调用不同的方法以执行相关生成任务.
	 */
	public static void main(String[] args) throws Exception {
		GeneratorFacade g = new GeneratorFacade();
        GeneratorProperties.setProperty("moduleName", "navigate");
//		g.printAllTableNames();				//打印数据库中的表名称

		g.deleteOutRootDir();							//删除生成器的输出目录
//      String tables = "PRD_INF_ARTICLE,PRD_BUSINESS_RULE,PRD_PAY_WAY,PRD_PRESENT,PRD_DELIVERY_LOGISTICS_COMPANY,PRD_DELIVERY_WAY,PRD_DELIVERY_RULE,PRD_DELIVERY_RULE_ZONE_RELATIONSHIP";
//      String tables = "SYS_PARAM_INF,SYS_COMMENT,SYS_COMMENT_SESSION";
//      String tables = "PRD_INF_ARTICLE";
//	    String tables = "PRD_DELIVERY_LOGISTICS_COMPANY,PRD_DELIVERY_WAY,PRD_DELIVERY_RULE,PRD_DELIVERY_RULE_ZONE_RELATIONSHIP";

		//PRD_USER_PRODUCT_PROXY,PRD_PAGE_MODULE,PRD_PAGE_MODULE_OBJECT
	    String tables = "navigate_category,navigate_item";

        //设置生成器的模板目录
        g.getGenerator().setTemplateRootDir("/home/arthur/workspace/threadblocked/generator/template");

        for(String table : tables.split(",")){
           g.generateByTable(table);
        }
//		g.generateByTable("table_name","template");	//通过数据库表生成文件,template为模板的根目录
		//g.generateByAllTable("template");	//自动搜索数据库中的所有表并生成文件,template为模板的根目录
//		g.generateByClass(Blog.class,"template_clazz");
		 
//		g.deleteByTable("table_name", "template"); //删除生成的文件
		//打开文件夹
		//Runtime.getRuntime().exec("cmd.exe /c start "+GeneratorProperties.getRequiredProperty("outRoot"));
	}
}
