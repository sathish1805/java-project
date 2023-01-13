package net.first.hibernate.util;



import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import net.first.hibernate.model.Student;


public class HibernateUtil {
	private static SessionFactory sessionFactory;
public static SessionFactory getSesssionFactory() {
	if(sessionFactory== null) {
		try {
			Configuration con =new Configuration();
		Properties settings=new Properties();
		settings.put(Environment.DRIVER,"com.cj.jdbc.Driver");
		settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_demo?useSSL=false");
		settings.put(Environment.USER,"root");
		settings.put(Environment.PASS,"root");
		settings.put(Environment.DIALECT,"org.hibernate.dialect.MYSQL5dialect");
		settings.put(Environment.SHOW_SQL,"true");
		settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
		settings.put(Environment.HBM2DDL_AUTO,"CREATE-DROP");
		con.setProperties(settings);
		con.addAnnotatedClass(Student.class);
		ServiceRegistry serviceRegistry =new StandardServiceRegistryBuilder().applySettings
				(con.getProperties()).build();
		sessionFactory =con.buildSessionFactory(serviceRegistry);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
return sessionFactory;
}
}