package com.hds.util.sms;

import java.util.Random;
/**
 * ������λ������֤��
 * @author ��
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
