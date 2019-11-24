package com.kite.wealfyservice.repository

import com.kite.wealfyservice.entity.Category
import org.springframework.data.repository.CrudRepository

trait CategoryRepository extends CrudRepository[Category, Long]
