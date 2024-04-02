package org.example.batch;

import org.example.service.ForexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DailyBatchJob {

    @Autowired
    private ForexService forexService;

    // 每天18:00執行一次
    @Scheduled(cron = "0 0 18 * * ?")
    public void executeBatchJob() {
        System.out.println("批次開始時間：" + java.time.LocalTime.now());
        forexService.processObtain();
        System.out.println("批次結束時間：" + java.time.LocalTime.now());
    }
}
