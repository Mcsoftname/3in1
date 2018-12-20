package com.daoshu.resourceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.daoshu.component.fdfs.FdfsClient;
import com.daoshu.system.mapper.DictionaryMapper;
import com.daoshu.system.mapper.OrgMapper;
import com.daoshu.system.service.impl.DictionaryServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes =Application.class)
@WebAppConfiguration

public class AppTest {

    @Autowired
    private OrgMapper orgDao;
    
    @Autowired
    private AmqpTemplate  rabbitTemplate;
    
    @Autowired
    private DictionaryServiceImpl  dictionaryServiceImpl;

  /*  @Test
    public void getOrgEntityTest() {
    	System.out.println(JSONUtils.toJSONString(orgDao.getOrgEntity(1L)));
    	//System.out.println(orgDao.getAll());
    }*/
    
  /*  @Test
  //@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void insertOrgEntityTest() {
    	OrgEntity entity=new OrgEntity();
    	entity.setCode("test111");
    	entity.setName("ceshi");
    	entity.setSimpleName("cs");
    	entity.setOrgType(1);
    	entity.setOrgCategory(2);
    	orgDao.insertOrgEntity(entity);
    	System.out.println(entity.getId());
    }
    */
    @Test
    public void sendMessage() throws InterruptedException {
        String sendMsg = "hello " ;
        System.out.println("Sender1 : " + sendMsg+1);
        rabbitTemplate.convertAndSend("fanoutExchange", "", sendMsg+1);
    }
    @Autowired
    DictionaryMapper dictionaryMapper;
    
    @Test
    public void getAllDict() throws InterruptedException {
        System.out.println(dictionaryMapper.findByCondition(null));
        System.out.println(dictionaryServiceImpl.getAllDictionary());
      
    }
    @Autowired
    FdfsClient fdfsClient;
    
    @Test
    public void testUpload() throws InterruptedException {
    	//System.out.println(fdfsClient.uploadFile("test 111", "txt"));
    	System.out.println(fdfsClient.downloadFile("group1/M00/00/00/wKgAeFnbOvmAY_9fAAAACLXVH14615.txt"));
      
    }


}
