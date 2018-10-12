package com.demo.controller.order;

import com.demo.common.model.Order;

import java.util.List;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 20:082018/10/11/011
 * @Modified By:
 */
public class OrderService {
    public static final OrderService me =new OrderService();
    private Order dao=new Order().dao();
    public int findOidByName(String name)
    {
        String sql="select order_id" +
                " from t_order a" +
                " inner join t_user b on a.order_uid=b.user_id" +
                " where user_name='"+name+"'order by order_id desc;";
       List<Order> oidList=dao.find(sql);
       if(oidList!=null)
          return oidList.get(0).getOrderId();
           else
        return 0;
    }
}
