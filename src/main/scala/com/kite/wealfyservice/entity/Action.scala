package com.kite.wealfyservice.entity

import java.time.LocalDateTime

case class Action(
  id: Long,
  info: String,
  summ: Double,
  createdDate: LocalDateTime,
  category: Category,
  income: Boolean)
