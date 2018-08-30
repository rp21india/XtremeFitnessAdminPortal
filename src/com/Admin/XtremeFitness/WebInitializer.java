package com.Admin.XtremeFitness;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

		@Override
		protected Class<?>[] getRootConfigClasses() {
			// TODO Auto-generated method stub
			return new Class[]{XtrmeConfig.class};
		}

		@Override
		protected Class<?>[] getServletConfigClasses() {
			// TODO Auto-generated method stub
			return new Class[]{XtrmeConfig.class};
		}

		@Override
		protected String[] getServletMappings() {
			System.out.println("**getServletMapping");
			return new String[]{"*.jlc"};
		}

	}
