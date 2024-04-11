package com.my;

import com.my.batch.DailyBatchJob;
import org.awaitility.Duration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BatchProcessorTest {

//    @SpyBean
//    private DailyBatchJob dailyBatchJob;

    @Test
    public void testProcessBatch() {

        DailyBatchJob dailyBatchJob = Mockito.mock(DailyBatchJob.class);

        //等待最多 2 分鐘的時間內，確認 dailyBatchJob 物件的 executeBatchJob() 方法被正確地執行了一次。
        await().atMost(Duration.TWO_MINUTES)
                .untilAsserted(() -> verify(dailyBatchJob, times(1)).executeBatchJob());

    }


}
