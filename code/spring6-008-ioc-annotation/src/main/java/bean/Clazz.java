package bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("clazzBean")
public class Clazz {
    @Value("高三一班")
    private String name;
    @Value("301")
    private int num;

    @Override
    public String toString() {
        return "Clazz{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
