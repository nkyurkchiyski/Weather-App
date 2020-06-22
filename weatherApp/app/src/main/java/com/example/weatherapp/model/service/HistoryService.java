package com.example.weatherapp.model.service;

import com.example.weatherapp.model.uiBean.HistoryUiBean;

import java.util.List;

public interface HistoryService {

    void create(final String city, final String forecastType, final String query);

    List<HistoryUiBean> getAll();

    void delete(final String id);
}
