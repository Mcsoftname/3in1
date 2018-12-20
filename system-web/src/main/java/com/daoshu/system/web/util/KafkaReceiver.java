package com.daoshu.system.web.util;

import com.alibaba.fastjson.JSONObject;
import com.daoshu.system.mapper.alarm.SjdMapper;
import com.daoshu.system.qo.KafkaResponse;
import com.daoshu.system.qo.Sjd;
import com.daoshu.system.util.MessageUtils;
import com.daoshu.system.vo.SjdVO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
@Component
public class KafkaReceiver {



    /** 静态变量：系统日志 */
    private static final Log logger = LogFactory.getLog(KafkaReceiver.class);
    @Value("${spring.kafka.consumer.topic}")
    public String topic;
    @Autowired
    private SjdMapper sjdMapper;
    @Autowired
    MessageUtils messageUtils;
/*
    @Autowired
    private SimpMessagingTemplate template;
*/

    @KafkaListener(topics = {"${spring.kafka.consumer.topic}"})
    public void listen(ConsumerRecord<?, ?> record) {

        System.out.println("===record===="+record);
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
/*        System.out.println("===kafkaMessage===="+kafkaMessage);
        System.out.println("===kafkaMessage.isPresent()===="+kafkaMessage.isPresent());*/
        if (kafkaMessage.isPresent()) {

            String message = (String) kafkaMessage.get();
            JSONObject json = JSONObject.parseObject(message);

            KafkaResponse kafkaResponse = JSONObject.parseObject(json.toString(),KafkaResponse.class);

            //System.out.println("----------------- record =" + record);
            //System.out.println("----------------------------- message =" + message);
            //JSONObject jsonObject = (JSONObject) JSONObject.toJSON(message);
            //Sjd sjd = JSON.parseObject(jsonObject.toString(),Sjd.class);
            Sjd sjd = JSONObject.parseObject(kafkaResponse.getData().toString(),Sjd.class);
            String sjdbh = sjd.getSjdbh();
            sjdMapper.insert(sjd);
            System.out.println("======="+sjdbh);
            SjdVO sjdVo = new SjdVO(sjd);
            messageUtils.sendNewFeedbackMsgToPerson("1","新警情",JSONObject.toJSON(sjdVo).toString());
            //template.convertAndSendToUser("1", "/msg", kafkaResponse.getData().toString());
            logger.info("用户" + "1" + "发送消息内容[" + JSONObject.toJSON(sjdVo).toString() + "]到用户1");

        }

    }

}