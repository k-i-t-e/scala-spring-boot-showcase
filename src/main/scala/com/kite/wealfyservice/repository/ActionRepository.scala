package com.kite.wealfyservice.repository

import com.kite.wealfyservice.entity.Action
import org.springframework.data.repository.CrudRepository

trait ActionRepository extends CrudRepository[Action, Long]
