package com.shoppingcart.akshatshop.service.product;

import com.shoppingcart.akshatshop.DTO.ProductDto;
import com.shoppingcart.akshatshop.model.Product;
import com.shoppingcart.akshatshop.request.AddProductRequest;
import com.shoppingcart.akshatshop.request.ProductUpdateRequest;

import java.util.List;

public interface IProductService {

    Product addProduct(AddProductRequest product);
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(ProductUpdateRequest product, Long productId);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category,String brand);
    List<Product> getProductByName(String name);
    List<Product> getProductsByBrandAndName(String brand, String name);
    Long countProductsByBrandAndName(String brand,String name);


    List<ProductDto> getConvertedProducts(List<Product> products);

    ProductDto convertToDto(Product product);
}
