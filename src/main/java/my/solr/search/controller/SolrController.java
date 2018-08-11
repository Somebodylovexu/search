package my.solr.search.controller;

import my.solr.search.bean.AddRequest;
import my.solr.search.bean.SearchRequest;
import my.solr.search.bean.TestBean;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: 韦东
 * @Date: Created in 2018/6/28 14:21
 */
@RestController
@RequestMapping("solr")
public class SolrController {

    @Autowired
    private HttpSolrServer solrServer;

    @RequestMapping("search")
    public List<TestBean> search(@RequestBody SearchRequest request) {
        List<TestBean> beanList = new ArrayList<>();
        String keyWord = request.getKeyWord();
        String type = request.getType();
        if (StringUtils.isEmpty(keyWord)) {
            // 如果为null，查询所有
            keyWord = "*";
        }

        if (StringUtils.isEmpty(type)) {
            //如果为null,  查询name
            type = "name";
        }

        SolrQuery query = new SolrQuery(type + ":" + keyWord);

        try {
            QueryResponse response = solrServer.query(query);
            beanList = response.getBeans(TestBean.class);
        }catch (HttpSolrServer.RemoteSolrException e){
        }catch (SolrServerException e) {
            e.printStackTrace();
        }

        return beanList;
    }

    @RequestMapping("add")
    public String add(@RequestBody AddRequest request) {
        List<TestBean> beanList = request.getBeanList();

        try {
            if (beanList != null && beanList.size() > 0) {
                solrServer.addBeans(beanList);
                solrServer.commit();
            }
        } catch (SolrServerException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "SUCCESS!";
    }
}
