package com.nbchen.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    private String orderId; // 订单id
    private Date createTime; // 创建时间
    private BigDecimal price; // 订单价格
    @Builder.Default
    private Integer status = 0; // 订单状态: 0 未发货，1 已发货，2 表示已签收
    private Integer userId; // 用户id
}
