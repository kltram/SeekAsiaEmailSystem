package com.seekasia.emailsystem.init;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.seekasia.emailsystem.constant.CanditateConstant;
import com.seekasia.emailsystem.scheduler.SendEmailToActiveUserScheduler;
import com.seekasia.emailsystem.scheduler.SendEmailToNonResponsiveUser;
import com.seekasia.emailsystem.scheduler.StatusUpdateToActiveScheduler;
import com.seekasia.emailsystem.scheduler.StatusUpdateToInactiveScheduler;
import com.seekasia.emailsystem.scheduler.StatusUpdateToNonResponseScheduler;

@Configuration
@EnableScheduling
@ComponentScan("com.seekasia.emailsystem")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class WebAppConfig extends WebMvcConfigurerAdapter {

	private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
	private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

	@Resource
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan(env.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));
		sessionFactoryBean.setHibernateProperties(hibProperties());
		return sessionFactoryBean;
	}

	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
		return properties;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix(CanditateConstant.PREFIX);
		resolver.setSuffix(CanditateConstant.JSP_SUFFIX);
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(CanditateConstant.ASSETS_LBL).addResourceLocations(CanditateConstant.ASSETS_LABEL);
	}

	// Send Email--> "Active" all user --->every day regularly at 6.30 AM
	@Bean
	public SendEmailToActiveUserScheduler sendEmailToActiveUser() {
		return new SendEmailToActiveUserScheduler();
	}

	// Send Email--> "Non Responsive" all user --->3 day once at 6.30 AM
	@Bean
	public SendEmailToNonResponsiveUser sendEmailToNonResponsiveUser() {
		return new SendEmailToNonResponsiveUser();
	}

	// Mark it as a candidate status to "Non Responsive", if the user is
	// "Active" and user last login was more than 4 days ago
	@Bean
	public StatusUpdateToNonResponseScheduler updateStatsToNonResponsive() {
		return new StatusUpdateToNonResponseScheduler();
	}

	// Mark it as a candidate status to "Non Responsive", if the user is
	// "Active" and user last login was more than 2 days ago
	@Bean
	public StatusUpdateToActiveScheduler updateToActiveScheduler() {
		return new StatusUpdateToActiveScheduler();
	}

}
