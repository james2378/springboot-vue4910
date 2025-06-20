package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *评价中心：(EvaluationCenter)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "EvaluationCenter")
public class EvaluationCenter implements Serializable {

    //EvaluationCenter编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluation_center_id")
    private Integer evaluation_center_id;
   // 订单编号
   @Basic
    private String order_number;
   // 商品名称
   @Basic
    private String trade_name;
   // 商品类型
   @Basic
    private String commodity_type;
   // 用户账号
   @Basic
    private Integer user_account;
   // 服务评价
   @Basic
    private String service_evaluation;
   // 评价日期
   @Basic
    private Timestamp evaluation_date;
   // 评价内容
   @Basic
    private String evaluation_content;
   // 回复内容
   @Basic
    private String reply_content;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
