package com.vision.service;

import java.util.List;
import java.util.Map;

import com.vision.model.SliderModel;
import com.vision.viewmodel.MasterViewModel;

public interface ISliderService {

	public Map<String, Object> getSlider(MasterViewModel viewModel);

	public Map<String, Object> getSliderByIds(MasterViewModel viewModel);

	public Map<String, Object> addSlider(SliderModel model, MasterViewModel viewModel);

	public Map<String, Object> addAllSlider(List<SliderModel> models, MasterViewModel viewModel);

	public Map<String, Object> searchSlider(MasterViewModel viewModel);

	public Map<String, Object> deleteSliderByIds(MasterViewModel viewModel);

}
