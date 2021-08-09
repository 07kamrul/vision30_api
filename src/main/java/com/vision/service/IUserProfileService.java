package com.vision.service;

import java.util.List;
import java.util.Map;

import com.vision.model.UserProfileModel;
import com.vision.viewmodel.MasterViewModel;

public interface IUserProfileService {

	public Map<String, Object> getUserProfile(MasterViewModel viewModel);

	public Map<String, Object> getUserProfileByIds(MasterViewModel viewModel);

	public Map<String, Object> addUserProfile(UserProfileModel model, MasterViewModel viewModel);

	public Map<String, Object> addAllUserProfile(List<UserProfileModel> models, MasterViewModel viewModel);

	public Map<String, Object> searchUserProfile(MasterViewModel viewModel);

	public Map<String, Object> deleteUserProfileByIds(MasterViewModel viewModel);

}
