package com.example.memo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.memo.responce.ErrorFlash;
import com.example.memo.responce.Memo;
import com.example.memo.responce.MemoForm;
import com.example.memo.responce.MemoList;
import com.example.memo.service.MemoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestBody;


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

    @PostMapping("/add")
    public String addMemo(@ModelAttribute("MemoForm") MemoForm form, RedirectAttributes redirAttrs, Model model) {
        Memo memo = new Memo();

        // タイトルが設定されていなかった場合エラーメッセージを渡す
        if (form.getTitle().equals("")) {
            ErrorFlash flash = new ErrorFlash("noValueError", "タイトルが入力されていません");
            redirAttrs.addFlashAttribute("flash", flash);

            return "redirect:/add";
        }

        memo.setTitle(form.getTitle());
        memo.setText(form.getText());

        memoService.createMemo(memo);

        return "redirect:/";
    }

    @GetMapping("/memo")
    public String memo(@RequestParam String id, Model model) {
        Memo memo = memoService.getMemobyId(id);
        model.addAttribute("memo", memo);

        return "memo";
    }

    @GetMapping("/edit")
    public String editMemo(@RequestParam String id, Model model) {
        Memo memo = memoService.getMemobyId(id);
        model.addAttribute("memo", memo);

        return "edit";
    }

    @PostMapping("/edit")
    public String updateMemo(@RequestBody String id) {
        return "redirect:/";
    }


}
