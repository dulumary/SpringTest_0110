package com.marondal.spring.test.jstl.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.marondal.spring.test.jstl.dao.WeatherHistoryDAO;
import com.marondal.spring.test.jstl.model.WeatherHistory;

@Service
public class WeatherHistoryBO {
	
	@Autowired
	private WeatherHistoryDAO weatherHistoryDAO;
	
	// weatherhistory 의 모든 데이터 조회
	public List<WeatherHistory> getWeatherHistory() {
		return weatherHistoryDAO.selectWeatherHistory();
	}
	
	public int addWeather(
			String date
			, String weather
			, double temperatures
			, double precipitation
			, String microDust
			, double windSpeed) {
		
		return weatherHistoryDAO.insertWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		
	}

}
