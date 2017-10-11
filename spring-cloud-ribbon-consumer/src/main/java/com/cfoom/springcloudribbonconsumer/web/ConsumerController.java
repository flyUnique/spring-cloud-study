package com.cfoom.springcloudribbonconsumer.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cfoom.springcloudribbonconsumer.service.DemoService;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/ribbon-consumer")
    public String helloConsumer() {
        return demoService.hello();
    }

    @GetMapping("find")
    public String find(Integer id) {
        return demoService.find(id);
    }

    @GetMapping("findList")
    public List<String> findList(List<Integer> idList) {
        return demoService.findList(idList);
    }

}
