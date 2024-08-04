package com.bini.planify.domain.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author PARK-SU-BIN
 * @version 0.1
 * @since 2024-08-01
 */

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "planify/index";
    }

    @GetMapping("/sign-up")
    public String signUp() {
        return "planify/signup";
    }
}
