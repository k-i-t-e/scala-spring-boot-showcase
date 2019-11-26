package com.kite.wealfyservice.service

import com.kite.wealfyservice.entity.Category
import com.kite.wealfyservice.repository.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import scala.jdk.CollectionConverters._

@Service
class CategoryService @Autowired() (private val categoryRepository: CategoryRepository) {
  def loadAll(): Iterable[Category] = categoryRepository.findAll().asScala

  @Transactional
  def createCategory(category: Category): Category = categoryRepository.save(category)
}
