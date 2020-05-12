package Controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import Thymeleaf.PrimerThymeleaf;



/**
 * Servlet implementation class PrimerThymeleaf
 */
@WebServlet("/")
public class PrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	 private PrimerThymeleaf primerThymeleaf;
	 private ServletContext servletContext;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrimerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        servletContext = config.getServletContext();
        primerThymeleaf = new PrimerThymeleaf(servletContext);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 response.setContentType("text/html;charset=UTF-8");
	        response.setHeader("Pragma", "no-cache");
	        response.setHeader("Cache-Control", "no-cache");
	        response.setDateHeader("Expires", 0);
	            
	        WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
	        ctx.setVariable("today", new Date());
	        
	        TemplateEngine engine = primerThymeleaf.getTemplateEngine();
	        engine.process("home", ctx, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
