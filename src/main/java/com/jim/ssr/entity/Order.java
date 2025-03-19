package com.jim.ssr.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 订单
 * @TableName tbl_order
 */
@Data
public class Order implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 名字1(18.8)+名字2(21.4)+....
     */
    private String menu_info;

    /**
     * 订单号码（出现在小票上的），0~999
     */
    private Integer num;

    /**
     * 0 创建 1 完成 4 删除
     */
    private Integer status;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 创建日期
     */
    private String createDate;

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
        Order other = (Order) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMenu_info() == null ? other.getMenu_info() == null : this.getMenu_info().equals(other.getMenu_info()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMenu_info() == null) ? 0 : getMenu_info().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
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
        sb.append(", menu_info=").append(menu_info);
        sb.append(", num=").append(num);
        sb.append(", status=").append(status);
        sb.append(", price=").append(price);
        sb.append(", createDate=").append(createDate);
        sb.append(", comment=").append(comment);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}