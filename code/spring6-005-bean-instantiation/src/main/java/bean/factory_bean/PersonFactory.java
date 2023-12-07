package bean.factory_bean;

import org.springframework.beans.factory.FactoryBean;

public class PersonFactory implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        return new Person();
    }

    @Override
    public Class<Person> getObjectType() {
        return Person.class;
    }
}
