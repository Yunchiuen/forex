package com.my.controller;

import com.my.bean.Error;
import com.my.bean.Failed;
import com.my.bean.Result;
import com.my.bean.Success;
import com.my.service.ForexService;
import com.my.util.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ForexController {

    @Autowired
    private ForexService forexService;

    private Verification verification;

    @GetMapping("/Save")
    public String save() {
        forexService.processObtain();
        return "Save";
    }

    @PostMapping("/query")
    public ResponseEntity<Result> query(String startDate, String endDate, String currency) {
//            "startDate": "2024/01/01" , "endDate": "2024/01/01" , " currency ": "RMB/NTD"
        Failed failed = verification.validate(startDate, endDate, currency);
        String code = failed.getError().getCode();
        if (!"0000".equals(code)) {
            return new ResponseEntity<>(failed, HttpStatus.BAD_REQUEST);
        }

        List<Map<String, String>> dataList = forexService.processQuery(startDate.replace("/", ""), endDate.replace("/", ""), currency);
        Success success = new Success<List>(Error.SUCCESS, dataList);
        return new ResponseEntity<>(success, HttpStatus.OK);
    }
}
