package com.kite.wealfyservice

import com.kite.wealfyservice.config.ApplicationConfig
import org.springframework.boot.SpringApplication


object WealfyApplication extends App {
  SpringApplication.run(classOf[ApplicationConfig])
}
