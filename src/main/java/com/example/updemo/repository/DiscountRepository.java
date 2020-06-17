package com.example.updemo.repository;

import com.example.updemo.domain.discount.Discount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface DiscountRepository extends PagingAndSortingRepository<Discount, Long> {

    @Query("select d from Discount d where d.id = :discountId")
    Discount findDiscountById(@Param("discountId") long discountId);
}
