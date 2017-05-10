package org.jimmy.cordemo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
	// Date中的大量方法已经过时，官方建议使用Calendar。
	private Date birthDate = new Date(System.currentTimeMillis()-100000000l);
	private Date hireDate = new Date();
//	private Calendar birthD = new Calendar();
	
	public void test() {
		System.out.println(this.birthDate);
		System.out.println(this.birthDate.toLocaleString());
		System.out.println(new Date(System.currentTimeMillis()));
		System.out.println(new Date(new Date().getTime()));

		String d1 = DateFormat.getInstance().format(this.birthDate);
		System.out.println(d1);
		System.out.println(DateFormat.getDateInstance(DateFormat.LONG).format(this.birthDate));
		System.out.println(DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(this.birthDate));
		System.out.println(DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(this.birthDate));

		System.out.println("========================");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss E --yyyy");
		try {
			System.out.println(DateFormat.getInstance().parse(d1));
			
			System.out.println(sdf.format(this.birthDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public String DateConver2String(Date dt, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat();
		if (pattern != null || !"".equals(pattern)) {
			df.applyPattern(pattern);
		}
		return df.format(dt);
	}
	
	public void testCalendar() {
		Calendar c = Calendar.getInstance(); // 抽象类，日历比Date强大
		
		System.out.println(c);
		int yyyy = c.get(Calendar.YEAR);
		System.out.println(c.getTime());
		System.out.println(yyyy + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.DAY_OF_MONTH));
		c.setTimeInMillis(System.currentTimeMillis() - 100000000l);
		System.out.println(c.getTime());
		
		c.setTime(new Date());
		c.set(2016, 0, 2);
		System.out.println(c.getTime());
//		System.out.println(c.get(Calendar.));

	}
	
	public static void main(String[] args) {
		DateDemo dd = new DateDemo();
		System.out.println(dd.DateConver2String(new Date(), "yyyy-mm-dd HH:mm:ss"));
		System.out.println(dd.DateConver2String(new Date(), "yyyy-mm-dd"));
		System.out.println(dd.DateConver2String(new Date(), "yyyy/mm/dd HH:mm:ss"));
//		dd.testCalendar();
	}

}
