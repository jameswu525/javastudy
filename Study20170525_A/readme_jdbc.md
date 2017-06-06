JDBC
-----

持久化数据
JDBC是Java访问数据库的基石，JDO、Hibernate、iBatis等知识封装了JDBC。

为访问不同的数据库提供一种统一的途径，屏蔽了细节问题。

数据库连接池：
javax.sql.Datasource 通常由服务器厂商（weblogic、tomcat等）实现
另外的常用开源数据库连接池的包：
DBCP
C3P0