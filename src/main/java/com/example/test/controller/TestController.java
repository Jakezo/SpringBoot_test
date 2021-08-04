package com.example.test.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    @RequestMapping(value ="/getRequest", method= RequestMethod.GET)
    public String test(){
        return "welcome back";
    }

    @GetMapping("/getParameters")
    public String getParameters(@RequestParam String id, @RequestParam String email){
        return "아이디는 " + id + "이메일은 " + email;
    }
}
