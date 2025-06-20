package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *喜好推荐：(PreferenceRecommendation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "PreferenceRecommendation")
public class PreferenceRecommendation implements Serializable {

    //PreferenceRecommendation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preference_recommendation_id")
    private Integer preference_recommendation_id;
   // 商品编号
   @Basic
    private String commodity_number;
   // 商品名称
   @Basic
    private String trade_name;
   // 商品类型
   @Basic
    private String commodity_type;
   // 商品图片
   @Basic
    private String product_picture;
   // 商品价格
   @Basic
    private String commodity_price;
   // 商家账号
   @Basic
    private Integer merchant_account_number;
   // 商品详情
   @Basic
    private String product_details;
    // 点击数
    @Basic
    private Integer hits;
    // 点赞数
    @Basic
    private Integer praise_len;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
