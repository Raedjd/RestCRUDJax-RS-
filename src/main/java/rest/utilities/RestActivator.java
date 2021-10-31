package rest.utilities;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;



@ApplicationPath("/api")
public class RestActivator extends Application {
		
	public RestActivator() {
		// TODO Auto-generated constructor stub
	
		  super();
		 
		  BeanConfig beanConfig = new BeanConfig();
		 
		  beanConfig.setVersion("1.0.0");
		  beanConfig.setSchemes(new String[]{"http"});
//		  beanConfig.setHost("localhost:8080");
		  beanConfig.setBasePath("GE/api");
		  beanConfig.setResourcePackage("rest.ressources");
		  beanConfig.setScan(true);
		}


}
