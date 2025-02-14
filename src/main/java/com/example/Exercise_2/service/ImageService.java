package com.example.Exercise_2.service;

import com.example.Exercise_2.entity.Image;

import java.util.List;

public interface ImageService {
    List<Image> getImage () throws Exception;
    Image getById (String id) throws Exception;
    Image postImage (String id, String url) throws Exception;
    void deleteImage () throws Exception;
    void deleteById (String id) throws Exception;

}
