/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.76
 * Generated at: 2018-05-04 09:12:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addGood_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>店铺添加商品</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\tbody {\r\n");
      out.write("\tbackground: url(\"/ShoppingMall/img/storebg.jpg\") no-repeat;\r\n");
      out.write("\tbackground-size:cover; \r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script src=\"js/jquery-3.2.1.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.form.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//点击添加商品时触发方法，获取action，获取加密方式，并提交\r\n");
      out.write("\tfunction selAddGood() {\r\n");
      out.write("\t\tvar good_name=document.getElementById(\"good_name\").value;\r\n");
      out.write("\t\tvar price_num=document.getElementById(\"price_num\").value;\r\n");
      out.write("\t\tvar color_name=document.getElementById(\"color_name\").value;\r\n");
      out.write("\t\tvar size_name=document.getElementById(\"size_name\").value;\r\n");
      out.write("\t\tvar good_men=document.getElementById(\"good_men\").value;\r\n");
      out.write("\t\tvar good_age=document.getElementById(\"good_age\").value;\r\n");
      out.write("\t\tvar good_topOrDown=document.getElementById(\"good_topOrDown\").value;\r\n");
      out.write("\t\tvar good_season=document.getElementById(\"good_season\").value;\r\n");
      out.write("\t\tvar good_type=document.getElementById(\"good_type\").value;\r\n");
      out.write("\t\tvar good_total=document.getElementById(\"good_total\").value;\r\n");
      out.write("\t\tvar imageRoute=document.getElementById(\"imageRoute\").value;\r\n");
      out.write("\t\tif(good_name==null||good_name==\"\"){\r\n");
      out.write("\t\t\talert(\"请输入商品名\");\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\tif(price_num==null||price_num==\"\"){\r\n");
      out.write("\t\t\t\talert(\"请输入商品价格\");\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tif(color_name==null||color_name==\"\"){\r\n");
      out.write("\t\t\t\t\talert(\"请输入商品颜色\");\r\n");
      out.write("\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\tif(size_name==null||size_name==\"\"){\r\n");
      out.write("\t\t\t\t\t\talert(\"请输入商品大小\");\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\tif(good_men==null||good_men==\"\"){\r\n");
      out.write("\t\t\t\t\t\t\talert(\"请输入男女装\");\r\n");
      out.write("\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\tif(good_age==null||good_age==\"\"){\r\n");
      out.write("\t\t\t\t\t\t\t\talert(\"请输入商品适用人群\");\r\n");
      out.write("\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\tif(good_topOrDown==null||good_topOrDown==\"\"){\r\n");
      out.write("\t\t\t\t\t\t\t\t\talert(\"请输入商品上下衣\");\r\n");
      out.write("\t\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\t\tif(good_season==null||good_season==\"\"){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\talert(\"请输入商品适用季节\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tif(good_type==null||good_type==\"\"){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\talert(\"请输入商品类型\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tif(good_total==null||good_total==\"\"){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\talert(\"请输入商品总量\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tif(imageRoute==null||imageRoute==\"\"){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\talert(\"请上传商品图片\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"addGood\").enctype='application/x-www-form-urlencoded';\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"addGood\").action='/ShoppingMall/store/addGood.do';\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"addGood\").submit();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction uploadPic() {  \r\n");
      out.write("\t\t\talert(\"触发onchange方法\");\r\n");
      out.write("   \t\t\t // 上传设置  \r\n");
      out.write("    \t\tvar options = {  \r\n");
      out.write("            // 规定把请求发送到那个URL  \r\n");
      out.write("            url: \"/ShoppingMall/upload/uploadGoodImage.do\",  \r\n");
      out.write("            // 请求方式  \r\n");
      out.write("            type: \"post\",  \r\n");
      out.write("            // 服务器响应的数据类型  \r\n");
      out.write("            dataType: \"json\",  \r\n");
      out.write("            // 请求成功时执行的回调函数  \r\n");
      out.write("            success: function(data, status, xhr) {  \r\n");
      out.write("                // 图片显示地址  \r\n");
      out.write("                $(\"#defaultImage\").attr(\"src\",data.path); \r\n");
      out.write("                $(\"#imageRoute\").attr(\"value\",data.path);\r\n");
      out.write("                alert(data.path);\r\n");
      out.write("            }  \r\n");
      out.write("    };  \r\n");
      out.write("      \r\n");
      out.write("    $(\"#uploadAction\").ajaxSubmit(options);  \r\n");
      out.write("}  \r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div style=\"margin-left: 30px; margin-top: 30px\">\r\n");
      out.write("\t\t<form action=\"\" method=\"post\" enctype=\"\" id=\"addGood\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<h3>添加商品</h3>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t商品名：<input name=\"good.good_name\" id=\"good_name\">\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t商品价格：<input name=\"goodPrice.price_num\" id=\"price_num\">\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t商品颜色：<input name=\"goodProperties.color_name\" id=\"color_name\">\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t商品大小：\t<input name=\"goodProperties.size_name\" id=\"size_name\">\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t男女装：<input name=\"goodProperties.good_men\" id=\"good_men\">\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t适用人群：<input name=\"goodProperties.good_age\" id=\"good_age\">\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t上下衣：<input name=\"goodProperties.good_topOrDown\" id=\"good_topOrDown\">\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t季节：<input name=\"goodProperties.good_season\" id=\"good_season\">\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t类型：<input name=\"goodProperties.good_type\" id=\"good_type\">\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t总量：<input name=\"goodProperties.good_total\" id=\"good_total\">\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t<input id=\"imageRoute\" type=\"text\" value=\"\" name=\"imageRoute\" style=\"width: 400px\" hidden=\"hidden\">\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"添加商品\" onclick=\"selAddGood()\">\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<div style=\"position: absolute; top: 85px; left: 300px;\">\r\n");
      out.write("\t\t\t<form action=\"\" method=\"post\" enctype=\"multipart/form-data\" id=\"uploadAction\">\r\n");
      out.write("\t\t\t\t<input id=\"changeImage\" type=\"file\" onchange=\"uploadPic()\" name=\"goodImage\"\r\n");
      out.write("\t\t\t\t\tstyle=\"position: absolute; float: left; z-index: 10; opacity: 0; width: 100px; height: 100px;\">\r\n");
      out.write("\t\t\t\t<img id=\"defaultImage\" src=\"/ShoppingMall/upload/defaultHead.png\" title=\"商品图片\"\r\n");
      out.write("\t\t\t\t\tstyle=\"position: absolute; z-index: 9; float: left; width: 100px; height: 100px\"><br>\r\n");
      out.write("\t\t\t\t\t商品图片\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
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
