package org.jimmy.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class DAO<T, E> {
	public DAO() {
		Type clzzType = getClass().getGenericSuperclass();
		if (clzzType instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) clzzType;
			Type[] ts = pt.getActualTypeArguments();
			for (Type t : ts)
				System.out.println("super " + t.getTypeName());
		}
	}
}
