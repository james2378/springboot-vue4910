package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *订单中心：(OrderCenter)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "OrderCenter")
public class OrderCenter implements Serializable {

    //OrderCenter编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_center_id")
    private Integer order_center_id;
   // 订单编号
   @Basic
    private String order_number;
   // 商品编号
   @Basic
    private String commodity_number;
   // 商品名称
   @Basic
    private String trade_name;
   // 商品类型
   @Basic
    private String commodity_type;
   // 商品价格
   @Basic
    private String commodity_price;
   // 购买数量
   @Basic
    private Integer purchase_quantity;
   // 总价格
   @Basic
    private String total_price;
   // 用户账号
   @Basic
    private Integer user_account;
   // 提交时间
   @Basic
    private Timestamp submission_time;
    // 支付状态
    @Basic
    private String pay_state;

    // 支付类型: 微信、支付宝、网银
    @Basic
    private String pay_type;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
