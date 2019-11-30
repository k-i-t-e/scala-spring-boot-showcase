package com.kite.wealfyservice.controller

import com.kite.wealfyservice.entity.Action
import com.kite.wealfyservice.service.ActionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, PostMapping, RequestBody, RequestMapping, RestController}

@RestController
@RequestMapping(Array("/action"))
class ActionController @Autowired() (private val actionService: ActionService) {
  @PostMapping
  def createAction(@RequestBody action: Action): Action = actionService.createAction(action)

  @GetMapping
  def getActions: Iterable[Action] = actionService.loadAll()
}
