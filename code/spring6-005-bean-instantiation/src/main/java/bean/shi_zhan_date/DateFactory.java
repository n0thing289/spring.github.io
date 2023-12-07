package bean.shi_zhan_date;

import org.springframework.beans.factory.FactoryBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 具体工厂角色
 */
public class DateFactory implements FactoryBean<Date> {
    private String strDate;
    /*
    我们需要实现一个效果
     */

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    @Override
    public Date getObject() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(strDate);
        return date;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
