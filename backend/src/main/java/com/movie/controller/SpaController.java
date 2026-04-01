package com.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpaController {

    @GetMapping({"/movies", "/search", "/movie/{id}"})
    public String forwardToFrontend() {
        return "forward:/index.html";
    }
}
