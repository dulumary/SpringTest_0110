package com.marondal.spring.test.jstl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.marondal.spring.test.jstl.model.WeatherHistory;

@Repository
public interface WeatherHistoryDAO {
	
	public List<WeatherHistory> selectWeatherHistory();

}
