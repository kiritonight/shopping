package com.demo.controller.produ;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 19:162018/10/10/010
 * @Modified By:
 */
import com.demo.common.model.Product;
import com.demo.units.JsonUnit;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

import java.util.List;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 16:432018/10/10/010
 * @Modified By:
 */

public class ProductController  extends Controller {


    @ActionKey("/listproduct")//获得所有的产品列表
    public void getProductList()
    {
        List<Product> productlist=ProductService.me.findList();
        renderJson(new JsonUnit<>(true,200,"获取成功",productlist));
    }
}
