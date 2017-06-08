package com.github.thamvannguyen.controller;

import com.github.thamvannguyen.entity.Category;
import com.github.thamvannguyen.manager.CategoryManagerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tham on 6/8/17.
 */
@RestController
public class RestAPI {

    @Autowired
    CategoryManagerEntity categoryManagerEntity;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> listAllUsers() {
        List<Category> categories = categoryManagerEntity.getAll();
        if(categories.isEmpty()){
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }
}
