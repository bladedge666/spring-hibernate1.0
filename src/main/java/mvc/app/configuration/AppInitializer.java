/*package mvc.app.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { HibernateConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebMvcConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}
*/
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//public class AppInitializer implements WebApplicationInitializer {
//
//	@Override
//	public void onStartup(ServletContext container) throws ServletException {
//
//		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//		ctx.register(WebMvcConfiguration.class);
//		ctx.setServletContext(container);
//		container.addListener(new ContextLoaderListener(ctx));
//
//
//		AnnotationConfigWebApplicationContext hibernateContext = new AnnotationConfigWebApplicationContext();
//		hibernateContext.register(HibernateConfig.class); //e.g hibernate config etc. Just loading it to the spring container
//		
//		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));
//
//		servlet.setLoadOnStartup(1);
//		servlet.addMapping("/");
//	}
//
//}