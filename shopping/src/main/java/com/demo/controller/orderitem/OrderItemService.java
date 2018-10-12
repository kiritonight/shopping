package com.demo.controller.orderitem;


import com.demo.common.model.Orderitem;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 16:192018/10/11/011
 * @Modified By:
 */
public class OrderItemService {
   public static final OrderItemService me=new OrderItemService();
     private Orderitem dao=new Orderitem().dao();

}
