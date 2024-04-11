package com.my;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.bean.Forex;
import com.my.bean.Success;
import com.my.repository.ForexRepository;
import com.my.service.ForexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ForexTest {
    @MockBean
    private ForexService forexService;

    @MockBean
    private ForexRepository forexRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void testFetchForex() throws Exception {
        List<Map<String, String>> dataList = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("Date", "2024/03/04");
        map.put("USD/NTD", "31.53");
       dataList.add(map);
        //dataList 模擬forexService 回來的資料
        Mockito.when(forexService.processQuery(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
         .thenReturn(dataList);

        //模擬從controller 發送請求
        MockHttpServletRequestBuilder param = MockMvcRequestBuilders.post("/query")
                .accept(MediaType.APPLICATION_JSON)
                .param("startDate", "2024/03/01")
                .param("endDate", "2024/04/11")
                .param("currency", "USD/NTD");

        String result = mockMvc.perform(param)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);

        Success<List<Map<String, String>>> readValue = objectMapper.readValue(result, new TypeReference<Success<List<Map<String, String>>>>() {
        });
        assertEquals(dataList, readValue.getCurrency());
    }


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
