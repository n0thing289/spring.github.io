package bean;

import java.util.*;

public class Person {
    private List<String> friends;
    private Set<String> addrs;
    private Map<Integer,String> phones;
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setPhones(Map<Integer, String> phones) {
        this.phones = phones;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public void setAddrs(Set<String> addrs) {
        this.addrs = addrs;
    }

    @Override
    public String toString() {
        return "Person{" +
                "friends=" + friends +
                ", addrs=" + addrs +
                ", phones=" + phones +
                ", properties=" + properties +
                '}';
    }
}
