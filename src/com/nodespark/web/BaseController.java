package com.nodespark.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.util.Assert;

/**
 * 
 * <br>
 * <b>绫绘弿杩�:</b>
 * 
 * <pre>
 * 鎵�鏈塁ontroller鐨勫熀绫�
 * </pre>
 * 
 * @see
 * @since
 */
public class BaseController {
	protected static final String ERROR_MSG_KEY = "errorMsg";

	/**
	 * 鑾峰彇淇濆瓨鍦⊿ession涓殑鐢ㄦ埛瀵硅薄
	 * 
	 * @param request
	 * @return
	 */
	
   
	/**
	 * 淇濆瓨鐢ㄦ埛瀵硅薄鍒癝ession涓�
	 * @param request
	 * @param user
	 */
	

	/**
	 * 鑾峰彇鍩轰簬搴旂敤绋嬪簭鐨剈rl缁濆璺緞
	 * 
	 * @param request
	 * @param url
	 *            浠�"/"鎵撳ご鐨刄RL鍦板潃
	 * @return 鍩轰簬搴旂敤绋嬪簭鐨剈rl缁濆璺緞
	 */
	public final String getAppbaseUrl(HttpServletRequest request, String url) {
		Assert.hasLength(url, "url涓嶈兘涓虹┖");
		Assert.isTrue(url.startsWith("/"), "蹇呴』浠�/鎵撳ご");
		return request.getContextPath() + url;
	}
	
	
}
