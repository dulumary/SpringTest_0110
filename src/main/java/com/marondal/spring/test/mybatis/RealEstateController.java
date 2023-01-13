package com.marondal.spring.test.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.mybatis.bo.RealEstateBO;
import com.marondal.spring.test.mybatis.model.RealEstate;

@Controller
@RequestMapping("/mybatis/test01")
public class RealEstateController {
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	// id를 리퀘스트 파라미터로 전달 받고, 조회결과를 json으로 response에 담는다.
	@RequestMapping("/1")
	@ResponseBody
	public RealEstate realEstate(@RequestParam("id") int id) {
		RealEstate realEstate = realEstateBO.getRealEstate(id);
		
		return realEstate;
		
	}
	
	// 전달된 월세 보다 낮은 매물 리스트 json으로 response 담는다.
	@RequestMapping("/2")
	@ResponseBody
	public List<RealEstate> realEstateByRent(@RequestParam("rent") int rentPrice) {
		
		List<RealEstate> realEstateList = realEstateBO.getRealEstateListByRent(rentPrice);
		
		return realEstateList;
	}
	
	
	// 넓이와 매매 가격을 전달 받고, 이에 상응하는 리스트를 json으로 response에 담는다.
	@RequestMapping("/3")
	@ResponseBody
	public List<RealEstate> realEstateByAreaPrice(
			@RequestParam("area") int area 
			, @RequestParam("price") int price) {
		
		 return realEstateBO.getRealEstateListByAreaPrice(area, price);
		
	}
	
	
	
	
	
	
	

}
