package com.vision.service;

import java.util.List;
import java.util.Map;

import com.vision.model.AmountModel;
import com.vision.viewmodel.MasterViewModel;

public interface IAmountService{
	
public Map<String, Object> getAmount(MasterViewModel viewModel );
	
public Map<String, Object> getAmountByIds(MasterViewModel viewModel );
	
public Map<String, Object> addAmount(AmountModel model , MasterViewModel viewModel );
	
public Map<String, Object> addAllAmount(List<AmountModel> models , MasterViewModel viewModel );
	
public Map<String, Object> searchAmount(MasterViewModel viewModel );
	
public Map<String, Object> deleteAmountByIds(MasterViewModel viewModel );
	
}
