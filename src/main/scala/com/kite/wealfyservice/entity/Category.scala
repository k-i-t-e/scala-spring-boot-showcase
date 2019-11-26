package com.kite.wealfyservice.entity

//import com.kite.wealfyservice.entity.ScalaJPA.{GeneratedValue, Id}
//import javax.persistence.{Entity, GenerationType, Table}
import java.lang.Long

import scala.beans.BeanProperty

//@Entity
//@Table(name = "category", schema = "wealfy")
class Category(
    //@Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wealfy.s_category")
    //@BeanProperty
    var id: Long,
    @BeanProperty var name: String,
    @BeanProperty var color: String) {
  def this() = this(null, null, null)
}
