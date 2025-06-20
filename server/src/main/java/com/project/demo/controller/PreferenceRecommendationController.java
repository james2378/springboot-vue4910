package com.project.demo.controller;

import com.project.demo.entity.PreferenceRecommendation;
import com.project.demo.service.PreferenceRecommendationService;
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
 *喜好推荐：(PreferenceRecommendation)表控制层
 *
 */
@RestController
@RequestMapping("/preference_recommendation")
public class PreferenceRecommendationController extends BaseController<PreferenceRecommendation,PreferenceRecommendationService> {

    /**
     *喜好推荐对象
     */
    @Autowired
    public PreferenceRecommendationController(PreferenceRecommendationService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }
    @RequestMapping("/get_hits_list")
    public Map<String, Object> getHits(HttpServletRequest request) {
        Map<String,String> paramMap = service.readQuery(request);
        if (paramMap.get("user_id")==null||paramMap.get("user_id")==""){
        return this.getList(request);
        }else{
            String sql="SELECT\n"+
            "\t* \n"+
            "FROM\n"+
            "\tpreference_recommendation \n"+
            "WHERE\n"+
            "\tcommodity_type = (\n"+
            "\tSELECT\n"+
            "\t\tcommodity_type \n"+
            "\tFROM\n"+
            "\t\tpreference_recommendation \n"+
            "\tWHERE\n"+
            "\t\tpreference_recommendation_id = (\n"+
            "\t\tSELECT\n"+
            "\t\t\tt1.source_id \n"+
            "\t\tFROM\n"+
            "\t\t\t( SELECT COUNT( hits_id ) AS hits_count, source_id FROM hits WHERE source_table = 'preference_recommendation' AND user_id = "+paramMap.get("user_id")+" GROUP BY source_id ) t1 \n"+
            "\t\tORDER BY\n"+
            "\t\t\thits_count DESC \n"+
            "\t\t\tLIMIT 0,\n"+
            "\t\t\t1 \n"+
            "\t\t)) \n"+
            "ORDER BY\n"+
            "\thits DESC \n"+
            "\tLIMIT 0,4";
            Query select=service.runEntitySql(sql);
            Map<String, Object> map=new HashMap<>();
            map.put("list",select.getResultList());
            map.put("count",select.getResultList().size());
            return success(map);
        }
    }

}
