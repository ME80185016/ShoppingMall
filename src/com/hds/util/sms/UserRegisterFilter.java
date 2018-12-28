package com.hds.util.sms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hds.mapper.UserMapper;

/**
 * 用户注册时用户名输入验证
 * @author 离
 *
 */
@Service
public class UserRegisterFilter {
	private static UserMapper userMapper;
	
	public static UserMapper getUserMapper() {
		return userMapper;
	}

	public static void setUserMapper(UserMapper userMapper) {
		UserRegisterFilter.userMapper = userMapper;
	}

	/**
	 * 判断用户输入的用户名是否重复
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public static boolean userNameRepeat(String userName) throws Exception{
		boolean flag=false;
		//System.out.println(userMapper);
		List<String> queryRoleNames = userMapper.queryRoleNames();
		System.out.println(queryRoleNames);
		for(int i=0;i<queryRoleNames.size();i++){
			if(userName.equals(queryRoleNames.get(i))){
				flag=true;
				break;
			}else {
				flag=false;
			}
		}
		
		return flag;
		
	}

}
