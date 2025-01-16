package com.shoppingcart.akshatshop.DTO;

import com.shoppingcart.akshatshop.model.Category;
import com.shoppingcart.akshatshop.model.Image;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int inventory;
    private String brand;
    private Category category;
    private List<ImageDto> images;

}
