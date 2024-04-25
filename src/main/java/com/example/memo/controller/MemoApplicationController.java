package com.example.memo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.memo.service.MemoService;


@Controller
public class MemoApplicationController {

    @Autowired
    private MemoService memoService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/add")
    public String addMemo() {
        return "addmemo";
    }

    @GetMapping("/memo")
    public String memo() {
        return "memo";
    }
}
