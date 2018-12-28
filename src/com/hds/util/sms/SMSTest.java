package com.hds.util.sms;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
/**
 * 通过此方法将验证码和用户名传入方法向手机号发送验证码进行注册
 * @author 离
 *
 */
public class SMSTest {
	public static int sendSMS(int yzm,String roleName,String roleTel) throws Exception {
		
		HttpClient client = new HttpClient();
		//要请求的短信接口的url
		PostMethod post = new PostMethod("http://api.sms.cn/sms/?ac=send");
		//添加请求头
		post.addRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=UTF-8");// 在头文件中设置转码
		//装载数据，将短信接口中的用户名、密码、以及要使用的模板添加进数组，将传入的参数也一起添加进数组中
		NameValuePair[] data = { new NameValuePair("uid", "me80185016"),
				new NameValuePair("pwd", "d3ac5e4f5b997d60add0f5363bde547a"),
				new NameValuePair("template", "406580"),
				new NameValuePair("mobile", roleTel),
				//{"name":name,"code":code}
				new NameValuePair("content","{\"name\":"+"\""+roleName+"\""+",\"code\":"+"\""+yzm+"\""+"}")};
 				//new NameValuePair("code","123")};
		//添加请求体
		post.setRequestBody(data);
		//执行方法，调用接口发送短信
		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:" + statusCode);
		for (Header h : headers) {
			System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes(
				"gbk"));
		System.out.println(result);

		post.releaseConnection();
		
		return yzm;

	}

}
