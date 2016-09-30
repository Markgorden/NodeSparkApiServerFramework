package com.ecommerce.common.redis.impl;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import com.ecommerce.common.redis.DataItemRedisDao;


@Repository
public class DataItemRedisDaoImpl implements DataItemRedisDao {
	
	@Resource
	private RedisTemplate<Serializable, Serializable> redisTemplate;
	
	public RedisTemplate<Serializable, Serializable> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(
			RedisTemplate<Serializable, Serializable> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

//
	
	
	//public void setRedisTemplate(StringRedisTemplate redisTemplate) {
	//	this.redisTemplate = redisTemplate;
	//}
	
	public void setRedisName(String key, String value, int min_time) {
		redisTemplate.opsForValue().set(key, value);
		//设置超时
		redisTemplate.expire(key, min_time, TimeUnit.MINUTES);
	}
  
	public String getRedisName(String key, int min_time) {
		//设置超时
		redisTemplate.expire(key, min_time, TimeUnit.MINUTES);
		return (String) redisTemplate.opsForValue().get(key);
	}

	public void delete_ex(String key) {
		redisTemplate.delete(key);
	}
	
	//
	
	@Override
	public String read(final String uid) {
	    return redisTemplate.execute(new RedisCallback<String>() {  
	        @Override  
	        public String doInRedis(RedisConnection connection)  
	                throws DataAccessException {  
	            byte[] key = redisTemplate.getStringSerializer().serialize(  
	                    "dataitem.uid." + uid);  
	            if (connection.exists(key)) {  
	                byte[] value = connection.get(key);  
	                String dataValue = redisTemplate.getStringSerializer()  
	                        .deserialize(value);  
	                String dataItem = new String();  
	               // dataItem.setValue(dataValue);
	              //  dataItem.setId(uid);
	                return dataItem;  
	            }  
	            return null;  
	        }  
	    }); 
	}

	@Override
	public void save(final String dataItem) {
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.set(
						redisTemplate.getStringSerializer().serialize(
								"dataitem.uid." + ""),
						redisTemplate.getStringSerializer().serialize(
								""));
				return null;
			}
		});
	}

	@Override
	public void delete(final String uid) {
		redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection) {
				connection.del(redisTemplate.getStringSerializer().serialize(
						"dataitem.uid." + uid));
				return null;
			}
		});
	}

}
