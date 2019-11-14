package com.example.demoalibabasentinel.rest;


import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;

/**
 * 说明
 *  @author maikec
 *  @date 2019/11/14
 */
public class FallbackUtil{
    private FallbackUtil(){}
    public static ClientHttpResponse handleFallback(HttpRequest request, byte[] body, ClientHttpRequestExecution execution,
                                                    BlockException exception) {
        final SentinelClientHttpResponse sentinelClientHttpResponse = new SentinelClientHttpResponse();
        return sentinelClientHttpResponse;
    }
}