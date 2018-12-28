package com.hds.util.sms;

import java.util.Random;
/**
 * 产生四位数字验证码
 * @author 离
 *
 */
public class RandomTest {
	public static int getNum(){
		Random random=new Random();
		int nextInt = random.nextInt(8999);
		nextInt+=1000;
		return nextInt;
		
	}

}
