package my.solr.search.bean;

/**
 * @Description:
 * @Author: 韦东
 * @Date: Created in 2018/6/28 16:44
 */
public class SearchRequest {
    private String keyWord;
    private String type;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
