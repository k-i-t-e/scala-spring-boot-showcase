package com.kite.wealfyservice.service.validation

trait EntityValidator[T] {
  def validate(entity: T): Either[String, Boolean]
}
