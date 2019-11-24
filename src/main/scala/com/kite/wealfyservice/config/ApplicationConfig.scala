package com.kite.wealfyservice.config

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = Array(
  "com.kite.wealfyservice.controller",
  "com.kite.wealfyservice.service",
  "com.kite.wealfyservice.config"))
@EnableJpaRepositories(basePackages = Array("com.kite.wealfyservice.repository"))
@EntityScan(Array("com.kite.wealfyservice.entity"))
class ApplicationConfig {
}
