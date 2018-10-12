package com.demo.controller.user;

import com.demo.common.model.User;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 19:462018/10/10/010
 * @Modified By:
 */
public class UserService {
    private User dao=new User().dao();
    public  static  final UserService me=new UserService();
    public User findByName(String name)   //根据用户名查用户对象
    {
        String sql="select * from t_user where user_name=?";
        List<User> user=dao.find(sql,name);
        if(user.size()>0)
        {
            return user.get(0);
        }
        else
            return null;
    }
    public void addUser(String name,String password)
    {
            Record user = new Record().set("user_name", name).set("user_password", password);
            Db.save("t_user", user);
    }
}
