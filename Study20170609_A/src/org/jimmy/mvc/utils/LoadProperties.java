package org.jimmy.mvc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class LoadProperties
 *
 */
@WebListener
public class LoadProperties implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public LoadProperties() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	List<String> props = new ArrayList<>();
    	props.add("jdbc.properties");
    	props.add("message_exception.properties");
    	props.add("message_tips.properties");
    	
    	for (String name : props) {
    		loadProperties(name);
    	}
    }
    
    private void loadProperties(String name) {
    	InputStream in = getClass().getResourceAsStream("/" + name);
        Properties instance = new Properties();
        try {
			instance.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
        PropertiesUtils.addProperties(name, instance);
   }
	
}
