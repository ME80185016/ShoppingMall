package com.hds.util.sms;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
/**
 * ͨ���˷�������֤����û������뷽�����ֻ��ŷ�����֤�����ע��
 * @author ��
 *
 */
public class SMSTest {
	public static int sendSMS(int yzm,String roleName,String roleTel) throws Exception {
		
		HttpClient client = new HttpClient();
		//Ҫ����Ķ��Žӿڵ�url
		PostMethod post = new PostMethod("http://api.sms.cn/sms/?ac=send");
		//�������ͷ
		post.addRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=UTF-8");// ��ͷ�ļ�������ת��
		//װ�����ݣ������Žӿ��е��û��������롢�Լ�Ҫʹ�õ�ģ����ӽ����飬������Ĳ���Ҳһ����ӽ�������
		NameValuePair[] data = { new NameValuePair("uid", "me80185016"),
				new NameValuePair("pwd", "d3ac5e4f5b997d60add0f5363bde547a"),
				new NameValuePair("template", "406580"),
				new NameValuePair("mobile", roleTel),
				//{"name":name,"code":code}
				new NameValuePair("content","{\"name\":"+"\""+roleName+"\""+",\"code\":"+"\""+yzm+"\""+"}")};
 				//new NameValuePair("code","123")};
		//���������
		post.setRequestBody(data);
		//ִ�з��������ýӿڷ��Ͷ���
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
