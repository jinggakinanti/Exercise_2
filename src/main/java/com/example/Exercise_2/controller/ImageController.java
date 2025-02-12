package com.example.Exercise_2.controller;

import com.example.Exercise_2.entity.Image;
import com.example.Exercise_2.model.BaseResponse;
import com.example.Exercise_2.service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @GetMapping(value = "/image")
    public ResponseEntity<BaseResponse<List<Image>>> getImage(){
        try{
            List<Image> img = imageService.getImage();
            var responseBody = BaseResponse.<List<Image>>builder().data(img)
                    .status(HttpStatus.OK.name())
                    .message("Displaying all images")
                    .build();
            return ResponseEntity.ok(responseBody);
        }
        catch (Exception e){
            var badResponseBody = BaseResponse.<List<Image>>builder()
                    .message(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST.name())
                    .build();
            return ResponseEntity.badRequest().body(badResponseBody);
        }
    }
    @GetMapping(value = "/image/{id}")
    public ResponseEntity<BaseResponse<Image>> getById(@PathVariable String id){
        try{
            Image img = imageService.getById(id);
            var responseBody = BaseResponse.<Image>builder().data(img)
                    .status(HttpStatus.OK.name())
                    .message("Displaying image based on id provided")
                    .build();
            return ResponseEntity.ok(responseBody);
        }
        catch (Exception e){
            var badResponseBody = BaseResponse.<Image>builder()
                    .message(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST.name())
                    .build();
            return ResponseEntity.badRequest().body(badResponseBody);
        }
    }
    @PostMapping(value = "/image")
    public ResponseEntity<BaseResponse<Image>> postImage(@RequestParam(required = false) String id, String url){
        try{
            Image img = imageService.postImage(id, url);
            var responseBody = BaseResponse.<Image>builder().data(img)
                    .status(HttpStatus.OK.name())
                    .message("Successfully posted image")
                    .build();
            return ResponseEntity.ok(responseBody);
        }
        catch (Exception e){
            var badResponseBody = BaseResponse.<Image>builder()
                    .message(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST.name())
                    .build();
            return ResponseEntity.badRequest().body(badResponseBody);
        }
    }
    @DeleteMapping(value = "/image") //string
    public ResponseEntity<BaseResponse<String>> deleteImage(){
        try{
            imageService.deleteImage();
            var responseBody = BaseResponse.<String>builder()
                    .status(HttpStatus.OK.name())
                    .message("Successfully deleted all images")
                    .build();
            return ResponseEntity.ok(responseBody);
        }
        catch (Exception e){
            var badResponseBody = BaseResponse.<String>builder()
                    .message(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST.name())
                    .build();
            return ResponseEntity.badRequest().body(badResponseBody);
        }
    }
}
