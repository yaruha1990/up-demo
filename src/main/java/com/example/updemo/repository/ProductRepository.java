package com.example.updemo.repository;

import com.example.updemo.domain.product.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    @Query("select p from Product p where p.id = :id")
    Optional<Product> findById(@Param("id") long id);

    @Query("select p from Product p where p.id in(:productIdList)")
    List<Product> findProductsByIds(@Param("productIdList") List<Long> productIdList);

    @Override
    List<Product> findAll();

    @Query("select p from Product p where p.category.id = :categoryId")
    List<Product> findAllByCategoryId(@Param("categoryId") long categoryId);

    @Query("select p from Product p where p.category.name = :category")
    List<Product> findAllByCategoryName(@Param("category") String category);
}
