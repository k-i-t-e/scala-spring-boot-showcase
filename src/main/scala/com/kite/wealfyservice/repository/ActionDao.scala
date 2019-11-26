package com.kite.wealfyservice.repository

import com.kite.wealfy.jooq.Tables
import com.kite.wealfy.jooq.tables.{Action, Category}
import com.kite.wealfy.jooq.tables.Action.ACTION
import com.kite.wealfy.jooq.tables.Category._
import com.kite.wealfy.jooq.tables.records.ActionRecord
import com.kite.wealfyservice.entity.ActionDto

import scala.jdk.CollectionConverters._
import org.jooq._
import org.jooq.impl._
import org.jooq.impl.DSL._
import org.jooq.scalaextensions.Conversions._
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class ActionDao @Autowired() (private val DSLContext: DSLContext){
  def findAll() = {
    val a = (DSLContext
      select (
        ACTION.ID,
        ACTION.INFO,
        ACTION.SUMM,
        ACTION.CREATED_DATE,
        ACTION.INCOME,

        ACTION.CATEGORY_ID
      )
      from ACTION
    ).fetch(r => {
      val a = (ActionDto.apply _).tupled
    })
  }

  def recordToTuple[T1, T2, T3, T4, T5, T6](r: Record6[T1, T2, T3, T4, T5, T6]): (T1, T2, T3, T4, T5, T6) =
    (r.component1(), r.component2(), r.component3(), r.component4(), r.component5(), r.component6())
}
