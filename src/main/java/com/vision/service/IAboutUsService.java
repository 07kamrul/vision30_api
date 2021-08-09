package com.vision.service;

import java.util.List;
import java.util.Map;

import com.vision.model.AboutUsModel;
import com.vision.viewmodel.MasterViewModel;

public interface IAboutUsService {

	public Map<String, Object> getAboutUs(MasterViewModel viewModel);

	public Map<String, Object> getAboutUsByIds(MasterViewModel viewModel);

	public Map<String, Object> addAboutUs(AboutUsModel model, MasterViewModel viewModel);

	public Map<String, Object> addAllAboutUs(List<AboutUsModel> models, MasterViewModel viewModel);

	public Map<String, Object> searchAboutUs(MasterViewModel viewModel);

	public Map<String, Object> deleteAboutUsByIds(MasterViewModel viewModel);

}
