package com.kite.wealfyservice.entity

import java.time.LocalDateTime

//import com.kite.wealfyservice.entity.ScalaJPA.{GeneratedValue, Id, JoinColumn, ManyToOne}
//import javax.persistence.{Entity, FetchType, GenerationType, Table}
import java.lang.{Boolean, Double, Long}

import scala.beans.BeanProperty

//@Entity
//@Table(name = "action", schema = "wealfy")
class ActionDto(
  //@Id
  //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wealfy.s_action")
  //@BeanProperty
  var id: Long,

  //@BeanProperty
  var info: String,

  //@BeanProperty
  var summ: Double,

  //@BeanProperty
  var createdDate: LocalDateTime,

  //@JoinColumn(name = "category_id")
  //@ManyToOne(fetch = FetchType.EAGER)
  //@BeanProperty
  var category: Category,

  //@BeanProperty
  var income: Boolean) {

  def this() = this(null, null, null, null, null, null)

}

object ActionDto {
  def apply(
     id: Long, info: String, summ: Double, createdDate: LocalDateTime, category: Category, income: Boolean): ActionDto =
    new ActionDto(id, info, summ, createdDate, category, income)

  def unapply(arg: ActionDto): Option[(Long, String, Double, LocalDateTime, Category, Boolean)] =
    Some((arg.id, arg.info, arg.summ, arg.createdDate, arg.category, arg.income))

}
