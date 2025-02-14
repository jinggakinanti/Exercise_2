package com.example.Exercise_2.service.impl;

import com.example.Exercise_2.entity.Image;
import com.example.Exercise_2.repository.ImageRepository;
import com.example.Exercise_2.service.ImageService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Data
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository repo;

    @Override
    public List<Image> getImage() throws Exception {
        if(repo.findAll().isEmpty()){
            throw new Exception("There is no image to see");
        }
        return repo.findAll();
    }
    @Override
    public Image getById(String id) throws Exception {
        if(id == null){
            throw new Exception("Please input id");
        }
        else if(!repo.existsById(id)){
            throw new Exception("Image with the provided id does not exist");
        }
        return repo.getById(id);
    }
    @Override
    public Image postImage(String id, String url) throws Exception {
        if(url == null){
            throw new Exception("Please input image url");
        }
        else if(repo.existsByUrl(url)){
            throw new Exception("The image already exist");
        }

        Image image = new Image(UUID.randomUUID().toString(), url);
        repo.save(image);
        return image;
    }
    @Override
    public void deleteImage() throws Exception {
        if(repo.findAll().isEmpty()){
            throw new Exception("No image to delete");
        }
        repo.deleteAll();
    }
    @Override
    public void deleteById(String id) throws Exception {
        if(id == null){
            throw new Exception("Please input image id");
        }
        else if(!repo.existsById(id)){
            throw new Exception("No image with the given id");
        }
        repo.deleteById(id);
    }
}
