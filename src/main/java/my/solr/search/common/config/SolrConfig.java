package my.solr.search.common.config;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: 韦东
 * @Date: Created in 2018/6/28 14:27
 */

@Configuration
public class SolrConfig {

    @Value("${solr.host}")
    private String solrHost;

    @Value("${solr.maxRetries}")
    private Integer maxRetries;

    @Value("${solr.connectionTimeout}")
    private Integer connectionTimeout;

    @Bean
    public HttpSolrServer HttpSolrServer() {
        HttpSolrServer solrServer = new HttpSolrServer(solrHost);
        solrServer.setBaseURL(solrHost);
        solrServer.setMaxRetries(maxRetries);
        solrServer.setConnectionTimeout(connectionTimeout);
        return solrServer;
    }
}
