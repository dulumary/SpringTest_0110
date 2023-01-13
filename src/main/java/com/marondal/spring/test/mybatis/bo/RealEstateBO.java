package com.marondal.spring.test.mybatis.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marondal.spring.test.mybatis.dao.RealEstateDAO;
import com.marondal.spring.test.mybatis.model.RealEstate;

@Service
public class RealEstateBO {
	
	@Autowired
	private RealEstateDAO realEstateDAO;
	
	//전달 받은 id 데이터 조회 리턴
	public RealEstate getRealEstate(int id) {
		RealEstate realEstate = realEstateDAO.selectRealEstate(id);
		
		return realEstate;
	}
	
	
	// 전달 받은 월세 보다 낮은 매물 리스트 리턴
	public List<RealEstate> getRealEstateListByRent(int rentPrice) {
		
		List<RealEstate> realEstateList = realEstateDAO.selectRealEstateByRent(rentPrice);
		
		return realEstateList;
		
	}
	
	public List<RealEstate> getRealEstateListByAreaPrice(int area, int price) {
		return realEstateDAO.selectRealEstateByAreaPrice(area, price);
	}
	
	
	
	

}
