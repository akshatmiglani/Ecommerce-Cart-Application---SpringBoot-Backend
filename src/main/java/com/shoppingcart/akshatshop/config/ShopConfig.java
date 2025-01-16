package com.shoppingcart.akshatshop.config;

import com.shoppingcart.akshatshop.DTO.ProductDto;
import com.shoppingcart.akshatshop.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
