package com.kite.wealfyservice.util

import com.kite.wealfyservice.exception.EntityValidationException
import com.kite.wealfyservice.service.validation.EntityValidator

trait Validating {
  def validate[T : EntityValidator](entity: T): Either[String, Boolean] = {
    val validator = implicitly[EntityValidator[T]]
    validator.validate(entity)
  }

  def withValid[T : EntityValidator, R](entity: T)(block: => R): R =
    implicitly[EntityValidator[T]]
      .validate(entity) match {
      case Right(_) => block
      case Left(message) => throw EntityValidationException(message)
    }
}
