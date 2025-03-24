package com.jim.ssr.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 菜单
 * @TableName tbl_menu
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
    private Integer typeId;

    /**
     * 名称
     */
    private String name1;

    /**
     * 
     */
    private String name2;

    /**
     * 价格
     */
    private BigDecimal price1;

    /**
     * 描述
     */
    private Integer price2;

    /**
     * 描述
     */
    private String comment;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Menu other = (Menu) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getName1() == null ? other.getName1() == null : this.getName1().equals(other.getName1()))
            && (this.getName2() == null ? other.getName2() == null : this.getName2().equals(other.getName2()))
            && (this.getPrice1() == null ? other.getPrice1() == null : this.getPrice1().equals(other.getPrice1()))
            && (this.getPrice2() == null ? other.getPrice2() == null : this.getPrice2().equals(other.getPrice2()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getName1() == null) ? 0 : getName1().hashCode());
        result = prime * result + ((getName2() == null) ? 0 : getName2().hashCode());
        result = prime * result + ((getPrice1() == null) ? 0 : getPrice1().hashCode());
        result = prime * result + ((getPrice2() == null) ? 0 : getPrice2().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", typeId=").append(typeId);
        sb.append(", name1=").append(name1);
        sb.append(", name2=").append(name2);
        sb.append(", price1=").append(price1);
        sb.append(", price2=").append(price2);
        sb.append(", comment=").append(comment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}