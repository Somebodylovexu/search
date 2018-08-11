package my.solr.search.bean;

import java.util.List;

/**
 * @Description:
 * @Author: 韦东
 * @Date: Created in 2018/6/28 15:03
 */
public class AddRequest {

    private List<TestBean> beanList;

    public List<TestBean> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<TestBean> beanList) {
        this.beanList = beanList;
    }
}
