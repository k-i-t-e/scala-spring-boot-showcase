package com.kite.wealfyservice.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class WebMvcConfig {
  @Bean
  def objectMapper: ObjectMapper = {
    new ObjectMapper()
      .registerModule(DefaultScalaModule) // because this is a Scala object
      .registerModule(new JavaTimeModule())
  }
}
