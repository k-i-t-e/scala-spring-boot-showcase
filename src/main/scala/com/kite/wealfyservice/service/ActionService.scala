package com.kite.wealfyservice.service

import com.kite.wealfyservice.entity.ActionDto
import com.kite.wealfyservice.repository.ActionRepository
import com.kite.wealfyservice.service.validation.EntityValidator
import com.kite.wealfyservice.util.Validating
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import scala.jdk.CollectionConverters._

@Service
class ActionService @Autowired() (
    private val actionRepository: ActionRepository,
    private implicit val actionValidator: EntityValidator[ActionDto]
  ) extends Validating {

  @Transactional
  def createAction(action: ActionDto): ActionDto = withValid(action) {
    actionRepository.save(action)
  }

  def loadAll(): Iterable[ActionDto] = actionRepository.findAll().asScala
}
