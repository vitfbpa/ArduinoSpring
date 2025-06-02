package com.example.ledcontroller.controller;

import com.example.ledcontroller.model.LedLog;
import com.example.ledcontroller.service.LedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LedController {

    @Autowired
    private LedService ledService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("ledOn", ledService.isLedOn());
        model.addAttribute("logs", ledService.getLogs(Sort.by(Sort.Direction.DESC, "timestamp")));
        return "index";
    }

    @PostMapping("/toggle")
    public String toggleLed(Model model) {
        ledService.toggleLed();
        return "redirect:/";
    }

    @PostMapping("/clear")
    public String clearLogs() {
        ledService.clearLogs();
        return "redirect:/";
    }
}