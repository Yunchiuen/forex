package org.example;

import org.example.Repository.ForexRepository;
import org.example.bean.Forex;
import org.example.service.ForexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ForexTest {
    @Autowired
    private ForexService forexService;

    @MockBean
    private ForexRepository forexRepository;

    @Test
    public void testInsert() {
        Forex forex = new Forex();
        forex.setDate("20240401");
        forex.setUSD_NTD("40.575");

        List<Map<String, Object>> list = new ArrayList<>();
        //  forexRepository.insert(forex) 的回傳結果
        Mockito.when(forexRepository.insert(forex)).thenReturn(forex);

        // 實際呼叫操作forexService.processSave
        Forex actual = forexService.processSave(forex);

        // 預期與實際的資料
        assertEquals(forex, actual);
    }

}
