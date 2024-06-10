package com.jrpbjr.catproduct.controllers;

import com.jrpbjr.catproduct.domain.category.Category;
import com.jrpbjr.catproduct.domain.category.CategoryDTO;
import com.jrpbjr.catproduct.domain.product.Product;
import com.jrpbjr.catproduct.domain.product.ProductDTO;
import com.jrpbjr.catproduct.services.CategoryService;
import com.jrpbjr.catproduct.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDTO productData){
        Product newProduct = this.service.insert(productData);
        return ResponseEntity.ok().body(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = this.service.getAll();
        return ResponseEntity.ok().body(products);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") String id, @RequestBody ProductDTO productData){
        Product updatedproduct = this.service.update(id, productData);
        return ResponseEntity.ok().body(updatedproduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable("id") String id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
