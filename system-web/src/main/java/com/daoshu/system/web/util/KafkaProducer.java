
package com.daoshu.system.web.util;

import com.alibaba.fastjson.JSONObject;
import com.daoshu.system.qo.KafkaResponse;
import com.daoshu.system.qo.Sjd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;


/**
 * @Description TODO
 * @Author songlj
 * @Date 2018/12/1 13:56
 **/

@Component
@EnableScheduling
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${spring.kafka.consumer.topic}")
    public String topic;

/**
     * 定时任务
     */

    @Scheduled(cron = "0 */1 * * * ?")
    public void send(){


        //模拟发送事件单
        Sjd sjd = new Sjd();

        sjd.setSjdbh("20180523183458655111");   //事件单编号
        sjd.setXzqh("31000");;             //行政区划
        sjd.setJjdwbh("310000000000"); //接警单位编号
        sjd.setSfdz("事发地址");     //事发地址
        sjd.setDwbzw("定位坐标");     //定位标志位
        sjd.setXzb("121.4446");              //x坐标
        sjd.setYzb("31.18731");       //y坐标
        sjd.setScbjsj("2018-06-23 14:00:32");      //首次报警时间
        sjd.setBjr("刘录,身份证:430204197609063019");            //报警人
        sjd.setLxdh("18621929560");      //联系电话
        sjd.setLxdz("上海市普陀区真北路红星美凯龙");     //联系地址
        sjd.setSsfj("310104000000");     //所属分局
        sjd.setXadw("");   //辖区单位
        sjd.setJz("1");      //警种
        sjd.setCllx("01");    //处理类型
        sjd.setJqjb("01");      //警情级别
        sjd.setAy("249");         //案由
        sjd.setGlsjdbh("");    //关联事件单号
        sjd.setSjxq("2辆轿车相撞，无人伤，已撤离，请民警到场处理。");      //事件详情
        sjd.setCjdw("");     //出警单位
        sjd.setCljg("");       //处理结果
        sjd.setSjclqk("");    //事件处理情况
        sjd.setSjzt("90");       //事件状态
        sjd.setScsljssj("2018-06-22 14:09:41");   //首次受理结束时间
        sjd.setBjrxb("1");     //报警人性别
        sjd.setSfdzfl("");    //事发地址分类
        sjd.setScsldbh("20180622140941170212");    //首次受理单编号
        sjd.setSfnm("0");    //是否匿名
        sjd.setJjygh("001957");    //接警员工号
        sjd.setJjyxm("石文耀(22567)");    //接警员姓名
        sjd.setYywj("");     //语音文件
        sjd.setSjc("2018-06-22 14:12:36");     //时间戳
        sjd.setJjybh("");     //接警员编号
        sjd.setScbjfs("01");      //首次报警方式
        sjd.setScjjth("0");      //首次接警台号
        sjd.setScjjdw("");      //首次接警单位
        sjd.setScjjtip("");     //首次接警台ip
        sjd.setScslsj("2018-06-22 14:09:41");    //首次受理时间
        sjd.setSfsj("2018-06-22 14:09:41");     //事发时间
        sjd.setScczkssj("2018-06-22 14:09:41");                //首次处置开始时间
        sjd.setSczlxdsj("");               //首次指令下达时间
        sjd.setScpjdw("310000000000");               //首次派警单位
        sjd.setSpcjdw("");         //首批出警单位
        sjd.setSccjcs("");         //首次派警意见
        sjd.setSccjdbh("");         //首次派警单编号
        sjd.setLjpjqk("");            //有无爆炸泄露
        sjd.setScfkr("");               //首次反馈人
        sjd.setScfkdw("");               //首次反馈单位
        sjd.setScfksj("");         //首次反馈时间
        sjd.setScfknr("");         //首次反馈内容
        sjd.setScfkdbh("");        //首次反馈单编号
        sjd.setLjfknr("");        //累计反馈情况
        sjd.setSffkzj("0");        //是否反馈终结
        sjd.setYwwxwz("0");       //有无危险物质
        sjd.setYwbzxl("0");            //有无爆炸泄露
        sjd.setBkryqksm("");            //被困人员情况说明
        sjd.setSsryqksm("");         //受伤人员情况说明
        sjd.setSwryqksm("");         //伤亡人员情况说明
        sjd.setZjhm("15021867732");         //报警号码
        sjd.setJqlbdm("247");        //警情类别代码
        sjd.setJqlxdm("223");        //警情类型代码
        sjd.setJqxldm("");       //警情细类代码
        sjd.setJqjbdm("");        //警情级别代码
        sjd.setZdbz("0");  //重大警情标志
        sjd.setSsxqdm("602");    //所属辖区代码
        sjd.setSsxqmc("徐汇分局枫林派出所");     //所属辖区名称
        sjd.setSzjqdm("0");      //所在街区代码
        sjd.setSzjqmc("");           //所在街区名称
        sjd.setJzwmc("");        //建筑物名称
        sjd.setSfdzflmc("");   //事发地址分类名称
        sjd.setJjth("0");           //接警台号
        sjd.setJjtip("");       //接警台IP
        sjd.setXqdwmc("徐汇分局");       //辖区单位名称
        sjd.setSsfjmc("徐汇分局");//所属分局名称
        sjd.setAymc("噪音扰民");           //案由名称
        sjd.setJqlbmc("噪音扰民");           //警情类别名称
        sjd.setJqlxmc("求助");           //警情类型名称
        sjd.setJqxlmc("");//警情细类名称
        sjd.setScjjdwmc("上海市公安局"); //首次接警单位名称
        sjd.setScpjdwmc("上海市公安局");//首次派警单位名称
        sjd.setScfkdwmc(""); //首次反馈单位名称
        sjd.setJqbqid("");//警情标签ID
        sjd.setJqbqmc("");//警情标签名称
        KafkaResponse response = new KafkaResponse();
        JSONObject json = (JSONObject) JSONObject.toJSON(sjd);
        response.setData(json);
        response.setData_source("Hive_jdbc");
        response.setDatabase("hive");
        response.setSchema("odx_tx");
        response.setTable("ds119_t_sjd");
        JSONObject responseJson = (JSONObject) JSONObject.toJSON(response);
        ListenableFuture future = kafkaTemplate.send(topic,responseJson.toString());
        //String message = UUID.randomUUID().toString();
        //ListenableFuture future = kafkaTemplate.send("test", message);
        future.addCallback(o -> System.out.println("send-消息发送成功："+ responseJson.toString()), throwable -> System.out.println("消息发送失败：" + responseJson.toString()));


    }

}
