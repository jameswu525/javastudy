package org.jimmy.mvcdemo.dao;

import java.util.List;

import org.jimmy.mvc.dao.DAO;
import org.jimmy.mvc.utils.DaoUtils;
import org.jimmy.mvcdemo.entity.PropertiesEntity;

public class PropertiesDAO extends DAO {
	public List<PropertiesEntity> getPropertiesList() {
		StringBuilder sb = new StringBuilder();
		sb.append(" 	select id,	");
		sb.append(" 	name,	");
		sb.append(" 	app_id,	");
		sb.append(" 	telephone,	");
		sb.append(" 	province,	");
		sb.append(" 	city,	");
		sb.append(" 	street,	");
		sb.append(" 	start_time,	");
		sb.append(" 	end_time,	");
		sb.append(" 	zipcode,	");
		sb.append(" 	isjde,	");
		sb.append(" 	active,	");
		sb.append(" 	created_at,	");
		sb.append(" 	updated_at,	");
		sb.append(" 	deleted_at,	");
		sb.append(" 	mch_id,	");
		sb.append(" 	partner_key,	");
		sb.append(" 	bill_sync_day,	");
		sb.append(" 	alipay_app_id,	");
		sb.append(" 	alipay_cer,	");
		sb.append(" 	ali_community_id,	");
		sb.append(" 	out_community_id,	");
		sb.append(" 	alipay_app_public,	");
		sb.append(" 	alipay_public,	");
		sb.append(" 	alipay_product_code	");
		sb.append(" 	from kerry_properties	");
		sb.append(" 	where id = ? or id = ? or id = ?");
		sb.append(" 	order by id");
		String sql = sb.toString();
		return DaoUtils.queryAsList(PropertiesEntity.class, sql, new Object[]{1, 2, 6});
	}
}
