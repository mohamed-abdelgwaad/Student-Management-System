package com.anywaresoftware.configurations;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;
import java.io.IOException;

@org.springframework.context.annotation.Configuration
public class HibernateConfig {

	@Autowired
	private ResourceLoader resourceLoader;

	@Bean
	@Primary
	public SessionFactory sessionFactory() throws IOException {
		// Load hibernate.cfg.xml from the resources folder
		Configuration configuration = new Configuration();
		configuration.configure(resourceLoader.getResource("classpath:hibernate.cfg.xml").getURI().toURL());
		return configuration.buildSessionFactory();
	}
}
