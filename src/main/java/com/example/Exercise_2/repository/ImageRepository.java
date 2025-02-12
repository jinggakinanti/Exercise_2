package com.example.Exercise_2.repository;

import com.example.Exercise_2.entity.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ImageRepository extends MongoRepository<Image, String> {
    List<Image> findAll ();
    Image save (Image image);
    Boolean existsByUrl (String url);
    Image getById (String id);
    void deleteAll ();
}
