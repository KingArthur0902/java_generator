##Description##
这是一个java的模板代码生成器。通过使用rapid framework generator 和 freemarker，
事先写好需要生成的模板代码，然后通过从数据库读取表的结构来生成domain，service，controller等

##Usage##
1.  fork项目后，查看template目录下的模板代码，修改成符合自己实际的模板，比如引入的包，实现的接口等
2.  修改generator.xml中的属性，比如输出目录，数据库链接属性，模块路径等
3.  修改CodeGenerator.java中的模板设置目录
4.  在数据库中建好相对应的表，在pom.xml的绑定执行类里面传入要建模的表名
5.  由于已经把CodeGenerator.java绑定到maven的test过程中了，执行该类的main方法，只需：mvn test