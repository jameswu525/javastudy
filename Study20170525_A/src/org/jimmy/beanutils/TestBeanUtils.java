package org.jimmy.beanutils;

import org.apache.commons.beanutils.BeanUtils;
import org.jimmy.jdbc.PropertiesBean;
import org.junit.Test;

public class TestBeanUtils {

	@Test
	public void testSetProperty() throws Exception {
		PropertiesBean bean = new PropertiesBean();
		BeanUtils.setProperty(bean, "id", "10");
		BeanUtils.setProperty(bean, "city", "SHANGHAI");
		
		System.out.println(bean);
		System.out.println(BeanUtils.getProperty(bean,  "city"));
		
	}

}
