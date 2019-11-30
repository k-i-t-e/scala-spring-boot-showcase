package com.kite.wealfyservice.service

import com.kite.wealfyservice.entity.Category
import com.kite.wealfyservice.repository.CategoryDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CategoryService @Autowired() (private val categoryDao: CategoryDao) {
  def loadAll(): Iterable[Category] = categoryDao.findAll()

  @Transactional
  def createCategory(category: Category): Category = categoryDao.save(category)
}
