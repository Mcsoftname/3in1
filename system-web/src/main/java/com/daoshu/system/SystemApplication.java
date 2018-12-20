package com.daoshu.system;

import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationHome;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.tobato.fastdfs.FdfsClientConfig;

@SpringBootApplication(scanBasePackages = "com.daoshu")
@EnableTransactionManagement
@EnableCaching
@EnableAsync
// 解决jmx重复注册bean的问题
@Import(FdfsClientConfig.class)
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@ServletComponentScan
@MapperScan(basePackages = "com.daoshu.**.mapper")
@EnableFeignClients(basePackages="com.daoshu")
@EnableDiscoveryClient
@EnableKafka
public class SystemApplication {

	private static final Logger logger = LoggerFactory.getLogger(SystemApplication.class);

	//初始化系统属性
	/*static {
		System.setProperty("java.security.auth.login.config", "/data/jaas.conf");
		System.setProperty("java.security.krb5.conf", "/etc/krb5.conf");
		System.setProperty("javax.security.auth.useSubjectCredsOnly", "false");
		System.setProperty("sun.security.krb5.debug", "true");
	}*/

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 单个文件最大
		factory.setMaxFileSize("100MB"); // KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("100MB");
		return factory.createMultipartConfig();
	}

	public static void main(String[] args) {
		String profile = "DEV";
		System.setProperty("env", profile);
		SpringApplication app = new SpringApplication(SystemApplication.class);
		app.run(args);
		ApplicationHome home = new ApplicationHome(SystemApplication.class);
		logger.info("-----PlatForm Application Start on home {" + home.getDir().getAbsolutePath() + "} -----");

	}

}
