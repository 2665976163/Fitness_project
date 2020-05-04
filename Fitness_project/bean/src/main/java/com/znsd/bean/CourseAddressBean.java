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
 * 课程资源地址bean
 */
public class CourseAddressBean {
    // 课程Id
    private Integer c_Id;
    // 课程资源名称
    private String as_Titile;
    // 课程资源路径
    private String as_ResourcePath;
}
