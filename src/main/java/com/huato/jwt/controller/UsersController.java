package com.huato.jwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huato.jwt.JWT;
import com.huato.jwt.bean.User;
import com.huato.jwt.util.ResultBean;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	
    @PostMapping("/login")  
    @ResponseBody  
    public ResultBean login(@RequestParam String username, @RequestParam String password) {  
        if ("dengyu".equals(username) && "123456".equals(password)) {  
            ResultBean resultBean = ResultBean.ok();
            User user = new User();  
            user.setId(1);  
            user.setUsername(username);  
            user.setPassword(password);  
            resultBean.putDataValues("user", user);  
            String token = JWT.sign(user, 30L * 24L * 3600L * 1000L);//过期时间是1个月  
            if (token != null) {  
            	resultBean.putDataValues("token", token);  
            }  
            return resultBean;  
        }  
        return ResultBean.customerError().putDataValues(ResultBean.ERRORS_KEY, new String[] { "用户名或者密码错误" });  
    }  

}
