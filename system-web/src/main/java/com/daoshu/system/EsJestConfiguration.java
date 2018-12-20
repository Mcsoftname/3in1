/*
package com.daoshu.system;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import lombok.Data;
@Configuration
public class EsJestConfiguration {
	
	  private static final String HTTP_PREFIX = "http://";
	  
	  private static final Logger logger = LoggerFactory.getLogger(EsJestConfiguration.class);

      private JestClient tagClient;
      
		
	  @Autowired
	  private ElasticSearchProperties  elasticSearchProperties;
      
      @Bean
      @ConditionalOnMissingBean
      public JestClient jestClient() {
          try {
              logger.info("----AutoConfiguration JestClient----");
              this.tagClient = createJestClient();
              return this.tagClient;
          } catch (Exception ex) {
              throw new IllegalStateException(ex);
          }
      }
      
      
      private JestClient createJestClient() throws Exception {
          List<String> clusterSet = elasticSearchProperties.getClusterNodeList();
          System.out.println(elasticSearchProperties.getClusterName());
          JestClientFactory factory = new JestClientFactory();
          factory.setHttpClientConfig(
                  new HttpClientConfig.Builder(clusterSet)
                          .multiThreaded(true)
                          .connTimeout(elasticSearchProperties.getHttpConnTimeout())
                          .readTimeout(elasticSearchProperties.getHttpReadTimeout())
                          .maxTotalConnection(elasticSearchProperties.getHttpMaxTotalConn())
                          .build()
          );
          return factory.getObject();
      }

	    @ConfigurationProperties(prefix = "pvd.base.es-server-config")
		@Component
		@Data
		public static class ElasticSearchProperties {
			private String clusterName;
			private List<String> clusterNodeList;
		     */
/**
	         * JestClient超时时间，默认10s
	         *//*

	        private Integer httpConnTimeout = 10_000;
	        
	        
	        */
/**
	         * JestClient读超时，默认10s
	         *//*

	        private Integer httpReadTimeout = 10_000;
	        
	        */
/**
	         * JestClient最大连接数
	         *//*

	        private Integer httpMaxTotalConn = 100;
			

		}

}
*/
