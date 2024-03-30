package org.example.controller;

import org.example.service.ForexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {

    @Autowired
    private ForexService forexService;

    @GetMapping("/Save")
    public String Save() {
        forexService.processSave();
        return "Save";
    }

}
