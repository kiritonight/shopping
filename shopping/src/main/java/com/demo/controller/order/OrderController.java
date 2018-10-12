package com.demo.controller.order;

import com.demo.common.model.Order;
import com.demo.common.model.Orderitem;
import com.demo.controller.user.UserService;
import com.demo.units.JsonUnit;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 20:072018/10/11/011
 * @Modified By:
 */

public class OrderController extends Controller{

    @ActionKey("/order/create")
    public void createOrder()
    {
        String name=getSessionAttr("name");
        if(name==null)
        {
         renderJson(new JsonUnit<Order>(false,0,"登陆信息失效",null));
        }
        else
        {
            List<Orderitem> orderItemList=getSessionAttr("orderItemList");
            if(orderItemList!=null)
            {
                Record order = new Record().set("order_uid", UserService.me.findByName(name).getUserId());
                Db.save("t_order", order);

                for(Orderitem orderItem:orderItemList)
                {
                    orderItem.setOrderitemOid(OrderService.me.findOidByName(name));
                    Record o=new Record().set("orderitem_id",orderItem.getOrderitemId()).set("orderitem_pid",orderItem.getOrderitemPid()).set("orderitem_num",orderItem.getOrderitemNum()).set("orderitem_oid",orderItem.getOrderitemOid());
                    Db.save("t_orderitem",o);
                }
                renderJson(new JsonUnit<Order>(true,2,"购买成功",null));
            }
            else
                renderJson(new JsonUnit<Order>(false,1,"购物篮为空",null));
        }
    }

}
