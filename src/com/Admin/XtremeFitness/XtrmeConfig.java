package com.Admin.XtremeFitness;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan({"com.Admin.XtremeFitness"})

public class XtrmeConfig {
		
	@Bean
	public TilesViewResolver tilesViewResolver(){
		TilesViewResolver viewResolver=new TilesViewResolver();
		return viewResolver;
	}
	@Bean
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer configurer=new TilesConfigurer();
		configurer.setDefinitions("WEB-INF/tiles.xml");
		return configurer;
		
	}
	}
