package org.example;

import org.awaitility.Duration;
import org.example.batch.DailyBatchJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BatchProcessorTest {

    @SpyBean
    private DailyBatchJob dailyBatchJob;

//    @SpyBean
//    private ForexService forexService;
    @Test
    public void testProcessBatch() {

        //等待最多 2 分鐘的時間內，確認 dailyBatchJob 物件的 executeBatchJob() 方法被正確地執行了一次。
        await().atMost(Duration.TWO_MINUTES)
                .untilAsserted(() -> verify(dailyBatchJob, times(1)).executeBatchJob());

//        verify(forexService, times(1)).processObtain();
    }


}
