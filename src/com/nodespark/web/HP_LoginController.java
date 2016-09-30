package com.nodespark.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.common.redis.DataItemRedisDao;
import com.ecommerce.common.redis.impl.DataItemRedisDaoImpl;
import com.google.gson.Gson;

/**
 * 
 * <br>
 * 
 * <pre>
 *   login
 *   logout
 *   set_password
 *   REST API
 * </pre>
 * 
 * @see
 * @since
 */
@Controller
@RequestMapping("HomePage")
public class HP_LoginController extends BaseController {
	// for test
	@Autowired
	private DataItemRedisDaoImpl dataItemRedisDao;  
	// 
	@RequestMapping("/get_user")
	@ResponseBody
	public String get_user(HttpServletRequest request,HttpServletResponse response) {
		dataItemRedisDao.setRedisName("1", "abc", 11);
		String a = dataItemRedisDao.getRedisName("1", 11);
		return new Gson().toJson(a);
	}
}
