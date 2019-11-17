package com.bwie.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/***
 * 
 * @author 孙泽龙
 *
 * 2019年11月8日
 */
public class StringUtils {
	/**
	 * 
	* @Title: isBlank  
	* 判断是否为空
	* @param @param str
	* @param @return     
	* @return boolean    
	* @throws
	 */
	public static boolean isBlank(String str) {
		return (str==null || str.trim().equals(""));
	}
	/**
	 * 
	* @Title: haveValue  
	* 判断是否有值
	* @param @param str
	* @param @return     
	* @return boolean    
	* @throws
	 */
	public static boolean haveValue(String str) {
		return !(str==null || str.trim().equals(""));
	}
	/**
	 * 
	* @Title: isMobile  
	* 判断手机号  
	* @param @param str
	* @param @return     
	* @return boolean    
	* @throws
	 */
	public static boolean isMobile(String str) {
		String regex="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		return m.find();
	}
	/***
	 * 
	* @Title: isMobile  
	* @Description: 判断是否是数字
	* @param @param str
	* @param @return     
	* @return boolean    
	* @throws
	 */
	
	public static boolean isNumber(Integer i) {
		
		try {
			if (i>0||i<0||i==0) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				return false;
		}
		return false;
		
	}
	/***
	 * 
	 * @Title: isEnglish  
	 * @Description: 判断是否全为字母
	 * @param @param str
	 * @param @return     
	 * @return boolean    
	 * @throws
	 */
	@Test
	public static boolean isEnglish(String i) {
		String regex = "[a-zA-Z]?";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(i);
		
		
		return m.find();
		
		
		
	}
	/**
	 * 
	* @Title: isEmail  
	* 验证邮箱 
	* @param @param str
	* @param @return     
	* @return boolean    
	* @throws
	 */
	public static boolean isEmail(String str) {
		String regex="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		return m.find();
	}
	/**
	 * 
	* @Title: getRandomStr  
	* 获取n位随机英文字符串 
	* @param @param n
	* @param @return     
	* @return String    
	* @throws
	 */
	public static String getRandomStr(int n) {
		StringBuilder sb=new StringBuilder();
		
		Random random=new Random();
		
		for (int i = 0; i < n; i++) {
			sb.append((char)('A'+random.nextInt(26)));
		}
		return sb.toString();
	}
	/**
	 * 
	* @Title: getRandomStr2  
	* 获取n位随机英文和数字字符串  
	* @param @param n
	* @param @return     
	* @return String    
	* @throws
	 */
	public static String getRandomStr2(int n) {
		StringBuilder sb=new StringBuilder();
		
		Random random=new Random();
		
		for (int i = 0; i < n; i++) {
			int r=random.nextInt(26);
			if (r<26) {
				char c=(char)('A'+r);
				sb.append(c);
			}else {
				sb.append(r-26);
			}
		}
		return sb.toString();
	}
	/**
	 * 
	* @Title: getRandomCn  
	* 获取随机中文  
	* @param @param n
	* @param @return     
	* @return char    
	* @throws
	 */
	public static char getRandomCn(int n) {
		String str = "";
        int hightPos; 
        int lowPos;
        Random random = new Random();


        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));


        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();


        try {
            str = new String(b, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("错误");
        }


        	return str.charAt(0);


	}
	/**
	 * 
	* @Title: getRandomCnn  
	* 随机获取汉字字符串  
	* @param @param n
	* @param @return     
	* @return String    
	* @throws
	 */
	public static String getRandomCnn(int n) {
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(StringUtils.getRandomCn(n));
		}


        return sb.toString();


	}
	static Random rnd = new Random();
	public static String getRandomNumber(int digCount) {
	    StringBuilder sb = new StringBuilder(digCount);
	    for(int i=0; i < digCount; i++)
	        sb.append((char)('0' + rnd.nextInt(10)));
	    return sb.toString();
	}  
}
