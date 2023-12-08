bean的生命周期五步的话：
 第一步：实例化bean（调用无参数构造方法）
 第二步：给bean属性赋值（调用set方法）
 第三步：初始化bean（会调用init方法，注意这个init方法需要自己写，自己配置）
 第四步：使用bean
 第五步：销毁bean（会调用bean的destroy方法，注意这个destroy方法需要自己写，自己配置）

Bean生命周期七步
    第一步:实例化Bean
    第二步:Bean属性赋值
    第三步:执行“Bean后处理器”的before方法。
    第四步:初始化Bean
    第五步:执行“Bean后处理器”的after方法。
    第六步:使用Bean
    第七步:销毁Bean

bean后处理器有两个参数
    第一个参数: 刚创建的bean对象
    第二个参数: bean的名字

Bean生命周期十步
    点位1: 在bean后处理器before之前
        干了什么事?
            检查Bean是否实现了Aware相关的接口,如果实现类接口则调用这些接口的方法
            然后调用这些方法的目的是为了给你传递一些数据,让你更加方便使用
    点位2: 在bean后处理器before之后
        干了什么事?
            检查Bean是否实现类InitializingBean接口,如果实现了, 则调用接口中的方法
    点位3: 使用bean之后, 或者说在销毁bean之前
        干了什么事?
            检查Bean是否实现了DisposableBean接口,如果实现类,则调用接口中的方法