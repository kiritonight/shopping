package com.demo.controller.produ;

import com.demo.common.model.Product;

import java.util.List;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 19:192018/10/10/010
 * @Modified By:
 */
public class ProductService {
    public static final ProductService me=new ProductService();
    private Product dao=new Product().dao();
    public List findList()
    {
        String sql="select * from t_product";
        List <Product> list=dao.find(sql);
        if(list.size()>0)
            return list;
        else
            return null;
    }
    public Product findById()
    {
        String sql="select * from t_product where id=?";
        List<Product> list=dao.find(sql);
        if(list.size()>0)
            return list.get(0);
        else
            return null;
    }
}
