package com.marondal.spring.test.database.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.marondal.spring.test.database.model.Store;

@Repository
public interface StoreDAO {
	
	// store 테이블 조회 기능
	public List<Store> selectStoreList();

}
