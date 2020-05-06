package com.znsd.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 无参构造
@NoArgsConstructor
// 全参构造
@AllArgsConstructor
// get、set、toString ...
@Data
/**
 *  通用返回Bean
 */
public class CommonResultBean<T> {
    // 真实对象
    private T bean;
    // 消息
    private String message;
    // 状态码：200 500  vue 不需要
    private Integer code;
}
