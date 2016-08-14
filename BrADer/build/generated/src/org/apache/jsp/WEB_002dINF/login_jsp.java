package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <script type=\"text/javascript\" src=\"http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.10.2/validator.min.js\"></script>\r\n");
      out.write("    <link href=\"http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css\"\r\n");
      out.write("          rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    <link href=\"http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css\"\r\n");
      out.write("          rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navbar.jsp", out, false);
      out.write("\r\n");
      out.write("<div class=\"section\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        ");
 if (request.getParameter("username") != null) { 
      out.write("\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-12\">\r\n");
      out.write("                <div class=\"alert alert-dismissable alert-success\" contenteditable=\"true\">\r\n");
      out.write("                    <b>Account successfully created! Please login to continue.</b>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-12\">\r\n");
      out.write("                <form role=\"form\" action=\"login\" method=\"post\" data-toggle=\"validator\">\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label class=\"control-label\" for=\"usernameField\">Username</label>\r\n");
      out.write("                        <input class=\"form-control\" id=\"usernameField\"\r\n");
      out.write("                               placeholder=\"Enter username\" type=\"text\" name=\"username\" maxlength=\"256\" required>\r\n");
      out.write("                        <div class=\"help-block with-errors\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"form-group\">\r\n");
      out.write("                        <label class=\"control-label\" for=\"passwordField\">Password</label>\r\n");
      out.write("                        <input class=\"form-control\" id=\"passwordField\"\r\n");
      out.write("                               placeholder=\"Password\" type=\"password\" name=\"password\" maxlength=\"45\" required>\r\n");
      out.write("                        <div class=\"help-block with-errors\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-default\">Login</button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
