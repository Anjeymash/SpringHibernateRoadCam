package by.anjeymash.tasks.roadcam.contextlistner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MyAppServletContextListener implements ServletContextListener {

	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContextListener destroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		System.out.println("ServletContextListener started");
	}
}