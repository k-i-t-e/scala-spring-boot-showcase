package com.kite.wealfyservice.config

import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(scanBasePackages = Array(
  "com.kite.wealfyservice.controller",
  "com.kite.wealfyservice.service",
  "com.kite.wealfyservice.config"))
//@EnableJpaRepositories(basePackages = Array("com.kite.wealfyservice.repository"))
//@EntityScan(Array("com.kite.wealfyservice.entity"))
class ApplicationConfig
