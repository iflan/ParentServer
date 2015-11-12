package wang.ming15.parentserver.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Created by wanggnim on 2015/11/4.
 */

public enum SpringConfig {

	INSTANCE;

	SpringConfig() {
		applicationContext = getByClassPathXMLApplicationContext();
	}

	private ApplicationContext applicationContext;

	private ApplicationContext getByClassPathXMLApplicationContext() {
		return new ClassPathXmlApplicationContext("classpath:applicationContext.XML");
	}

	private ApplicationContext getByFileSystemXMLApplicationContext() {
		return new FileSystemXmlApplicationContext("src/applicationContext.XML");
	}

	private ApplicationContext getByXMLWebApplicationContext() {
		XmlWebApplicationContext context = new XmlWebApplicationContext();
		context.setAllowCircularReferences(true);
		context.setConfigLocations(new String[]{"classpath:/applicationContext.xml",});
		context.refresh();

		return context;
	}

	public void printInfo() {
		System.out.println(applicationContext.getId() + "  " + applicationContext.getApplicationName());
	}
}
