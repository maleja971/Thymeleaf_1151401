package Thymeleaf;

import javax.servlet.ServletContext;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

public class PrimerThymeleaf {
	
	 private final TemplateEngine templateEngine;

	public PrimerThymeleaf(final ServletContext ctx) {
		// TODO Auto-generated constructor stub
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(ctx);
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheTTLMs(3600000L);
        templateResolver.setCacheable(true);

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
	}
	
	public TemplateEngine getTemplateEngine() {
        return templateEngine;
    }

}
