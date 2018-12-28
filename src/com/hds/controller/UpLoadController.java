package com.hds.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
/**
 * �����ļ��ϴ���controller
 * @author ��
 *
 */
@Controller
@RequestMapping("/upload")
public class UpLoadController {
	
	/**
	 * �ϴ���ͨ�û�ͷ��
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/uploadUserHead")
	public void upLoadUserHead(MultipartFile userHeadImage,HttpServletRequest request,HttpServletResponse response) throws Exception{
		//System.out.println("����ajax��̨����");
		try {
			// ��ȡͼƬԭʼ�ļ���
			String originalFilename = userHeadImage.getOriginalFilename();
			//System.out.println(originalFilename);
			// �ļ���ʹ�õ�ǰʱ��
			String name = new SimpleDateFormat("yyyyMMddHHmmssSSS")
					.format(new Date());
			// ��ȡ�ϴ�ͼƬ����չ��(jpg/png/...)
			String extension = FilenameUtils.getExtension(originalFilename);
			// ͼƬ�ϴ������·������Ϊ���·���ŵ�ҳ���ϾͿ�����ʾͼƬ��
			String path = "upload/userHead/" + name + "." + extension;
			// ͼƬ�ϴ��ľ���·��
			String url = request.getSession().getServletContext()
					.getRealPath("/")
					+ path;
			File dir = new File(url);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// �ϴ�ͼƬ
			userHeadImage.transferTo(new File(url));
			// �����·��д�أ�json��ʽ��
			JSONObject jsonObject = new JSONObject();
			// ��ͼƬ�ϴ�������
			jsonObject.put("path", path);
			// ������Ӧ���ݵ�����json
			response.setContentType("application/json; charset=utf-8");
			// д��
			response.getWriter().write(jsonObject.toString());
			//System.out.println(jsonObject.toString());
		} catch (Exception e) {
			throw new RuntimeException("��������æ���ϴ�ͼƬʧ��");
		}
	}
	/**
	 * �ϴ�����ͷ��
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/uploadStoreHead")
	public void upLoadStoreHead(MultipartFile storeHeadImage,HttpServletRequest request,HttpServletResponse response) throws Exception{
		//System.out.println("����ajax��̨����");
		try {
			// ��ȡͼƬԭʼ�ļ���
			String originalFilename = storeHeadImage.getOriginalFilename();
			//System.out.println(originalFilename);
			// �ļ���ʹ�õ�ǰʱ��
			String name = new SimpleDateFormat("yyyyMMddHHmmssSSS")
					.format(new Date());
			// ��ȡ�ϴ�ͼƬ����չ��(jpg/png/...)
			String extension = FilenameUtils.getExtension(originalFilename);
			// ͼƬ�ϴ������·������Ϊ���·���ŵ�ҳ���ϾͿ�����ʾͼƬ��
			String path = "upload/storeHead/" + name + "." + extension;
			// ͼƬ�ϴ��ľ���·��
			String url = request.getSession().getServletContext()
					.getRealPath("/")
					+ path;
			File dir = new File(url);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// �ϴ�ͼƬ
			storeHeadImage.transferTo(new File(url));
			// �����·��д�أ�json��ʽ��
			JSONObject jsonObject = new JSONObject();
			// ��ͼƬ�ϴ�������
			jsonObject.put("path", path);
			// ������Ӧ���ݵ�����json
			response.setContentType("application/json; charset=utf-8");
			// д��
			response.getWriter().write(jsonObject.toString());
			//System.out.println(jsonObject.toString());
		} catch (Exception e) {
			throw new RuntimeException("��������æ���ϴ�ͼƬʧ��");
		}
	}
	/**
	 * �ϴ�����Ӫҵִ��ͼƬ
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/uploadStoreLicense")
	public void upLoadStoreLicense(MultipartFile storeLicenseImage,HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("����ajax��̨����");
		try {
			// ��ȡͼƬԭʼ�ļ���
			String originalFilename = storeLicenseImage.getOriginalFilename();
			//System.out.println(originalFilename);
			// �ļ���ʹ�õ�ǰʱ��
			String name = new SimpleDateFormat("yyyyMMddHHmmssSSS")
					.format(new Date());
			// ��ȡ�ϴ�ͼƬ����չ��(jpg/png/...)
			String extension = FilenameUtils.getExtension(originalFilename);
			// ͼƬ�ϴ������·������Ϊ���·���ŵ�ҳ���ϾͿ�����ʾͼƬ��
			String path = "upload/storeLicense/" + name + "." + extension;
			// ͼƬ�ϴ��ľ���·��
			String url = request.getSession().getServletContext()
					.getRealPath("/")
					+ path;
			File dir = new File(url);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// �ϴ�ͼƬ
			storeLicenseImage.transferTo(new File(url));
			// �����·��д�أ�json��ʽ��
			JSONObject jsonObject = new JSONObject();
			// ��ͼƬ�ϴ�������
			jsonObject.put("path", path);
			// ������Ӧ���ݵ�����json
			response.setContentType("application/json; charset=utf-8");
			// д��
			response.getWriter().write(jsonObject.toString());
			//System.out.println(jsonObject.toString());
		} catch (Exception e) {
			throw new RuntimeException("��������æ���ϴ�ͼƬʧ��");
		}
	}
	/**
	 * �ϴ������ֳ����֤��Ƭ
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/uploadStoreMenImage")
	public void upLoadStoreMenImage(MultipartFile storeMenImage,HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("����ajax��̨����");
		try {
			// ��ȡͼƬԭʼ�ļ���
			String originalFilename = storeMenImage.getOriginalFilename();
			//System.out.println(originalFilename);
			// �ļ���ʹ�õ�ǰʱ��
			String name = new SimpleDateFormat("yyyyMMddHHmmssSSS")
					.format(new Date());
			// ��ȡ�ϴ�ͼƬ����չ��(jpg/png/...)
			String extension = FilenameUtils.getExtension(originalFilename);
			// ͼƬ�ϴ������·������Ϊ���·���ŵ�ҳ���ϾͿ�����ʾͼƬ��
			String path = "upload/storeMenImage/" + name + "." + extension;
			// ͼƬ�ϴ��ľ���·��
			String url = request.getSession().getServletContext()
					.getRealPath("/")
					+ path;
			File dir = new File(url);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// �ϴ�ͼƬ
			storeMenImage.transferTo(new File(url));
			// �����·��д�أ�json��ʽ��
			JSONObject jsonObject = new JSONObject();
			// ��ͼƬ�ϴ�������
			jsonObject.put("path", path);
			// ������Ӧ���ݵ�����json
			response.setContentType("application/json; charset=utf-8");
			// д��
			response.getWriter().write(jsonObject.toString());
			//System.out.println(jsonObject.toString());
		} catch (Exception e) {
			throw new RuntimeException("��������æ���ϴ�ͼƬʧ��");
		}
	}
	/**
	 * �ϴ������ڲ�ͼƬ
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/uploadStoreImage")
	public void upLoadStoreImage(MultipartFile storeImage,HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("����ajax��̨����");
		try {
			// ��ȡͼƬԭʼ�ļ���
			String originalFilename = storeImage.getOriginalFilename();
			//System.out.println(originalFilename);
			// �ļ���ʹ�õ�ǰʱ��
			String name = new SimpleDateFormat("yyyyMMddHHmmssSSS")
					.format(new Date());
			// ��ȡ�ϴ�ͼƬ����չ��(jpg/png/...)
			String extension = FilenameUtils.getExtension(originalFilename);
			// ͼƬ�ϴ������·������Ϊ���·���ŵ�ҳ���ϾͿ�����ʾͼƬ��
			String path = "upload/storeImage/" + name + "." + extension;
			// ͼƬ�ϴ��ľ���·��
			String url = request.getSession().getServletContext()
					.getRealPath("/")
					+ path;
			File dir = new File(url);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// �ϴ�ͼƬ
			storeImage.transferTo(new File(url));
			// �����·��д�أ�json��ʽ��
			JSONObject jsonObject = new JSONObject();
			// ��ͼƬ�ϴ�������
			jsonObject.put("path", path);
			// ������Ӧ���ݵ�����json
			response.setContentType("application/json; charset=utf-8");
			// д��
			response.getWriter().write(jsonObject.toString());
			//System.out.println(jsonObject.toString());
		} catch (Exception e) {
			throw new RuntimeException("��������æ���ϴ�ͼƬʧ��");
		}
	}
	/**
	 * �ϴ���ƷͼƬ
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/uploadGoodImage")
	public void upLoadGoodImage(MultipartFile goodImage,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, IllegalStateException {
		System.out.println("����ajax��̨����");
		try {
			// ��ȡͼƬԭʼ�ļ���
			String originalFilename = goodImage.getOriginalFilename();
			//System.out.println(originalFilename);
			// �ļ���ʹ�õ�ǰʱ��
			String name = new SimpleDateFormat("yyyyMMddHHmmssSSS")
					.format(new Date());
			// ��ȡ�ϴ�ͼƬ����չ��(jpg/png/...)
			String extension = FilenameUtils.getExtension(originalFilename);
			// ͼƬ�ϴ������·������Ϊ���·���ŵ�ҳ���ϾͿ�����ʾͼƬ��
			String path = "upload/good/" + name + "." + extension;
			// ͼƬ�ϴ��ľ���·��
			String url = request.getSession().getServletContext()
					.getRealPath("/")
					+ path;
			File dir = new File(url);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// �ϴ�ͼƬ
			goodImage.transferTo(new File(url));
			// �����·��д�أ�json��ʽ��
			JSONObject jsonObject = new JSONObject();
			// ��ͼƬ�ϴ�������
			jsonObject.put("path", path);
			// ������Ӧ���ݵ�����json
			response.setContentType("application/json; charset=utf-8");
			// д��
			response.getWriter().write(jsonObject.toString());
			//System.out.println(jsonObject.toString());
		} catch (Exception e) {
			throw new RuntimeException("��������æ���ϴ�ͼƬʧ��");
		}
	}

}
