package com.demo.controller.user;

import com.demo.common.model.User;
import com.demo.units.JsonUnit;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;

/**
 * @author ZhiWeng Wang
 * @Description:
 * @Date: Created in 19:462018/10/10/010
 * @Modified By:
 */
public class UserController extends Controller {

    @ActionKey("/dologin")
      public void doLogin()
      {
          String name=getPara("name");
          String password=getPara("password");
          if(UserService.me.findByName(name)!=null)
          {
              User user=UserService.me.findByName(name);
              if(user.getPassword().equals(password))
              {
                  renderJson(new JsonUnit<User>(true,0,"登陆成功",null));
              }
              else
              {
                  renderJson(new JsonUnit<User>(false,2,"密码不正确",null));
              }
          }
          else
              renderJson(new JsonUnit<User>(false,1,"用户不存在",null));
      }
      @ActionKey("/doregist")
    public void doregist()
      {
          String name=getPara("name");
          String password=getPara("password");
          if(UserService.me.findByName(name)==null)
          {
            UserService.me.addUser(name,password);
            renderJson(new JsonUnit<User>(true,1,"注册成功",null));
          }
          else
          {
              renderJson(new JsonUnit<User>(false,0,"用户名已存在",null));
          }

      }
}
