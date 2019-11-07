package com.example.demofeign.feign;
/**
 * 公司名称
 * <p>
 * 本源代码由《demo-spring-cloud》及其作者共同所有，未经版权持有者的事先书面授权，
 * 不得使用、复制、修改、合并、发布、分发和/或销售本源代码的副本。
 *
 * @copyright Copyright (c) 2019-2019+3. （company）all rights reserved.
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 说明
 *  @author maikec
 *  @date 2019/11/7
 */
@FeignClient("demo-eureka-client")
public interface HelloClient {
    /**
     * 获取
     * @return
     */
    @GetMapping("/custom/hello")
    String getHello();
}
