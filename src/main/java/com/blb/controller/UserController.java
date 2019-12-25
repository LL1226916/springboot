package com.blb.controller;

import com.blb.pojo.UserInfo;
import com.blb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("aaa")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("bbb")
    @ResponseBody
    public String aaa(){
        System.out.println("aha");
        return "success";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public UserInfo queryUserByid(@PathVariable("id") Long i){
        UserInfo user=userService.queryUserByid(i);
        return user;
    }

    @GetMapping("/del/{ids}")
    @ResponseBody
    public String deleteuser(@PathVariable("ids") Long id){
        userService.deleteById(id);
        return "seccess";
    }

    @GetMapping("/list")
    public String queryAllUser(Model model){
        List<UserInfo> ulist=userService.queryAllUser();
        System.out.println(ulist.size());
        for (UserInfo user : ulist
             ) {
            System.out.println(user);
        }
        model.addAttribute("user",ulist);
        return "item";
    }
}
