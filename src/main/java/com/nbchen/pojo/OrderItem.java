package com.nbchen.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 订单项
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    private Integer id; // 订单项id
    private String name; // 订单项名称
    private Integer count; // 订单项数量
    private BigDecimal price; // 订单项价格
    private BigDecimal totalPrice; // 订单项总价格
    private String orderId; // 订单id
}
