package com.renruipeng.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * String 工具类
 * @author hanxiaowei
 */
public class StringUtil {

	private static Logger logger = LoggerFactory.getLogger(StringUtil.class);
	
    public static final String EMPTY_STRING = "";
    private StringUtil() {

    }

    /**字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(str == null || str.length() <= 0){
            return true;
        }else {
            return false;
        }
    }
    public static boolean isNotEmpty(String str){

        return !StringUtil.isEmpty(str);
    }

    /**字符串trim 后是否为空
     * @param str
     * @return
     */
    public static boolean isBlank(String str){
        if(str == null || str.trim().length() <= 0){
            return true;
        }else {
            return false;
        }
    }
    public static boolean isNotBlank(String str){

        return !StringUtil.isBlank(str);
    }

    /*string 转换成 long*/
    public static long toLongValue(Object obj){
    	if(obj == null){
    		return 0;
    	}
        if(obj instanceof Long){
            return (Long) obj;
        }
        String str = null;
        if(obj instanceof String){
            str = (String) obj;
        }else {
            str = String.valueOf(obj);
        }
        if(StringUtil.isBlank(str)){
            return 0;
        }else if("null".equals(str)){
        	return 0;
        }
        try{
            return Long.valueOf(str);
        }catch (Exception e){
        	logger.error(e.getMessage(),e);
        }
        return 0;
    }

    /*string 转换成 long*/
    public static int toIntValue(Object obj){
        if(obj == null){
            return 0;
        }
        if(obj instanceof Integer){
            return (Integer) obj;
        }
        String str = null;
        if(obj instanceof String){
            str = (String) obj;
        }else {
            str = String.valueOf(obj);
        }
        if(StringUtil.isBlank(str)){
            return 0;
        }else if("null".equals(str)){
        	return 0;
        }
        try{
            return Integer.valueOf(str);
        }catch (Exception e){
        	logger.error(e.getMessage(),e);
        }
        return 0;
    }
    

    /**字符串trim
     * @param str
     * @return
     */
    public static String trim(String str){
        if(str == null || str.length() <= 0){
            return StringUtil.EMPTY_STRING;
        }else {
            return str.trim();
        }
    }
    
    public static void main(String[] args) {
		
    	System.out.println(StringUtil.toLongValue("null"));
	}
    
    
	private static boolean isNotEmojiCharacter(char codePoint) {
		return (codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) || (codePoint == 0xD)
				|| ((codePoint >= 0x20) && (codePoint <= 0xD7FF)) || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
				|| ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
	}
    /**
	 * 过滤emoji 或者 其他非文字类型的字符
	 * 
	 * @param source
	 * @return
	 */
	public static String filterEmoji(String source) {
		if(StringUtil.isNotEmpty(source)){
			int len = source.length();
			StringBuilder buf = new StringBuilder(len);
			for (int i = 0; i < len; i++) {
				char codePoint = source.charAt(i);
				if (isNotEmojiCharacter(codePoint)) {
					buf.append(codePoint);
				} else {
					buf.append("");
				}
			}
			return buf.toString();
		}
		return StringUtil.EMPTY_STRING;
	}
}
