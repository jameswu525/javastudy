package org.jimmy.reflect;

import java.lang.reflect.Type;

public class StudentDAO extends DAO<Student, String>{
	public StudentDAO() {
		Type clzzType = getClass().getGenericSuperclass();
		System.out.println("sun " + clzzType.getTypeName());
	}
	
	public static void main(String[] args) {
		DAO dao = new StudentDAO();
	}
}
