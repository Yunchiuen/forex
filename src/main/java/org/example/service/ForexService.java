package org.example.service;

import org.example.bean.Forex;

import java.util.List;
import java.util.Map;

public interface ForexService {
    public void processObtain();

    public Forex processSave(Forex forex);

    public List<Map<String, String>> processQuery(String startDate, String endDate, String currency);
}
