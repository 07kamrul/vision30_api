package com.vision.viewmodel;

public class ApiViewModel extends MasterViewModel {
	private String[] patrolIds;
	private String[] parentUnitIds;
	private String[] routeIds;
	private String[] areaArray;

	public String[] getPatrolIds() {
		return patrolIds;
	}

	public void setPatrolIds(String[] patrolIds) {
		this.patrolIds = patrolIds;
	}

	public String[] getParentUnitIds() {
		return parentUnitIds;
	}

	public void setParentUnitIds(String[] parentUnitIds) {
		this.parentUnitIds = parentUnitIds;
	}

	public String[] getAreaArray() {
		return areaArray;
	}

	public void setAreaArray(String[] areaArray) {
		this.areaArray = areaArray;
	}

	public String[] getRouteIds() {
		return routeIds;
	}

	public void setRouteIds(String[] routeIds) {
		this.routeIds = routeIds;
	}

}
