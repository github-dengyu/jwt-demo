package com.huato.jwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huato.jwt.JWT;
import com.huato.jwt.bean.User;
import com.huato.jwt.util.ResultBean;

@Controller
public class LoginController {
	
	//验证token的有效性  get请求
	@RequestMapping(value="/getInfo/{token:.+}",method=RequestMethod.GET,produces="application/json;charset=UTF-8")  
    @ResponseBody  
    public ResultBean getInfo(@PathVariable("token") String token) {  
        User user = JWT.unsign(token, User.class);  
        if (user != null) {  
            return ResultBean.ok().putDataValues("user", user);  
        }  
        return ResultBean.customerError().putDataValues(ResultBean.ERRORS_KEY, new String[] { "token不合法" });  
    }  
	
}
