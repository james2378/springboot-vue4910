package com.project.demo.controller;

import com.project.demo.entity.UserRegistration;
import com.project.demo.service.UserRegistrationService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *用户注册：(UserRegistration)表控制层
 *
 */
@RestController
@RequestMapping("/user_registration")
public class UserRegistrationController extends BaseController<UserRegistration,UserRegistrationService> {

    /**
     *用户注册对象
     */
    @Autowired
    public UserRegistrationController(UserRegistrationService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> mapuser_account = new HashMap<>();
        mapuser_account.put("user_account",String.valueOf(paramMap.get("user_account")));
        List listuser_account = service.select(mapuser_account, new HashMap<>()).getResultList();
        if (listuser_account.size()>0){
            return error(30000, "字段用户账号内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
