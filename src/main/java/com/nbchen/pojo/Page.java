package com.nbchen.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Page 是分页的模型对象
 * @param <T> 是具体的模块的 javaBean 类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Page<T> {
    public static final Integer PAGE_SIZE_DEFAULT = 4; // 每页默认显示条数

    private Integer pageNo; // 当前页码
    @Builder.Default
    private Integer pageSize = PAGE_SIZE_DEFAULT; // 当前页显示数量
    private Integer pageTotal; // 总页码数
    private Integer pageTotalCount; // 总记录数
    private List<T> items; // 当前页数据

    private String url; // 分页条的请求地址
}
