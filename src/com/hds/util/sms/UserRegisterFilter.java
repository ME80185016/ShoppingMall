package com.hds.util.sms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hds.mapper.UserMapper;

/**
 * �û�ע��ʱ�û���������֤
 * @author ��
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
	 * �ж��û�������û����Ƿ��ظ�
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
