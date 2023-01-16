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
	
	
	// 객체를 기반으로 한행을 저장하는 기능
	public int addRealEstateByObject(RealEstate realEstate) {
		
		return realEstateDAO.insertRealEstateByObject(realEstate);
		
	}
	
	// 저장할 값을 모두 전달 받고 저장하는 기능 
	public int addRealEstate(
			int realtorId
			, String address
			, int area
			, String type
			, int price
			, int rentPrice) {
		
		return realEstateDAO.insertRealEstate(realtorId, address, area, type, price, rentPrice);
		
		
	}
	
	
	// 변경할 대상 id , 변경할 type, 변경할 price
	public int updateRealEstate(int id, String type, int price) {
		return realEstateDAO.updateRealEstate(id, type, price);
		
	}
	
	public int deleteRealEstate(int id) {
		return realEstateDAO.deleteRealEstate(id);
	}
	
	
	
	
	
	

}
