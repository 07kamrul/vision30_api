package com.vision.service;

import java.util.List;
import java.util.Map;

import com.vision.model.TotalCostModel;
import com.vision.viewmodel.MasterViewModel;

public interface ITotalCostService {

	public Map<String, Object> getTotalCost(MasterViewModel viewModel);

	public Map<String, Object> getTotalCostByIds(MasterViewModel viewModel);

	public Map<String, Object> addTotalCost(TotalCostModel model, MasterViewModel viewModel);

	public Map<String, Object> addAllTotalCost(List<TotalCostModel> models, MasterViewModel viewModel);

	public Map<String, Object> searchTotalCost(MasterViewModel viewModel);

	public Map<String, Object> deleteTotalCostByIds(MasterViewModel viewModel);

}
