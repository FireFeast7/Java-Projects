//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.spring_mvc;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {
    public MainController() {
    }

    @RequestMapping(
            value = {"/"},
            method = {RequestMethod.GET}
    )
    public String welcome() {
        return "hello";
    }

    @RequestMapping({"displayName"})
    public String displayName(@RequestParam("firstname") String firstName, Model model ) {
        Date date = new Date();
        List<String> names = new ArrayList<>();
        names.add("Ameya");
        names.add("Ruchi");
        names.add("Loves");
        model.addAttribute("names",names);
        model.addAttribute("dateRN",date);
        model.addAttribute("firstname", firstName);
        return "displayname";
    }
}
