package com.jim.ssr.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 订单信息
 * @TableName tbl_order_detail
 */
@Data
public class OrderDetail implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 外键
     */
    private Long order_id;

    /**
     * 主标题
     */
    private String name1;

    /**
     * 副标题
     */
    private String name2;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 大份小份
     */
    private Integer size;

    /**
     * 数量
     */
    private Integer num;

    /**
     * 备注
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
        OrderDetail other = (OrderDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrder_id() == null ? other.getOrder_id() == null : this.getOrder_id().equals(other.getOrder_id()))
            && (this.getName1() == null ? other.getName1() == null : this.getName1().equals(other.getName1()))
            && (this.getName2() == null ? other.getName2() == null : this.getName2().equals(other.getName2()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrder_id() == null) ? 0 : getOrder_id().hashCode());
        result = prime * result + ((getName1() == null) ? 0 : getName1().hashCode());
        result = prime * result + ((getName2() == null) ? 0 : getName2().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
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
        sb.append(", order_id=").append(order_id);
        sb.append(", name1=").append(name1);
        sb.append(", name2=").append(name2);
        sb.append(", price=").append(price);
        sb.append(", size=").append(size);
        sb.append(", num=").append(num);
        sb.append(", comment=").append(comment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}