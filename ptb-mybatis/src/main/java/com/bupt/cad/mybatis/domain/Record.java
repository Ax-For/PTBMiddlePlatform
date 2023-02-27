package com.bupt.cad.mybatis.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * 奏折信息
 * </p>
 *
 * @author cad
 * @since 2023-02-06
 */
@Getter
@Setter
@ToString
@TableName("record")
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 题目
     */
    @TableField("title")
    private String title;

    /**
     * 内容
     */
    @TableField("content")
    private String content;

    /**
     * 奏报者Id
     */
    @TableField("submitter_id")
    private Long submitterId;

    /**
     * 创建日期
     */
    @TableField("create_time")
    private LocalDate createTime;

    /**
     * 处理日期
     */
    @TableField("handle_date")
    private LocalDate handleDate;

    /**
     * 处理时间
     */
    @TableField("handle_time")
    private LocalTime handleTime;

    /**
     * 回复内容
     */
    @TableField("handle_content")
    private String handleContent;

    /**
     * 完成时间
     */
    @TableField("finish_datetime")
    private LocalDateTime finishDatetime;

    /**
     * 状态（0-未读、1-已读、2-已批复）
     */
    @TableField("status")
    private Integer status;
}
