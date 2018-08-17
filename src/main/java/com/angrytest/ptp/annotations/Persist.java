package com.angrytest.ptp.annotations;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Persist {

    /**
     * 列名，默认为空
     * @return 列名
     */
    String column() default "";

    /**
     * 对应mybatis中的jdbcType，默认为空
     * @return jdbcType
     */
    String jdbcType() default "";

    /**
     * 对应mybatis中的javaType，默认为空
     * @return javaType
     */
    String javaType() default "";

    /**
     * 指定特殊的type handler
     * 默认为Object.class，表示不作特殊指定
     * @return typeHandler
     */
    Class<?> typeHandler() default Object.class;
}