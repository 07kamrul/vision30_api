package com.vision.service;

import java.util.List;
import java.util.Map;

import com.vision.model.DepositeModel;
import com.vision.viewmodel.MasterViewModel;

public interface IDepositeService {

	public Map<String, Object> getDeposite(MasterViewModel viewModel);

	public Map<String, Object> getDepositeByIds(MasterViewModel viewModel);

	public Map<String, Object> addDeposite(DepositeModel model, MasterViewModel viewModel);

	public Map<String, Object> addAllDeposite(List<DepositeModel> models, MasterViewModel viewModel);

	public Map<String, Object> searchDeposite(MasterViewModel viewModel);

	public Map<String, Object> deleteDepositeByIds(MasterViewModel viewModel);

}
