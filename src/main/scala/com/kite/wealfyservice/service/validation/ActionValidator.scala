package com.kite.wealfyservice.service.validation

import com.kite.wealfyservice.entity.ActionDto
import com.kite.wealfyservice.repository.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ActionValidator @Autowired() (private val categoryRepository: CategoryRepository)
  extends EntityValidator[ActionDto] {
  private val rules = Map(
    "Info should not be empty" -> { a: ActionDto => a.info != null && !a.info.isEmpty },
    "Created date should be present" -> { a: ActionDto => a.createdDate != null },
    "Valid category should be set" -> { a: ActionDto => a.income ||
        (a.category != null && categoryRepository.findById(a.category.id).isPresent) }
  )

  override def validate(entity: ActionDto): Either[String, Boolean] =
    rules
      .filterNot(r => r._2(entity))
      .keys
      .reduceOption(_ + ". " + _) match {
      case Some(message) => Left(s"Action invalid: $message")
      case None => Right(true)
    }
}
