package com.example.test.controller;

import com.example.test.model.SearchVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    @RequestMapping(value ="/getRequest", method= RequestMethod.GET)
    public String test(){
        return "welcome back";
    }

  /*  @GetMapping("/getParameters")
    public String getParameters(@RequestParam String id, @RequestParam String email){
        return "아이디는 " + id + "이메일은 " + email;
    }*/
    @GetMapping("/getParameters")
    public String getParameters(@RequestParam(name="id") String userId, @RequestParam(name="email") String userEmail){
        return "아이디는 " + userId + "이멜은 " + userEmail;
    }
    @GetMapping("/getMultiParameters")
    public String getMultiParameters(SearchVO searchVO){
        return "VO사용 아이디는 " + searchVO.getId()+"이메일은" + searchVO.getEmail();
    }

    @GetMapping("/getMultiParametersRtnJson")
        public SearchVO getMultiParametersRtnJson(SearchVO searchVo){
        return searchVo;
    }
}

