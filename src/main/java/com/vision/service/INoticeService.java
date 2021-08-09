package com.vision.service;

import java.util.List;
import java.util.Map;

import com.vision.model.NoticeModel;
import com.vision.viewmodel.MasterViewModel;

public interface INoticeService {

	public Map<String, Object> getNotice(MasterViewModel viewModel);

	public Map<String, Object> getNoticeByIds(MasterViewModel viewModel);

	public Map<String, Object> addNotice(NoticeModel model, MasterViewModel viewModel);

	public Map<String, Object> addAllNotice(List<NoticeModel> models, MasterViewModel viewModel);

	public Map<String, Object> searchNotice(MasterViewModel viewModel);

	public Map<String, Object> deleteNoticeByIds(MasterViewModel viewModel);

}
