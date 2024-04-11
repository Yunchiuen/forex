package com.my.batch;

import com.my.service.ForexService;
import com.my.service.impl.ForexServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class DailyBatchJob {
    private static final Logger LOGGER = Logger.getLogger(ForexServiceImpl.class.getName());

    @Autowired
    private ForexService forexService;

    // 每天18:00執行一次
    @Scheduled(cron = "0 0 18 * * ?")
    public void executeBatchJob() {
        LOGGER.info("批次開始時間：" + java.time.LocalTime.now());
        forexService.processObtain();
        LOGGER.info("批次結束時間：" + java.time.LocalTime.now());
    }
}
