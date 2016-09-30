package com.ecommerce.common.redis;
public interface DataItemRedisDao {

	public String read(final String uid);
	
	public void save(final String dataItem);
	
	public void delete(final String uid);
}
