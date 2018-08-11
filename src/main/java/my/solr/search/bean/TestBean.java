package my.solr.search.bean;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @Description:
 * @Author: 韦东
 * @Date: Created in 2018/6/28 14:35
 */
public class TestBean {
    @Field
    private String id;
    @Field
    private String name;
    @Field
    private String dm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDm() {
        return dm;
    }

    public void setDm(String dm) {
        this.dm = dm;
    }
}
