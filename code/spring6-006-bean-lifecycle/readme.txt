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
