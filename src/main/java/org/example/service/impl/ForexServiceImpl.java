package org.example.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Repository.ForexRepository;
import org.example.bean.Forex;
import org.example.service.ForexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ForexServiceImpl implements ForexService {

    @Autowired
    private ForexRepository forexRepository;

    @Override
    public void processObtain() {
        //apiUrl 回應 Content-Type application/octet-stream
        String apiUrl = "https://openapi.taifex.com.tw/v1/DailyForeignExchangeRates";
        //[{"Date":"20240201","USD/NTD":"31.338","RMB/NTD":"4.354697","EUR/USD":"1.0785","USD/JPY":"146.675","GBP/USD":"1.26485","AUD/USD":"0.65215","USD/HKD":"7.81815","USD/RMB":"7.19635","USD/ZAR":"18.75215","NZD/USD":"0.60965"},
        //{"Date":"20240202","USD/NTD":"31.243","RMB/NTD":"4.345151","EUR/USD":"1.0885","USD/JPY":"146.625","GBP/USD":"1.2765","AUD/USD":"0.6594","USD/HKD":"7.8193","USD/RMB":"7.1903","USD/ZAR":"18.60255","NZD/USD":"0.6153"}]
        try {
            URL url = new URL(apiUrl);
            // 打开 URL 連接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 設置請求方法為GET
            connection.setRequestMethod("GET");
            // 發送请求
            connection.connect();

            // 獲取输入流
            InputStream inputStream = connection.getInputStream();
            // 使用 BufferedReader 讀取输入流中的内容
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // 初始化ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            // 使用readValue方法將JSON字串轉換成指定泛型類別
            List<Forex> dataList = objectMapper.readValue(reader, new TypeReference<List<Forex>>() {});

            // 關閉流
            reader.close();
            inputStream.close();

            dataList.forEach(forex -> processSave(forex));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Forex processSave(Forex forex) {
        Forex data = forexRepository.insert(forex);
        System.out.println("insert一筆：" + data);
        return data;
    }

    @Override
    public List<Map<String, String>> processQuery(String startDate, String endDate, String currency) {
        List<Forex> dataList = forexRepository.findForexBetweenDates(startDate, endDate);
        List<Map<String, String>> list = dataList.stream().map(data -> {
            Map<String, String> map = new HashMap<>();
            map.put("Date", data.getDate());
            switch (currency) {
                case "USD/NTD":
                    map.put(currency, data.getUSD_NTD());
                    break;
                case "RMB/NTD":
                    map.put(currency, data.getRMB_NTD());
                    break;
                case "EUR/USD":
                    map.put(currency, data.getEUR_USD());
                    break;
                case "USD/JPY":
                    map.put(currency, data.getUSD_JPY());
                    break;
                case "GBP/USD":
                    map.put(currency, data.getGBP_USD());
                    break;
                case "AUD/USD":
                    map.put(currency, data.getAUD_USD());
                    break;
                case "USD/HKD":
                    map.put(currency, data.getUSD_HKD());
                    break;
                case "USD/RMB":
                    map.put(currency, data.getUSD_RMB());
                    break;
                case "USD/ZAR":
                    map.put(currency, data.getUSD_ZAR());
                    break;
                case "NZD/USD":
                    map.put(currency, data.getNZD_USD());
                    break;
            }
            return map;
        }).collect(Collectors.toList());
        return list;
    }

}
