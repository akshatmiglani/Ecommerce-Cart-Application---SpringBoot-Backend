package com.shoppingcart.akshatshop.service.user;

import com.shoppingcart.akshatshop.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    boolean saveNewUser(User user);

    void saveAdmin(User user);

    void saveUser(User user);

    List<User> getAll();

    Optional<User> findById(Long id);

    User findByUserName(String username);
}
