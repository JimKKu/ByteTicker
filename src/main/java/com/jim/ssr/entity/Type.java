package com.jim.ssr.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 分类
 * @TableName type
 */
@Data
public class Type implements Serializable {
    /**
     * 分类ID
     */
    private Integer id;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 图标
     */
    private String icon;

    /**
     * 描述
     */
    private String comment;

    private static final long serialVersionUID = 1L;
}