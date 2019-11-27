package com.kite.wealfyservice.repository

import com.kite.wealfy.jooq.tables.Action.ACTION
import com.kite.wealfy.jooq.tables.Category._
import com.kite.wealfyservice.entity.{ActionDto, Category}
import org.jooq.DSLContext
import org.jooq.scalaextensions.Conversions._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

import scala.jdk.CollectionConverters._

@Repository
class ActionDao @Autowired() (private val DSLContext: DSLContext){
  def findAll(): Iterable[ActionDto] = (DSLContext

      select (
        ACTION.ID,
        ACTION.INFO,
        ACTION.SUMM,
        ACTION.CREATED_DATE,
        ACTION.INCOME,

        CATEGORY.ID,
        CATEGORY.NAME,
        CATEGORY.COLOR
      )
      from
        ACTION
        join CATEGORY
          on ACTION.CATEGORY_ID === CATEGORY.ID

    ).fetch(r => ActionDto(
        id = r.get(ACTION.ID).toLong,
        info = r.get(ACTION.INFO),
        summ = r.get(ACTION.SUMM).toDouble,
        createdDate = r.get(ACTION.CREATED_DATE).toLocalDateTime,
        category = Category(
          r.get(CATEGORY.ID).toLong,
          r.get(CATEGORY.NAME),
          r.get(CATEGORY.COLOR)
        ),
        income = r.get(ACTION.INCOME).booleanValue))

  def save(actionDto: ActionDto): ActionDto = {
    DSLContext.insertInto(ACTION).columns().values().execute()
  }

  private implicit def toScala[T](javaList: java.util.List[T]): Iterable[T] = javaList.asScala
}
