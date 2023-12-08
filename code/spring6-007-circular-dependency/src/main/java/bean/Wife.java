package bean;

import bean.Husband;

public class Wife {
    private String name;
    private Husband husband;

    public void setName(String name) {
        this.name = name;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "bean.Wife{" +
                "name='" + name + '\'' +
                ", husband=" + husband.getName() +
                '}';
    }

    public Wife(String name, Husband husband) {
        this.name = name;
        this.husband = husband;
    }
}
