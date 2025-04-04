package com.coding404.myweb.controller;

import com.coding404.myweb.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/topic")
public class TopicController {


    @Autowired
    @Qualifier("topicService")
    public TopicService topicService;

    @GetMapping("/topicDetail")
    public String topicDetail(Model model) {

        return "topic/topicDetail";
    }

    @GetMapping("/topicListAll")
    public String topicListAll() {

        return "topic/topicListAll";
    }

    @GetMapping("/topicListMe")
    public String topicListMe(Model model) {
        return "topic/topicListMe";
    }

    @GetMapping("/topicModify")
    public String topicModify(Model model) {
        return "topic/topicModify";
    }

    @GetMapping("topicReg")
    public String topicReg(Model model) {
        return "topic/topicReg";
    }

}
