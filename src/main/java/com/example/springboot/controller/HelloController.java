package com.example.springboot.controller;

import com.example.springboot.properties.PersonProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Value("${name}")
    private String name;

    @Autowired
    private PersonProperties personProperties;

    /*
    Controller注解
    @RequestMapping(value = {"/hello","/sayhello"},method = RequestMethod.GET)  //支持多个路径并存
    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    @RequestMapping(value = "/hello",method = RequestMethod.PUT)
    @RequestMapping(value = "/hello",method = RequestMethod.DELETE)
    @RequestMapping(value = "/hello")   //同时支持post和get
    */
/*
    SpringBoot注解
    @GetMapping(value = "/hello")
    @PostMapping(value = "/post")
    @PutMapping(value = "/put")
    @DeleteMapping(value = "/delete")
*/
    @GetMapping(value = "{id}/hello/{name}")
    public String sayId(@PathVariable("id") Integer myId,
                        @PathVariable("name") String name){
        return "myId:" + myId + ", name:" + name;
    }

    @GetMapping(value = "/hello")
    public String sayParam(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myId){
        return "Hello Spring-boot! " +
                "<br/>id:"+ myId +
                "<br/>name:" + name +
                "<br/> " + personProperties.getAge() + ":" + personProperties.getName();
    }
}
