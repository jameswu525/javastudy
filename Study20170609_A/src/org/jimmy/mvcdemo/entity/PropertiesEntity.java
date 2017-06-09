package org.jimmy.mvcdemo.entity;

import org.jimmy.mvc.entity.Entity;

public class PropertiesEntity extends Entity {
	String id;
	String name;
	String app_id;
	String telephone;
	String province;
	String city;
	String street;
	String start_time;
	String end_time;
	String zipcode;
	String isjde;
	String active;
	String created_at;
	String updated_at;
	String deleted_at;
	String mch_id;
	String partner_key;
	String bill_sync_day;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getApp_id() {
		return app_id;
	}
	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getIsjde() {
		return isjde;
	}
	public void setIsjde(String isjde) {
		this.isjde = isjde;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public String getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(String deleted_at) {
		this.deleted_at = deleted_at;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getPartner_key() {
		return partner_key;
	}
	public void setPartner_key(String partner_key) {
		this.partner_key = partner_key;
	}
	public String getBill_sync_day() {
		return bill_sync_day;
	}
	public void setBill_sync_day(String bill_sync_day) {
		this.bill_sync_day = bill_sync_day;
	}
	public String getAlipay_app_id() {
		return alipay_app_id;
	}
	public void setAlipay_app_id(String alipay_app_id) {
		this.alipay_app_id = alipay_app_id;
	}
	public String getAlipay_cer() {
		return alipay_cer;
	}
	public void setAlipay_cer(String alipay_cer) {
		this.alipay_cer = alipay_cer;
	}
	public String getAli_community_id() {
		return ali_community_id;
	}
	public void setAli_community_id(String ali_community_id) {
		this.ali_community_id = ali_community_id;
	}
	public String getOut_community_id() {
		return out_community_id;
	}
	public void setOut_community_id(String out_community_id) {
		this.out_community_id = out_community_id;
	}
	public String getAlipay_app_public() {
		return alipay_app_public;
	}
	public void setAlipay_app_public(String alipay_app_public) {
		this.alipay_app_public = alipay_app_public;
	}
	public String getAlipay_public() {
		return alipay_public;
	}
	public void setAlipay_public(String alipay_public) {
		this.alipay_public = alipay_public;
	}
	public String getAlipay_product_code() {
		return alipay_product_code;
	}
	public void setAlipay_product_code(String alipay_product_code) {
		this.alipay_product_code = alipay_product_code;
	}
	String alipay_app_id;
	String alipay_cer;
	String ali_community_id;
	String out_community_id;
	String alipay_app_public;
	String alipay_public;
	String alipay_product_code;

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id = " + id + " _ ");
		sb.append("name = " + name + " _ ");
		sb.append("app_id = " + app_id + " _ ");
		sb.append("telephone = " + telephone + " _ ");
		sb.append("province = " + province + " _ ");
		sb.append("city = " + city + " _ ");
		sb.append("street = " + street + " _ ");
		sb.append("start_time = " + start_time + " _ ");
		sb.append("end_time = " + end_time + " _ ");
		sb.append("zipcode = " + zipcode + " _ ");
		sb.append("isjde = " + isjde + " _ ");
		sb.append("active = " + active + " _ ");
		sb.append("created_at = " + created_at + " _ ");
		sb.append("updated_at = " + updated_at + " _ ");
		sb.append("deleted_at = " + deleted_at + " _ ");
		sb.append("mch_id = " + mch_id + " _ ");
		sb.append("partner_key = " + partner_key + " _ ");
		sb.append("bill_sync_day = " + bill_sync_day + " _ ");
		sb.append("alipay_app_id = " + alipay_app_id + " _ ");
		sb.append("alipay_cer = " + alipay_cer + " _ ");
		sb.append("ali_community_id = " + ali_community_id + " _ ");
		sb.append("out_community_id = " + out_community_id + " _ ");
		sb.append("alipay_app_public = " + alipay_app_public + " _ ");
		sb.append("alipay_public = " + alipay_public + " _ ");
		sb.append("alipay_product_code = " + alipay_product_code + " _ ");

		return sb.toString();
	}
}
