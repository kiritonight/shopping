package com.demo.common.model;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 21:312018/10/10/010
 * @Modified By:
 */
public class OrderItem {
    private int id;
    private Product product;
    private int num;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public Product getProduct()
    {
        return product;
    }
    public void setProduct(Product product)
    {
        this.product=product;
    }

    public int getNum()
    {
        return num;
    }
    public void setNum()
    {
        this.num=num;
    }
}
