package org.jimmy.test;

import org.jimmy.util.CompileXML;
import org.junit.Test;

public class CompileXMLT {

	@Test
	public void test() {
		CompileXML xml = new CompileXML("web.xml");
		xml.getServletsMap();
	}

}
