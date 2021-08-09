package com.vision.service;

import java.util.List;
import java.util.Map;

import com.vision.model.GalleryModel;
import com.vision.viewmodel.MasterViewModel;

public interface IGalleryService {

	public Map<String, Object> getGallery(MasterViewModel viewModel);

	public Map<String, Object> getGalleryByIds(MasterViewModel viewModel);

	public Map<String, Object> addGallery(GalleryModel model, MasterViewModel viewModel);

	public Map<String, Object> addAllGallery(List<GalleryModel> models, MasterViewModel viewModel);

	public Map<String, Object> searchGallery(MasterViewModel viewModel);

	public Map<String, Object> deleteGalleryByIds(MasterViewModel viewModel);

}
