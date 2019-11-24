package com.kite.wealfyservice.controller

import com.kite.wealfyservice.entity.Category
import com.kite.wealfyservice.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, PostMapping, RequestBody, RequestMapping, RestController}

@RestController
@RequestMapping(Array("/category"))
class CategoryController @Autowired() (private val categoryService: CategoryService) {
  @GetMapping
  def getCategories(): Iterable[Category] = categoryService.loadAll()

  @PostMapping
  def createCategory(@RequestBody category: Category): Category = categoryService.createCategory(category)
}
