/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.41
 * Generated at: 2020-12-30 17:25:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import member.model.vo.Member;

public final class myPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/member/../common/header.jsp", Long.valueOf(1609181214802L));
    _jspx_dependants.put("/views/member/../common/footer.jsp", Long.valueOf(1609120104000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.vo.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	Member member = (Member)request.getAttribute("member");

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<!-- <link rel=\"shortcut icon\" href=\"resources/images/star.png\" type=\"favicon/ico\" /> -->\r\n");
      out.write("\r\n");
      out.write("<title>농부의 텃밭</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../../resources/css/bootstrap.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../../resources/css/font-awesome.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../../resources/css/owl.carousel.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../../resources/css/owl.theme.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../../resources/css/animate.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../../resources/css/flexslider.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../../resources/css/pricing.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../../resources/css/main.css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"../../resources/js/jquery-1.11.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../resources/js/jquery.flexslider.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(window).load(function() {\r\n");
      out.write("\t\t$('.flexslider').flexslider({\r\n");
      out.write("\t\t\tanimation : \"slide\",\r\n");
      out.write("\t\t\tcontrolsContainer : \".flexslider-container\"\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body data-spy=\"scroll\" data-target=\"#template-navbar\">\r\n");
      out.write("\r\n");
      out.write("\t<!--== 헤더 ==-->\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<header>\r\n");
      out.write("\t\t<!--== 헤더 ==-->\r\n");
      out.write("\t\t<div class=\"blank\" style=\"background-color:#a4cd73; height:140px;\"></div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!--== 네비게이션 바 ==-->\r\n");
      out.write("\t\t<div class=\"pricing-filter\">\r\n");
      out.write("\t\t\t\t<div class=\"pricing-filter-wrapper\">\r\n");
      out.write("\t\t\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-10 col-md-offset-1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"section-header\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul id=\"filter-list\" class=\"clearfix\" align=\"middle\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li class=\"filter\" data-filter=\"all\">전체</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li class=\"filter\" data-filter=\".breakfast\">야채/채소</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li class=\"filter\" data-filter=\".special\">곡물</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li class=\"filter\" data-filter=\".desert\"><a style=\"color:red;\">할인상품</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li class=\"filter\" data-filter=\".dinner\">나눔의 장</li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<!-- @end #filter-list -->\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t<nav id=\"template-navbar\"\r\n");
      out.write("\t\t\tclass=\"navbar navbar-default custom-navbar-default navbar-fixed-top\">\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t\t<!-- Brand and toggle get grouped for better mobile display -->\r\n");
      out.write("\t\t\t\t<div class=\"navbar-header\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\"\r\n");
      out.write("\t\t\t\t\t\tdata-toggle=\"collapse\" data-target=\"#Food-fair-toggle\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"sr-only\">Toggle navigation</span> <span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"icon-bar\"></span>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t<a class=\"navbar-brand\" href=\"#\"> <img id=\"logo\"\r\n");
      out.write("\t\t\t\t\t\tsrc=\"/nongbu/resources/images/Logo_main.png\" class=\"logo img-responsive\">\r\n");
      out.write("\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- Collect the nav links, forms, and other content for toggling -->\r\n");
      out.write("\t\t\t\t<div class=\"collapse navbar-collapse\" id=\"Food-fair-toggle\">\r\n");
      out.write("\t\t\t\t\t<ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#reserve\">공지사항</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#contact\">고객센터</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#about\">회원가입</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/nongbu/views/member/loginPage.jsp\">로그인</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/nongbu/views/member/myPage.jsp\">마이페이지</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#featured-dish\">장바구니</a></li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- /.navbar-collapse -->\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- /.row -->\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t</header>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!--== 내용 ==-->\r\n");
      out.write("\t<form action=\"/nongbu/mupdate\" method=\"post\">\r\n");
      out.write("\t\t<table id=\"outer\" align=\"center\" width=\"500\" cellspacing=\"5\"\r\n");
      out.write("\t\t\tcellpadding=\"0\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th width=\"120\">이 름</th>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"username\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(member.getUserName());
      out.write("\" readonly></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<!-- readonly > 서버로 전송은 가지만 수정은 못함 -->\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th width=\"120\">아이디</th>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"userid\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(member.getUserId());
      out.write("\" readonly></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th width=\"120\">암 호</th>\r\n");
      out.write("\t\t\t\t<td><input type=\"password\" name=\"userpwd\" id=\"userpwd1\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(member.getUserPwd());
      out.write("\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th width=\"120\">암호확인</th>\r\n");
      out.write("\t\t\t\t<td><input type=\"password\" id=\"userpwd2\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th width=\"120\">전화번호</th>\r\n");
      out.write("\t\t\t\t<td><input type=\"tel\" name=\"phone\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(member.getPhone());
      out.write("\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th width=\"120\">이메일</th>\r\n");
      out.write("\t\t\t\t<td><input type=\"email\" name=\"email\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(member.getEmail());
      out.write("\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th width=\"120\" colspan=\"2\"><a\r\n");
      out.write("\t\t\t\t\thref=\"javascript:history.go(-1);\">이전 페이지로 이동</a> &nbsp; <input\r\n");
      out.write("\t\t\t\t\ttype=\"submit\" value=\"수정하기\"> &nbsp; <input type=\"reset\"\r\n");
      out.write("\t\t\t\t\tvalue=\"수정취소\"></th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("\t<hr>\r\n");
      out.write("\r\n");
      out.write("\t<!--== 푸터 ==-->\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<footer>\r\n");
      out.write("<section id=\"contact\" class=\"contact\">\r\n");
      out.write("            <div class=\"container-fluid color-bg\">\r\n");
      out.write("                <div class=\"row dis-table\">\r\n");
      out.write("                    <div class=\"hidden-xs col-sm-6 dis-table-cell\">\r\n");
      out.write("                        <h2 class=\"section-title\">Contact With us</h2>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"col-xs-6 col-sm-6 dis-table-cell\">\r\n");
      out.write("                        <div class=\"section-content\">\r\n");
      out.write("                            <p>16th Birn street Get Plaza (4th floar) USA</p>\r\n");
      out.write("                            <p>+44 12 213584</p>\r\n");
      out.write("                            <p>example@mail.com </p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("            <div class=\"container\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-md-6 col-md-offset-3\">\r\n");
      out.write("                        <div class=\"copyright text-center\">\r\n");
      out.write("                            <p>\r\n");
      out.write("                                &copy; Copyright, 2015 <a href=\"#\">Your Website Link.</a> Theme by <a href=\"http://themewagon.com/\"  target=\"_blank\">ThemeWagon</a>\r\n");
      out.write("                            </p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"../../resources/js/bootstrap.min.js\"></script>\r\n");
      out.write("\t<script src=\"../../resources/js/owl.carousel.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\"\r\n");
      out.write("\t\tsrc=\"../../resources/js/jquery.mixitup.min.js\"></script>\r\n");
      out.write("\t<script src=\"../../resources/js/wow.min.js\"></script>\r\n");
      out.write("\t<script src=\"../../resources/js/jquery.validate.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\"\r\n");
      out.write("\t\tsrc=\"../../resources/js/jquery.hoverdir.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\"\r\n");
      out.write("\t\tsrc=\"../../resources/js/jQuery.scrollSpeed.js\"></script>\r\n");
      out.write("\t<script src=\"../../resources/js/script.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}