package com.github.thamvannguyen.controller;


import com.github.thamvannguyen.entity.Category;
import com.github.thamvannguyen.manager.CategoryManagerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class controller {
    @Autowired
    CategoryManagerEntity categoryManagerEntity;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        Category category = new Category("Lunch", "g1.jpg");
        categoryManagerEntity.save(category);
        return "login";
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menu() {
        List<Category> categories = new ArrayList<Category>();
        return "menu";
    }

}
