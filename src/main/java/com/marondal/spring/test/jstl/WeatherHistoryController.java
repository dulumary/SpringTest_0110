package com.marondal.spring.test.jstl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marondal.spring.test.jstl.bo.WeatherHistoryBO;
import com.marondal.spring.test.jstl.model.WeatherHistory;

@Controller
@RequestMapping("/jstl/weather")
public class WeatherHistoryController {
	
	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	
	@GetMapping("/list")
	public String weatherList(Model model) {
		
		// weatherHistory 리스트를 모델에 추가한다. 
		List<WeatherHistory> weatherHistory = weatherHistoryBO.getWeatherHistory();
		
		model.addAttribute("weatherHitory", weatherHistory);
		
		
		return "jstl/weather/list";
		
	}

}
