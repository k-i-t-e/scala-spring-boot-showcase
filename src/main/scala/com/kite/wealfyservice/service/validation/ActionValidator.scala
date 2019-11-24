package com.kite.wealfyservice.service.validation

import com.kite.wealfyservice.entity.Action
import org.springframework.stereotype.Component

@Component
class ActionValidator extends EntityValidator[Action] {
  private val rules = Map(
    "Info should not be empty" -> { a: Action => a.info != null && !a.info.isEmpty },
    "Created date should be present" -> { a: Action => a.createdDate != null },
    "Category should be set" -> { a: Action => a.income || a.category != null }
  )

  override def validate(entity: Action): Either[String, Boolean] =
    rules
      .filterNot(r => r._2(entity))
      .keys
      .reduceOption(_ + ". " + _) match {
      case Some(message) => Left(s"Action invalid: $message")
      case None => Right(true)
    }
}
