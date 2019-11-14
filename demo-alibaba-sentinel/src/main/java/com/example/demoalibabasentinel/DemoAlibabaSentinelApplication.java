package com.example.demoalibabasentinel;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.example.demoalibabasentinel.feign.EchoService;
import com.example.demoalibabasentinel.rest.ExceptionUtil;
import com.example.demoalibabasentinel.rest.FallbackUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class DemoAlibabaSentinelApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAlibabaSentinelApplication.class, args);
	}

	@RestController
	public class EchoController{
		@Resource
		EchoService echoService;
		@Resource
		RestTemplate restTemplate;
		@Resource(name = "restTemplate2")
		RestTemplate restTemplate2;
		@GetMapping(value = "/echo/{str}")
		public String echo(@PathVariable("str") String str){
			return echoService.echo(str);
		}
		@GetMapping(value = "/getName/{name}")
		public String getName(@PathVariable String name){
			return echoService.getName(name);
		}
		@GetMapping(value = "/getEcho/{s}")
		public String get(@PathVariable String s){
//			return restTemplate.getForObject("http://www.taobao.com/test", String.class);
			return restTemplate.getForObject("http://service-provider/echo/"+s,String.class);
		}
		@GetMapping(value = "/getEcho")
		public String get2(){
//			return restTemplate.getForObject("http://www.taobao.com/test", String.class);
			return restTemplate2.getForObject("http://service-provider/echo/8",String.class);
		}
	}

	@Bean
	@SentinelRestTemplate(blockHandler = "handleException",
			blockHandlerClass = ExceptionUtil.class)
	public RestTemplate restTemplate2() {
		return new RestTemplate();
	}

	@Bean
	@LoadBalanced
	@SentinelRestTemplate(blockHandler = "handleException", blockHandlerClass = ExceptionUtil.class,
			fallbackClass = FallbackUtil.class,fallback = "handleFallback")
	public RestTemplate restTemplate() {
		final RestTemplate template = new RestTemplate();
		return template;
	}

}
