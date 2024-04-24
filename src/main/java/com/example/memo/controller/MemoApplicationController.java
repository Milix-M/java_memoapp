package com.example.memo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MemoApplicationController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/add")
    public String addMemo() {
        return "addmemo";
    }

}
