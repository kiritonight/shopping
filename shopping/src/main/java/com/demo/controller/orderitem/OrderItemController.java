package com.demo.controller.orderitem;

import com.demo.common.model.Orderitem;
import com.demo.units.JsonUnit;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 16:182018/10/11/011
 * @Modified By:
 */
public class OrderItemController extends Controller {





    @ActionKey("/orderitem/add")
     public void addOrderItem()
     {
         String num=getPara("num");
        String pid =getPara("pid");
         Orderitem orderItem=new Orderitem();
         orderItem.setOrderitemNum(Integer.parseInt(num));
         orderItem.setOrderitemPid(Integer.parseInt(pid));
         List<Orderitem> ois=getSessionAttr("orderItemList");
         if(ois == null)
         {
             ois=new ArrayList<Orderitem>();
             setSessionAttr("orderItemList",ois);
         }
         boolean found=false;
         for(Orderitem o:ois)
         {
             if(o.getOrderitemPid()==orderItem.getOrderitemPid())
             {
                 o.setOrderitemNum(o.getOrderitemNum()+orderItem.getOrderitemNum());
                 found=true;
                 break;
             }
         }
         if(!found)
        ois.add(orderItem);
        renderJson(new JsonUnit<Orderitem>(true,0,"添加成功",null));
     }

    @ActionKey("/orderitem/delete")
     public void deleteOrderItemList()
     {
         String pid=getPara("pid");
         List<Orderitem> ois=getSessionAttr("orderItemList");
         if(ois == null)
             renderJson(new JsonUnit<Orderitem>(false,0,"链表为空",null));
         else
         {
             for(Orderitem orderItem :ois)
             {
                if(orderItem.getOrderitemPid()==Integer.parseInt(pid))
                {
                    ois.remove(orderItem);
                    break;
                }
             }
             renderJson(new JsonUnit<Orderitem>(true,1,"删除成功",null));
         }
     }

     @ActionKey("/orderitem/getlist")
     public void getOrderItemList()
     {
         List<Orderitem> ois=getSessionAttr("orderItemList");
         if(ois==null)
         {
             renderJson(new JsonUnit<Orderitem>(false,0,"链表里为空",null));
         }
         else
         {
             renderJson(new JsonUnit<>(true,1,"获取成功",ois));
         }
     }

}
