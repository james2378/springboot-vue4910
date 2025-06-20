package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *活动中心：(ActivityCenter)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ActivityCenter")
public class ActivityCenter implements Serializable {

    //ActivityCenter编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_center_id")
    private Integer activity_center_id;
   // 活动标题
   @Basic
    private String activity_title;
   // 活动标签
   @Basic
    private String activity_label;
   // 活动封面
   @Basic
    private String event_cover;
   // 发布时间
   @Basic
    private Timestamp release_time;
   // 活动详情
   @Basic
    private String activity_details;
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
