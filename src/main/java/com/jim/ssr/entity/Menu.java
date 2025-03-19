package com.jim.ssr.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 菜单
 * @TableName menu
 */
@Data
public class Menu implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 类型ID
     */
    private Integer type_id;

    /**
     * 名称
     */
    private String name;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 描述
     */
    private String comment;

    private static final long serialVersionUID = 1L;
}