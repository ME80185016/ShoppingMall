/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.76
 * Generated at: 2018-05-02 01:11:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class roleLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
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

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"zh-CN\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\r\n");
      out.write("<title>购衣商城系统登录</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ShoppingMall/css/style.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"login-container\">\r\n");
      out.write("\t<h1>*****ROLE-LOGIN*****</h1>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- <div class=\"connect\">\r\n");
      out.write("\t\t<p>www.moke8.com</p>\r\n");
      out.write("\t</div> -->\r\n");
      out.write("\t\r\n");
      out.write("\t<form action=\"\" method=\"post\" id=\"loginForm\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<input type=\"text\" name=\"role_name\" class=\"username\" placeholder=\"用户名\" autocomplete=\"off\" id=\"loginBy\"/>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<input type=\"password\" name=\"role_pwd\" class=\"password\" placeholder=\"密码\" oncontextmenu=\"return false\" onpaste=\"return false\" id=\"role_pwd\"/>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"roleType\" onclick=\"funRoleType()\">\r\n");
      out.write("\t\t\t<label><input type=\"radio\" name=\"roleType\" value=\"user\" checked=\"checked\"/>用户</label>\r\n");
      out.write("\t\t\t<label><input type=\"radio\" name=\"roleType\" value=\"store\"/>店铺</label>\r\n");
      out.write("\t\t\t<label><input type=\"radio\" name=\"roleType\" value=\"admin\"/>管理</label>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<button id=\"submit\" type=\"submit\" onclick=\"funLogin()\">登 陆</button>\r\n");
      out.write("\t\t<select id=\"loginType\"\" onclick=\"funLoginType()\">\r\n");
      out.write("\t\t\t<option value=\"\" >登录方式</option>\r\n");
      out.write("\t\t\t<option value=\"loginByName\">用户名登录</option>\r\n");
      out.write("\t\t\t<option value=\"loginByTel\">手机号登录</option>\r\n");
      out.write("\t\t</select>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("\t<a href=\"/ShoppingMall/page/user/userRegister.jsp\">\r\n");
      out.write("\t\t<button type=\"button\" class=\"register-tis\">还没有账号？</button>\r\n");
      out.write("\t</a>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script src=\"/ShoppingMall/js/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"/ShoppingMall/js/common.js\"></script>\r\n");
      out.write("<!--背景图片自动更换-->\r\n");
      out.write("<script src=\"/ShoppingMall/js/supersized.3.2.7.min.js\"></script>\r\n");
      out.write("<script src=\"/ShoppingMall/js/supersized-init.js\"></script>\r\n");
      out.write("<!--表单验证-->\r\n");
      out.write("<script src=\"/ShoppingMall/js/jquery.validate.min.js?var1.14.0\"></script>\r\n");
      out.write("<!--\r\n");
      out.write("\t作者：offline\r\n");
      out.write("\t时间：2018-03-11\r\n");
      out.write("\t描述：js验证哪个角色使用哪个登录方式进行登录\r\n");
      out.write("-->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t/**\r\n");
      out.write("\t * 判断是哪个角色进行登录\r\n");
      out.write("\t */\r\n");
      out.write("\tfunction funRoleType(){\r\n");
      out.write("\t\tvar values=document.getElementsByName(\"roleType\");\r\n");
      out.write("\t\tvar checkedValue=null;\r\n");
      out.write("\t\t   for(var i=0;i<values.length;i++){\r\n");
      out.write("\t\t\t        if(values[i].checked==true)\r\n");
      out.write("\t\t\t\t\t checkedValue=values[i].value;\r\n");
      out.write("\t\t\t\t} \r\n");
      out.write("\t\t\t\treturn checkedValue;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t/**\r\n");
      out.write("\t * 判断角色使用哪种登录方式进行登录\r\n");
      out.write("\t */\r\n");
      out.write("\tfunction funLoginType(){\r\n");
      out.write("\t\tvar loginType=document.getElementById(\"loginType\");\r\n");
      out.write("\t\tvar index=loginType.selectedIndex;\r\n");
      out.write("\t\tvar loginby=document.getElementById(\"loginBy\");\r\n");
      out.write("\t\t\t//alert(values[i].value);\r\n");
      out.write("\t\t\tif(loginType.options[index].value==\"loginByTel\"){\r\n");
      out.write("\t\t\t\tloginby.name=\"role_tel\";\r\n");
      out.write("\t\t\t\tloginby.placeholder=\"请输入手机号\";\r\n");
      out.write("\t\t\t}else if (loginType.options[index].value==\"loginByName\") {\r\n");
      out.write("\t\t\t\tloginby.name=\"role_name\";\r\n");
      out.write("\t\t\t\tloginby.placeholder=\"请输入用户名\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\treturn loginType.options[index].value;\r\n");
      out.write("\t}\r\n");
      out.write("\t/**\r\n");
      out.write("\t * 该方法在判断出角色以及登录方式以后，将对应的action传到form表单\r\n");
      out.write("\t */\r\n");
      out.write("\tfunction funLogin(){\r\n");
      out.write("\t\tvar roleType=funRoleType();\r\n");
      out.write("\t\tvar loginType=funLoginType();\r\n");
      out.write("\t\tvar loginForm=document.getElementById(\"loginForm\");\r\n");
      out.write("\t\tvar role_name=document.getElementById(\"loginBy\").value;\r\n");
      out.write("\t\tvar role_pwd=document.getElementById(\"role_pwd\").value;\r\n");
      out.write("\t\tif(role_name==null||role_name==\"\"){\r\n");
      out.write("\t\t\talert(\"请输入用户名\");\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tif(role_pwd==null||role_pwd==\"\"){\r\n");
      out.write("\t\t\t\talert(\"请输入密码\");\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tif(roleType==\"user\"){\r\n");
      out.write("\t\t\t\t\tif(loginType==\"loginByName\"){\r\n");
      out.write("\t\t\t\t\t\t/* alert(\"userlogin\"); */\r\n");
      out.write("\t\t\t\t\t\tloginForm.action=\"/ShoppingMall/user/userLoginByName.do\";\r\n");
      out.write("\t\t\t\t\t\tloginForm.submit();\r\n");
      out.write("\t\t\t\t\t}else if(loginType==\"loginByTel\"){\r\n");
      out.write("\t\t\t\t\t\tloginForm.action=\"/ShoppingMall/user/userLoginByTel.do\";\r\n");
      out.write("\t\t\t\t\t\tloginForm.submit();\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\talert(\"请选择登录方式\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}else if(roleType==\"store\"){\r\n");
      out.write("\t\t\t\t\tif(loginType==\"loginByName\"){\r\n");
      out.write("\t\t\t\t\t\tloginForm.action=\"/ShoppingMall/store/storeLoginByName.do\";\r\n");
      out.write("\t\t\t\t\t\tloginForm.submit();\r\n");
      out.write("\t\t\t\t\t}else if(loginType==\"loginByTel\"){\r\n");
      out.write("\t\t\t\t\t\tloginForm.action=\"/ShoppingMall/store/storeLoginByTel.do\";\r\n");
      out.write("\t\t\t\t\t\tloginForm.submit();\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\talert(\"请选择登录方式\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\tif(loginType==\"loginByName\"){\r\n");
      out.write("\t\t\t\t\t\tloginForm.action=\"/ShoppingMall/admin/adminLoginByName.do\";\r\n");
      out.write("\t\t\t\t\t\tloginForm.submit();\r\n");
      out.write("\t\t\t\t\t}else if(loginType==\"loginByTel\"){\r\n");
      out.write("\t\t\t\t\t\tloginForm.action=\"/ShoppingMall/admin/adminLoginByTel.do\";\r\n");
      out.write("\t\t\t\t\t\tloginForm.submit();\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\talert(\"请选择登录方式\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<div style=\"text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';\">\r\n");
      out.write("<p>诚邀优秀商家前来开店，欢迎文明顾客前来购物。</p>\r\n");
      out.write("<p>Copyright &copy; 2017hds</p>\r\n");
      out.write("</div>\r\n");
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
