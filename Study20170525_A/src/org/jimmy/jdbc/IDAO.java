package org.jimmy.jdbc;

import java.util.List;

public interface IDAO {
	// 获取一条记录
	<T> T get(Class<T> clazz, String sql, Object ... args);
	// 获取记录集合
	<T> List<T> getList(Class<T> claszz, String sql, Object ... args);
	// 更新
	void update(String sql, Object ... args);
	// 返回某记录某个字段值
	<E> E getValue(String sql, Object ... args);
}
