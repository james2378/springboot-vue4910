package com.project.demo.controller;

import com.project.demo.entity.ActivityCenter;
import com.project.demo.service.ActivityCenterService;
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
 *活动中心：(ActivityCenter)表控制层
 *
 */
@RestController
@RequestMapping("/activity_center")
public class ActivityCenterController extends BaseController<ActivityCenter,ActivityCenterService> {

    /**
     *活动中心对象
     */
    @Autowired
    public ActivityCenterController(ActivityCenterService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
