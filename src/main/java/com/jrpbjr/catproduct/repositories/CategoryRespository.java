package com.jrpbjr.catproduct.repositories;

import com.jrpbjr.catproduct.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRespository extends MongoRepository<Category, String> {

}
