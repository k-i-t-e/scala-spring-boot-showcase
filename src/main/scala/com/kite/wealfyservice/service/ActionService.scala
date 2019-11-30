package com.kite.wealfyservice.service

import com.kite.wealfyservice.entity.Action
import com.kite.wealfyservice.repository.ActionDao
import com.kite.wealfyservice.service.validation.EntityValidator
import com.kite.wealfyservice.util.Validating
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ActionService @Autowired() (
    private val actionDao: ActionDao,
    private implicit val actionValidator: EntityValidator[Action]
  ) extends Validating {

  @Transactional
  def createAction(action: Action): Action = withValid(action) {
    actionDao.save(action)
  }

  def loadAll(): Iterable[Action] = actionDao.findAll()
}
