package com.youtube.SuperMarketApp.controller;
import com.youtube.SuperMarketApp.entity.ImageModel;
import com.youtube.SuperMarketApp.entity.Product;
import com.youtube.SuperMarketApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(value = {"/addNewProduct"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Product addNewProduct(@RequestPart("product") Product product,
                                 @RequestPart("imageFile")MultipartFile[] file){
        //   return productService.addNewProduct(product);

        try{
            Set<ImageModel> images=uploadImage(file);
            product.setProductImages(images);
            return productService.addNewProduct(product);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;

        }



    }

    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels=new HashSet<>();

        for(MultipartFile file: multipartFiles){
            ImageModel imageModel= new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModels.add(imageModel);
        }

        return imageModels;
    }
}

