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
 * 用户地址bean
 */
public class UserAddressBean {
    private Integer ua_Id;
    private String ua_Addressl;
    private String ua_CreateDate;
    private String ua_LastUpdate;
    private Integer u_Id;
}
