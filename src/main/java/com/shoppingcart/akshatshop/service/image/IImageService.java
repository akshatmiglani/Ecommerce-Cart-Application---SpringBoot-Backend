package com.shoppingcart.akshatshop.service.image;

import com.shoppingcart.akshatshop.DTO.ImageDto;
import com.shoppingcart.akshatshop.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {

    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto> saveImage(List<MultipartFile> files, Long productId);
    void updateImage(MultipartFile file, Long imageId);
}
