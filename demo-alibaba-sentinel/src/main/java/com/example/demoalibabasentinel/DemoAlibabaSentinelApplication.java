package com.example.demoalibabasentinel;

import com.example.demoalibabasentinel.feign.EchoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@EnableFeignClients
public class DemoAlibabaSentinelApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAlibabaSentinelApplication.class, args);
	}

	@RestController
	public class EchoController{
		@Resource
		EchoService echoService;
		@GetMapping(value = "/echo/{str}")
		public String echo(@PathVariable("str") String str){
			return echoService.echo(str);
		}
		@GetMapping(value = "/getName/{name}")
		public String getName(@PathVariable String name){
			return echoService.getName(name);
		}
	}

}
