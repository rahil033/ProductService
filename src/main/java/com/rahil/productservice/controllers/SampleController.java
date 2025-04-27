package com.rahil.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping()
public class SampleController {
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String xyz) {
        return "Hey World " + xyz;
    }
}
