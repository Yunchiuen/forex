package org.example.controller;

import org.example.service.ForexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {

    @Autowired
    private ForexService forexService;

    @GetMapping("/hi")
    public String Hi() {
        forexService.processAllSave();
        return "Hi";
    }

}
