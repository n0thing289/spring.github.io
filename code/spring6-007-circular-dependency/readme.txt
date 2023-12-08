创建对象A会先实例化A,再对外曝光A,然后属性赋值遇到B,实例化B,B对外曝光,B再属性赋值【这个时候可以拿到A】,赋值完成,A再赋值完成

源码分析:
DefaultSingletonBeanRegistry类中有三个比较重要的缓存:
    private final Map<String, 0bject> singletonObjects                  一级缓存
    private final Map<String,Object> earlySingletonObjects              二级缓存
    private final Map<String, ObjectFactory<?>> singletonFactories      三级缓存



    这三个缓存都是Map集合。
    Map集合的key存储的都是bean的name (bean id)

    一级缓存存储的是:单例Bean对象，完整的单例Bean对象，也就是说这个缓存中的Bean对象的属性都已经赋值了。是一个完整的Bean对象。
    二级缓存存储的是:早期的单例Bean对象。这个缓存中的单例Bean对象的属性没有赋值。只是一个早期的实例对象。
    三级缓存存储的是:单例工厂对象。这个里面存储了大量的“工厂对象”，每一个单例Bean对象都会对应一个单例工厂对象。
                    这个集合中存储的是，创建该单例对象时对应的那个单例工厂对象。