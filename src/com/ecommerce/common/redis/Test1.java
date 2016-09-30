package com.ecommerce.common.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test1 {
	private ApplicationContext app;
    private DataItemRedisDao dataItemRedisDao;  
  
   // @Before  
    public void before() throws Exception {  
        app = new FileSystemXmlApplicationContext("WebRoot/WEB-INF/config/spring/context-redis.xml");  
        dataItemRedisDao = (DataItemRedisDao) app.getBean("dataItemRedisDao");  
    }
    
   // @Test
    public void crud() {
        // -------------- Create ---------------  
        String uid = "u123456";  
        String value1 = "上海";  
        //String dataItem = new DataItem();  
       // dataItem.setId(uid);  
        //dataItem.setValue(value1);
        //dataItemRedisDao.save(dataItem);
  
        // ---------------Read ---------------  
       // dataItem = dataItemRedisDao.read(uid);  
  
       // assertEquals(value1, dataItem.getValue());  
  
        // --------------Update ------------  
        String value2 = "北京";  
        //dataItem.setValue(value2);
       // dataItemRedisDao.save(dataItem);  
  
        //dataItem = dataItemRedisDao.read(uid);  
  
        //assertEquals(value2, dataItem.getValue());  
  
        // --------------Delete ------------  
        dataItemRedisDao.delete(uid);  
       // dataItem = dataItemRedisDao.read(uid);  
       // assertNull(dataItem);  
    }  
}  
