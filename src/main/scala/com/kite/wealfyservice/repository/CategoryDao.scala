package com.kite.wealfyservice.repository

import com.kite.wealfy.jooq.Sequences
import com.kite.wealfy.jooq.tables.Category.CATEGORY
import com.kite.wealfy.jooq.tables.records.CategoryRecord
import com.kite.wealfyservice.entity.Category
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.jooq.scalaextensions.Conversions._
import scala.jdk.OptionConverters._
import org.jooq.impl.DSL.{`val` => value}

import scala.jdk.CollectionConverters._

@Repository
class CategoryDao @Autowired() (private val DSLContext: DSLContext) {
  def findAll(): Iterable[Category] = {
    DSLContext.selectFrom(CATEGORY)
      .fetch(map _)
      .asScala
  }

  private def map(r: CategoryRecord) = Category(r.getId, r.getName, r.getColor)

  def findById(id: Long): Option[Category] = {
    (DSLContext
      selectFrom CATEGORY
      where CATEGORY.ID === id
    ).fetchOptional(map _).toScala
  }

  def save(category: Category): Category = {
    val res = (DSLContext
      insertInto CATEGORY
      columns(CATEGORY.ID, CATEGORY.NAME, CATEGORY.COLOR)
      values(Sequences.S_CATEGORY.nextval(), value(category.name), value(category.color))
      returning CATEGORY.ID
    ).fetchOne()

    category.copy(id = res.component1())
  }
}
