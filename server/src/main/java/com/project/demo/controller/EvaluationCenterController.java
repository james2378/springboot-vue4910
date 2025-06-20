package com.project.demo.controller;

import com.project.demo.entity.EvaluationCenter;
import com.project.demo.service.EvaluationCenterService;
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
 *评价中心：(EvaluationCenter)表控制层
 *
 */
@RestController
@RequestMapping("/evaluation_center")
public class EvaluationCenterController extends BaseController<EvaluationCenter,EvaluationCenterService> {

    /**
     *评价中心对象
     */
    @Autowired
    public EvaluationCenterController(EvaluationCenterService service) {
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
