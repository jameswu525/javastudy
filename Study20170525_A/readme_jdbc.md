JDBC
-----

持久化数据
JDBC是Java访问数据库的基石，JDO、Hibernate、iBatis等知识封装了JDBC。

DAO : Data Access Object 更好地实现功能的模块化
// 获取一条记录
<T> T get(Class<T> clazz, String sql, Object ... args);
// 获取记录集合
<T> List<T> getList(Class<T> claszz, String sql, Object ... args);
// 更新
void update(String sql, Object ... args);
// 返回某记录某个字段值
<E> E getValue(String sql, Object ... args);




为访问不同的数据库提供一种统一的途径，屏蔽了细节问题。

数据库连接池：
javax.sql.Datasource 通常由服务器厂商（weblogic、tomcat等）实现
另外的常用开源数据库连接池的包：
DBCP
C3P0