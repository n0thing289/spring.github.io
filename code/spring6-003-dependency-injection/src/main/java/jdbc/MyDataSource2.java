package jdbc;

import java.util.Properties;

public class MyDataSource2 {
    /*
    把链接数据库的信息封装到properties
    driver
    url
    user
    password
     */
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "MyDataSource2{" +
                "properties=" + properties +
                '}';
    }
}
