package org.jimmy.mvcdemo.dao;

import java.util.List;

import org.jimmy.mvc.dao.DAO;
import org.jimmy.mvcdemo.entity.PropertyEntity;

public class PropertiesDAO extends DAO<PropertyEntity> {
	public int deleteProperty(String id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" 	update	");
		sb.append(" 	t_property	set deleted_at = current_date");
		sb.append(" 	where id = ? ");
		String sql = sb.toString();
		System.out.println(sql);
		return update(sql, new Object[] { Integer.valueOf(id).intValue() });
	}

	public List<PropertyEntity> getPropertiesList(Object ... args) {
		StringBuilder sb = new StringBuilder();
		sb.append(" 	select id,	");
		sb.append(" 	name,	");
		sb.append(" 	app_id,	");
		sb.append(" 	telephone,	");
		sb.append(" 	province,	");
		sb.append(" 	city,	");
		sb.append(" 	street,	");
		sb.append(" 	zipcode,	");
		sb.append(" 	deleted_at	");
		sb.append(" 	from t_property	");
		sb.append(" 	where (1 = 1 ");
		for (int i = 0; args != null && i < args.length; i++) {
			sb.append(" or id = ? ");
		}
		sb.append(" ) and deleted_at is null ");
		sb.append(" 	order by id");
		String sql = sb.toString();
		System.out.println(sql);
		return queryList(sql, args);
	}
}
