package com.revature.controllers;

import com.revature.models.Picture;
import com.revature.models.Shop;
import com.revature.services.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PictureController {

    @Autowired
    PictureService ps;


    @GetMapping("/pictures")
    public List<Picture> getAllPictures() {
        return ps.getAllPictures();
    }

    @GetMapping("/picture/{id}")
    public Picture getPictureByID(@PathVariable("id") String id) {
        return ps.getPicture(Integer.parseInt(id));
    }

    @PostMapping(value = "/picture", consumes = "application/json", produces = "application/json")
    public Picture addPicture(@RequestBody Picture p) {
        return ps.addPicture(p);
    }


    @PutMapping(value = "picture/{id}", consumes = "application/json", produces = "application/json")
    public Picture updatePicture(@PathVariable("id") String id, @RequestBody Picture change) {
        change.setPicID(Integer.parseInt(id));
        return ps.updatePicture(change);
    }

    // @Authorized
    @DeleteMapping("picture/{id}")
    public boolean deletePicture(@PathVariable("id") int id) {

        return ps.deletePicture(id);
    }

}
