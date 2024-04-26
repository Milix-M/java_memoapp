package com.example.memo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.memo.responce.MemoList;
import com.example.memo.service.MemoService;

@Controller
public class MemoApplicationController {

    @Autowired
    private MemoService memoService;

    @GetMapping("/")
    public String index(Model model) {
        MemoList memoList = new MemoList();
        memoList.setMemoList(memoService.getMemoList());
        model.addAttribute("memolist", memoList);

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
