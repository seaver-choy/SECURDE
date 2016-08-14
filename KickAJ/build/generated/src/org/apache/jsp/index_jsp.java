package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <!--Import Google Icon Font-->\r\n");
      out.write("      <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n");
      out.write("      <!--Import materialize.css-->\r\n");
      out.write("      <link type=\"text/css\" rel=\"stylesheet\" href=\"materialize/css/materialize.min.css\"  media=\"screen,projection\"/>\r\n");
      out.write("\r\n");
      out.write("      <!--Let browser know website is optimized for mobile-->\r\n");
      out.write("      <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\r\n");
      out.write("\r\n");
      out.write("      <style>\r\n");
      out.write("        body {\r\n");
      out.write("          background-image: url('resources/graduatebackground.jpg');\r\n");
      out.write("          position: fixed;\r\n");
      out.write("          width: 100%;\r\n");
      out.write("          height: 95%;\r\n");
      out.write("          left: 0;\r\n");
      out.write("          top: 0;\r\n");
      out.write("          z-index: 10;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        h2 {\r\n");
      out.write("          color: #f3e5f5;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .layer {\r\n");
      out.write("            background-color: rgba(0, 0, 0, 0.7);\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            top: 0;\r\n");
      out.write("            left: 0;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 110%;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      </style>\r\n");
      out.write("</head>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "WEB-INF/navbar.jsp", out, false);
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <div class = \"layer\">\r\n");
      out.write("          <nav class = \"transparent\">\r\n");
      out.write("            <div class=\"nav-wrapper\">\r\n");
      out.write("              <a href=\"#\" class=\"brand-logo\" style=\"padding-left: 6px;\">Logo</a>\r\n");
      out.write("              <ul id=\"nav-mobile\" class=\"right hide-on-med-and-down\">\r\n");
      out.write("                <li><a href=\"WEB-INF/login.jsp\">Login</a></li>\r\n");
      out.write("                <li><a href=\"badges.html\">Register</a></li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("          </nav>\r\n");
      out.write("          <div class=\"valign-wrapper\" style=\"height: 90%; width: 100%\">\r\n");
      out.write("            <h2 class=\"valign center-block\">Please pass us!</h2>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-2.1.1.min.js\"></script>\r\n");
      out.write("      <script type=\"text/javascript\" src=\"materialize/js/materialize.min.js\"></script>\r\n");
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
