package com.xtreme.spring.mvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class xtremeWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

		@Override
		protected Class<?>[] getRootConfigClasses() {
			// TODO Auto-generated method stub
			return new Class[]{xtremeConfig.class};
		}

		@Override
		protected Class<?>[] getServletConfigClasses() {
			// TODO Auto-generated method stub
			return new Class[]{xtremeConfig.class};
		}

		@Override
		protected String[] getServletMappings() {
			System.out.println("**getServletMapping");
			return new String[]{"/","*.jlc"};
		}

	}
