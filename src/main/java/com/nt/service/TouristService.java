package com.nt.service;

import java.util.List;

import com.nt.entity.Tourist;
import com.nt.error.TouristNotFoundException;

public interface TouristService {

	public String registerTourist(Tourist tourist);
	
	public List<Tourist> showAllTourist();
	
	public List<Tourist> serachByBudgetRange(double start,double end);
	
	public Tourist showTouristById(int id)throws TouristNotFoundException;
	
	public String updateTourist(Tourist tourist);
	
	public String updateTouristBudget(int id,float percentage);
	
	public String removeTouritByid(int id);
	
	public String removeTouritByPackageType(String type);

}
