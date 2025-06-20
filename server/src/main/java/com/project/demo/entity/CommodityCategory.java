package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *商品类别：(CommodityCategory)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "CommodityCategory")
public class CommodityCategory implements Serializable {

    //CommodityCategory编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commodity_category_id")
    private Integer commodity_category_id;
   // 商品类型
   @Basic
    private String commodity_type;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
