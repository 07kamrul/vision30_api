package com.vision.service;

import java.util.List;
import java.util.Map;

import com.vision.model.VisionModel;
import com.vision.viewmodel.MasterViewModel;

public interface IVisionService {

	public Map<String, Object> getVision(MasterViewModel viewModel);

	public Map<String, Object> getVisionByIds(MasterViewModel viewModel);

	public Map<String, Object> addVision(VisionModel model, MasterViewModel viewModel);

	public Map<String, Object> addAllVision(List<VisionModel> models, MasterViewModel viewModel);

	public Map<String, Object> searchVision(MasterViewModel viewModel);

	public Map<String, Object> deleteVisionByIds(MasterViewModel viewModel);

}
