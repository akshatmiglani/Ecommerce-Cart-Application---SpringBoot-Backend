package com.shoppingcart.akshatshop.repository;

import com.shoppingcart.akshatshop.model.Category;
import com.shoppingcart.akshatshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findByName(String name);

    boolean existsByName(String name);
}
