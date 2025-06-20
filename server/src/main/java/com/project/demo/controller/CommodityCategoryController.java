package com.project.demo.controller;

import com.project.demo.entity.CommodityCategory;
import com.project.demo.service.CommodityCategoryService;
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
 *商品类别：(CommodityCategory)表控制层
 *
 */
@RestController
@RequestMapping("/commodity_category")
public class CommodityCategoryController extends BaseController<CommodityCategory,CommodityCategoryService> {

    /**
     *商品类别对象
     */
    @Autowired
    public CommodityCategoryController(CommodityCategoryService service) {
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
