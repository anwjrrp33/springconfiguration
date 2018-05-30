package org.zerock.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import lombok.extern.log4j.Log4j;

@Log4j
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		log.info("getRootConfigClasses");
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		log.info("getServletConfigClasses");
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		log.info("getServletMappings");
		return new String[] {"/"};
	}
	
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {

	    registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
	    
	    MultipartConfigElement multipartConfig = new MultipartConfigElement("C:\\upload\\temp", 20971520, 41943040, 20971520);
	    registration.setMultipartConfig(multipartConfig);

	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
	    characterEncodingFilter.setEncoding("UTF-8");
	    characterEncodingFilter.setForceEncoding(true);

	    return new Filter[] { characterEncodingFilter };
	}
}
