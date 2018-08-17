package com.angrytest.ptp.provider.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersistBean {

    /**
     * 列名
     */
    private String column;

    /**
     * 成员变量名
     */
    private String propertyName;

    /**
     * jdbc type，可为空
     */
    private String jdbcType;

    /**
     * java type，可为空
     */
    private String javaType;

    /**
     * typeHandler,可以为空
     */
    private Class<?> typeHandler;
}
