package org.example.controller;

import org.example.bean.ERROR;
import org.example.bean.Failed;
import org.example.bean.Result;
import org.example.bean.Success;
import org.example.service.ForexService;
import org.example.util.Verification;
import org.example.util.VerificationCurrency;
import org.example.util.VerificationDate;
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

    private VerificationDate verificationDate;

    private VerificationCurrency verificationCurrency;

    @GetMapping("/Save")
    public String save() {
        forexService.processObtain();
        return "Save";
    }

    @PostMapping("/query")
    public ResponseEntity<Result> query(String startDate, String endDate, String currency) {
//            "startDate": "2024/01/01" , "endDate": "2024/01/01" , " currency ": "RMB/NTD"
        ERROR error = verification.validate(startDate,  endDate,  currency);
        String code = error.getCode();
        String message = error.getMessage();
        if(!"0000".equals(error.getCode())){
            return new ResponseEntity<>(new Failed(code, message), HttpStatus.BAD_REQUEST);
        }

        List<Map<String,String>> dataList = forexService.processQuery(startDate.replace("/" , ""), endDate.replace("/" , ""), currency);
        Success success = new Success<List>(dataList);
        return new ResponseEntity<>(success, HttpStatus.OK);
    }
}
