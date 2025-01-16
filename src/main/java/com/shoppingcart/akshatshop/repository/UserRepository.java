package com.shoppingcart.akshatshop.repository;

import com.shoppingcart.akshatshop.model.Cart;
import com.shoppingcart.akshatshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByuserName(String username);

}
