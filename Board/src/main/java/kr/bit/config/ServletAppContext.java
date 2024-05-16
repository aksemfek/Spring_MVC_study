package kr.bit.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.bit.interceptor.TopMenuInterceptor;
import kr.bit.mapper.BoardMapper;
import kr.bit.mapper.TopMenuMapper;
import kr.bit.mapper.UserMapper;
import kr.bit.service.TopMenuService;

@Configuration
@EnableWebMvc
@ComponentScan("kr.bit.controller")
@ComponentScan("kr.bit.dao")
@ComponentScan("kr.bit.service")
@PropertySource("/WEB-INF/properties/db.properties")
public class ServletAppContext implements WebMvcConfigurer {
	
	@Value("${db.classname}")
	private String db_classname;
	
	@Value("${db.url}")
	private String db_url;
	
	@Value("${db.username}")
	private String db_username;
	
	@Value("${db.password}")
	private String db_password;
	
	@Autowired
	private TopMenuService topMenuService; 
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource source= new BasicDataSource();
		source.setDriverClassName(db_classname);
		source.setUrl(db_url);
		source.setUsername(db_username);
		source.setPassword(db_password);
		
		return source;
	}
	
	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception{
		
		SqlSessionFactoryBean fac=new SqlSessionFactoryBean();
		fac.setDataSource(source);
		SqlSessionFactory factory=fac.getObject();
		return factory;
	}
	
	@Bean
	public MapperFactoryBean<TopMenuMapper> top_mapper(SqlSessionFactory factory) throws Exception{
		
		MapperFactoryBean<TopMenuMapper> fac = 
				new MapperFactoryBean<TopMenuMapper>(TopMenuMapper.class);
		
		fac.setSqlSessionFactory(factory);
		return fac;
		
	}
	
	@Bean
	public MapperFactoryBean<UserMapper> user_mapper(SqlSessionFactory factory) throws Exception{
		
		MapperFactoryBean<UserMapper> fac = 
				new MapperFactoryBean<UserMapper>(UserMapper.class);
		
		fac.setSqlSessionFactory(factory);
		return fac;
		
	}
	
	@Bean
	public MapperFactoryBean<BoardMapper> board_mapper(SqlSessionFactory factory) throws Exception{
		
		MapperFactoryBean<BoardMapper> fac = 
				new MapperFactoryBean<BoardMapper>(BoardMapper.class);
		
		fac.setSqlSessionFactory(factory);
		return fac;
		
	}
	
	public void addInterceptors(InterceptorRegistry re) {
		WebMvcConfigurer.super.addInterceptors(re);
		
		TopMenuInterceptor top = new TopMenuInterceptor(topMenuService);
		
		InterceptorRegistration re1 = re.addInterceptor(top); // topmenuInterceptor 등
		
		re1.addPathPatterns("/**"); // 모든 경로로 매핑해도 다 뜨도록 컨트롤러 전에 preHandle
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res= new ReloadableResourceBundleMessageSource();
		
		res.setBasename("/WEB-INF/properties/error");
		return res;
	}
	
}






