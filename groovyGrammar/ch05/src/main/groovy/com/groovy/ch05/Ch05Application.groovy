package com.groovy.ch05


import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

@SpringBootApplication
class Ch05Application  {

	static void main(String[] args) {
//		SpringApplication.run(Ch05Application, args)
		new SpringApplicationBuilder(Ch05Application)
		.properties([
		        'spring.application.name': 'ch05',
				'server.port': '8081'
		])
		.run(args)
	}
}
