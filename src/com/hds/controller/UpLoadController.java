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
 * 用于文件上传的controller
 * @author 离
 *
 */
@Controller
@RequestMapping("/upload")
public class UpLoadController {
	
	/**
	 * 上传普通用户头像
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/uploadUserHead")
	public void upLoadUserHead(MultipartFile userHeadImage,HttpServletRequest request,HttpServletResponse response) throws Exception{
		//System.out.println("调用ajax后台方法");
		try {
			// 获取图片原始文件名
			String originalFilename = userHeadImage.getOriginalFilename();
			//System.out.println(originalFilename);
			// 文件名使用当前时间
			String name = new SimpleDateFormat("yyyyMMddHHmmssSSS")
					.format(new Date());
			// 获取上传图片的扩展名(jpg/png/...)
			String extension = FilenameUtils.getExtension(originalFilename);
			// 图片上传的相对路径（因为相对路径放到页面上就可以显示图片）
			String path = "upload/userHead/" + name + "." + extension;
			// 图片上传的绝对路径
			String url = request.getSession().getServletContext()
					.getRealPath("/")
					+ path;
			File dir = new File(url);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// 上传图片
			userHeadImage.transferTo(new File(url));
			// 将相对路径写回（json格式）
			JSONObject jsonObject = new JSONObject();
			// 将图片上传到本地
			jsonObject.put("path", path);
			// 设置响应数据的类型json
			response.setContentType("application/json; charset=utf-8");
			// 写回
			response.getWriter().write(jsonObject.toString());
			//System.out.println(jsonObject.toString());
		} catch (Exception e) {
			throw new RuntimeException("服务器繁忙，上传图片失败");
		}
	}
	/**
	 * 上传店铺头像
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/uploadStoreHead")
	public void upLoadStoreHead(MultipartFile storeHeadImage,HttpServletRequest request,HttpServletResponse response) throws Exception{
		//System.out.println("调用ajax后台方法");
		try {
			// 获取图片原始文件名
			String originalFilename = storeHeadImage.getOriginalFilename();
			//System.out.println(originalFilename);
			// 文件名使用当前时间
			String name = new SimpleDateFormat("yyyyMMddHHmmssSSS")
					.format(new Date());
			// 获取上传图片的扩展名(jpg/png/...)
			String extension = FilenameUtils.getExtension(originalFilename);
			// 图片上传的相对路径（因为相对路径放到页面上就可以显示图片）
			String path = "upload/storeHead/" + name + "." + extension;
			// 图片上传的绝对路径
			String url = request.getSession().getServletContext()
					.getRealPath("/")
					+ path;
			File dir = new File(url);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// 上传图片
			storeHeadImage.transferTo(new File(url));
			// 将相对路径写回（json格式）
			JSONObject jsonObject = new JSONObject();
			// 将图片上传到本地
			jsonObject.put("path", path);
			// 设置响应数据的类型json
			response.setContentType("application/json; charset=utf-8");
			// 写回
			response.getWriter().write(jsonObject.toString());
			//System.out.println(jsonObject.toString());
		} catch (Exception e) {
			throw new RuntimeException("服务器繁忙，上传图片失败");
		}
	}
	/**
	 * 上传店铺营业执照图片
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/uploadStoreLicense")
	public void upLoadStoreLicense(MultipartFile storeLicenseImage,HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("调用ajax后台方法");
		try {
			// 获取图片原始文件名
			String originalFilename = storeLicenseImage.getOriginalFilename();
			//System.out.println(originalFilename);
			// 文件名使用当前时间
			String name = new SimpleDateFormat("yyyyMMddHHmmssSSS")
					.format(new Date());
			// 获取上传图片的扩展名(jpg/png/...)
			String extension = FilenameUtils.getExtension(originalFilename);
			// 图片上传的相对路径（因为相对路径放到页面上就可以显示图片）
			String path = "upload/storeLicense/" + name + "." + extension;
			// 图片上传的绝对路径
			String url = request.getSession().getServletContext()
					.getRealPath("/")
					+ path;
			File dir = new File(url);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// 上传图片
			storeLicenseImage.transferTo(new File(url));
			// 将相对路径写回（json格式）
			JSONObject jsonObject = new JSONObject();
			// 将图片上传到本地
			jsonObject.put("path", path);
			// 设置响应数据的类型json
			response.setContentType("application/json; charset=utf-8");
			// 写回
			response.getWriter().write(jsonObject.toString());
			//System.out.println(jsonObject.toString());
		} catch (Exception e) {
			throw new RuntimeException("服务器繁忙，上传图片失败");
		}
	}
	/**
	 * 上传店主手持身份证照片
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/uploadStoreMenImage")
	public void upLoadStoreMenImage(MultipartFile storeMenImage,HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("调用ajax后台方法");
		try {
			// 获取图片原始文件名
			String originalFilename = storeMenImage.getOriginalFilename();
			//System.out.println(originalFilename);
			// 文件名使用当前时间
			String name = new SimpleDateFormat("yyyyMMddHHmmssSSS")
					.format(new Date());
			// 获取上传图片的扩展名(jpg/png/...)
			String extension = FilenameUtils.getExtension(originalFilename);
			// 图片上传的相对路径（因为相对路径放到页面上就可以显示图片）
			String path = "upload/storeMenImage/" + name + "." + extension;
			// 图片上传的绝对路径
			String url = request.getSession().getServletContext()
					.getRealPath("/")
					+ path;
			File dir = new File(url);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// 上传图片
			storeMenImage.transferTo(new File(url));
			// 将相对路径写回（json格式）
			JSONObject jsonObject = new JSONObject();
			// 将图片上传到本地
			jsonObject.put("path", path);
			// 设置响应数据的类型json
			response.setContentType("application/json; charset=utf-8");
			// 写回
			response.getWriter().write(jsonObject.toString());
			//System.out.println(jsonObject.toString());
		} catch (Exception e) {
			throw new RuntimeException("服务器繁忙，上传图片失败");
		}
	}
	/**
	 * 上传店铺内部图片
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/uploadStoreImage")
	public void upLoadStoreImage(MultipartFile storeImage,HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("调用ajax后台方法");
		try {
			// 获取图片原始文件名
			String originalFilename = storeImage.getOriginalFilename();
			//System.out.println(originalFilename);
			// 文件名使用当前时间
			String name = new SimpleDateFormat("yyyyMMddHHmmssSSS")
					.format(new Date());
			// 获取上传图片的扩展名(jpg/png/...)
			String extension = FilenameUtils.getExtension(originalFilename);
			// 图片上传的相对路径（因为相对路径放到页面上就可以显示图片）
			String path = "upload/storeImage/" + name + "." + extension;
			// 图片上传的绝对路径
			String url = request.getSession().getServletContext()
					.getRealPath("/")
					+ path;
			File dir = new File(url);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// 上传图片
			storeImage.transferTo(new File(url));
			// 将相对路径写回（json格式）
			JSONObject jsonObject = new JSONObject();
			// 将图片上传到本地
			jsonObject.put("path", path);
			// 设置响应数据的类型json
			response.setContentType("application/json; charset=utf-8");
			// 写回
			response.getWriter().write(jsonObject.toString());
			//System.out.println(jsonObject.toString());
		} catch (Exception e) {
			throw new RuntimeException("服务器繁忙，上传图片失败");
		}
	}
	/**
	 * 上传商品图片
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/uploadGoodImage")
	public void upLoadGoodImage(MultipartFile goodImage,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, IllegalStateException {
		System.out.println("调用ajax后台方法");
		try {
			// 获取图片原始文件名
			String originalFilename = goodImage.getOriginalFilename();
			//System.out.println(originalFilename);
			// 文件名使用当前时间
			String name = new SimpleDateFormat("yyyyMMddHHmmssSSS")
					.format(new Date());
			// 获取上传图片的扩展名(jpg/png/...)
			String extension = FilenameUtils.getExtension(originalFilename);
			// 图片上传的相对路径（因为相对路径放到页面上就可以显示图片）
			String path = "upload/good/" + name + "." + extension;
			// 图片上传的绝对路径
			String url = request.getSession().getServletContext()
					.getRealPath("/")
					+ path;
			File dir = new File(url);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// 上传图片
			goodImage.transferTo(new File(url));
			// 将相对路径写回（json格式）
			JSONObject jsonObject = new JSONObject();
			// 将图片上传到本地
			jsonObject.put("path", path);
			// 设置响应数据的类型json
			response.setContentType("application/json; charset=utf-8");
			// 写回
			response.getWriter().write(jsonObject.toString());
			//System.out.println(jsonObject.toString());
		} catch (Exception e) {
			throw new RuntimeException("服务器繁忙，上传图片失败");
		}
	}

}
