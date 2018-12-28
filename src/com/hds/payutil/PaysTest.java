package com.hds.payutil;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
/**
 * ͨ���˷�������֧���ӿ�
 * @author ��
 *
 */
public class PaysTest {
	public static String BASE_URL = "https://pay.paysapi.com";

	public static String sendPays(int orderid,int orderuid,String goodsname,int istype,Double price) throws Exception {
		org.apache.commons.httpclient.HttpClient client=new org.apache.commons.httpclient.HttpClient();
		//Ҫ����Ķ��Žӿڵ�url
		PostMethod post = new PostMethod(BASE_URL);
		//�������ͷ
		post.addRequestHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=UTF-8");// ��ͷ�ļ�������ת��
		String Stringvalue = String.valueOf(price);
		Map<String, Object> remoteMap=new HashMap<String,Object>();
		remoteMap.put("orderuid", orderuid);
		remoteMap.put("orderid", orderid);
		remoteMap.put("goodsname", goodsname);
		remoteMap.put("istype", istype);
		remoteMap.put("price", Stringvalue);
		Map<String, Object> payOrder = PayUtil.payOrder(remoteMap);
		//װ�����ݣ������Žӿ��е��û��������롢�Լ�Ҫʹ�õ�ģ����ӽ����飬������Ĳ���Ҳһ����ӽ�������
		NameValuePair[] data = { new NameValuePair("uid", (String)payOrder.get("uid")),
				new NameValuePair("key", (String)payOrder.get("key")),
				new NameValuePair("notify_url", (String)payOrder.get("notify_url")),
				new NameValuePair("return_url", (String)payOrder.get("return_url")),
				new NameValuePair("orderuid", String.valueOf(payOrder.get("orderuid"))),
				new NameValuePair("orderid", String.valueOf(payOrder.get("orderid"))),
				new NameValuePair("goodsname", String.valueOf(payOrder.get("goodsname"))),
				new NameValuePair("istype", String.valueOf(payOrder.get("istype"))),
				new NameValuePair("price", String.valueOf(payOrder.get("price")))};
		//���������
		post.setRequestBody(data);
		//ִ�з���������֧���ӿ�
		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		//System.out.println("data:"+data);
		String result = new String(post.getResponseBodyAsString().getBytes(
				"gbk"));
		//System.out.println(result);

		post.releaseConnection();
		
		return result;
		/*String content_type="text/json";
		HttpClient client=new DefaultHttpClient();
		HttpPost post=new HttpPost(BASE_URL);
		String Doublevalue = String.valueOf(price);
		post.setHeader("Content-type", "application/json;charset=UTF-8");
		Map<String, Object> remoteMap=new HashMap<String,Object>();
		remoteMap.put("orderuid", orderuid);
		remoteMap.put("orderid", orderid);
		remoteMap.put("goodsname", goodsname);
		remoteMap.put("istype", istype);
		remoteMap.put("price", Doublevalue);
		Map<String, Object> payOrder = PayUtil.payOrder(remoteMap);
		
		Map<String, Object> payOrder = PayUtil.payOrder(orderid, orderuid, goodsname, istype, price);
		String key = PayUtil.getKey(payOrder);
		Map<String, Object> paramMap=new HashMap<String, Object>();
		paramMap.put("uid", payOrder.get("uid"));
		paramMap.put("key", payOrder.get("key"));
		paramMap.put("notify_url", payOrder.get("notify_url"));
		paramMap.put("return_url", payOrder.get("return_url"));
		paramMap.put("orderuid", payOrder.get("orderuid"));
		paramMap.put("orderid", payOrder.get("orderid"));
		paramMap.put("goodsname", payOrder.get("goodsname"));
		paramMap.put("istype", payOrder.get("istype"));
		paramMap.put("price", payOrder.get("price"));
		//תΪjson����
		JSONObject fromObject = JSONObject.fromObject(paramMap);
		//
		String data = fromObject.toString();
		System.out.println("data:"+data);
		StringEntity entity=new StringEntity(data);
		entity.setContentType(content_type);
		post.setEntity(entity);
		HttpResponse response=client.execute(post);
		HttpEntity resultEntity = response.getEntity();
		String result = EntityUtils.toString(resultEntity, "UTF-8");
		//System.out.println("util����id��"+payOrder.get("orderid")+",��ɫid:"+payOrder.get("orderuid")+",��Ʒ���ƣ�"+payOrder.get("goodsname")+",֧�����ͣ�"+payOrder.get("istype")+",֧����"+payOrder.get("price")+",uid:"+payOrder.get("uid")+",notify:"+payOrder.get("notify_url")+",return:"+payOrder.get("return_url")+",key:"+payOrder.get("key"));
		return result;*/
	}

}
