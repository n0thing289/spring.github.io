package service;

import org.springframework.stereotype.Service;

/**
 * 目标类
 */
@Service("orderService")
public class OrderService {
    //目标方法
    public void generate(){
        System.out.println("生产订单");
//        if(1 == 1){
//            throw new RuntimeException();
//        }
    }
}
