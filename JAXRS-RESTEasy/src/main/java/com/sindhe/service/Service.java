package com.sindhe.service;

import java.util.List;

import com.sindhe.model.Website;

public interface Service {
	
	public abstract List<Website> getRecordsById(int id);
	public abstract List<Website> getAllRecords();
	public abstract List<Website> deleteById(Long id);
	

}
