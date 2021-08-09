package com.vision.util;

import java.util.ArrayList;
import java.util.List;

public class Return <T>{
	private List<String> msgs;
	private Object obj;
	private List<T> dataList;
	private T data;
	
	private Return(Builder<T> builder) {
		this.msgs = builder.msgs;
		this.obj = builder.obj;
		this.dataList = builder.dataList;
		this.data = builder.data;
	}

	public List<String> getMsgs() {
		return msgs;
	}

	public Object getObj() {
		return obj;
	}
	
	public List<T> getDataList() {
		return dataList;
	}

	public T getData() {
		return data;
	}



	public static class Builder<T>{
		private List<String> msgs;
		private Object obj;
		private List<T> dataList;
		private T data;
		
		public Builder<T> msgs(List<String> msgs) {
			this.msgs = msgs;
			return this;
		}
		
		public Builder<T> obj(Object obj) {
			this.obj = obj;
			return this;
		}
		
		public Builder<T> dataList(List<T> dataList) {
			this.dataList = dataList;
			return this;
		}
		
		public Builder<T> data(T data) {
			this.data = data;
			return this;
		}
		
//		public Builder dataList(T extend Objet data) {
//			if(this.msgs == null) this.msgs = new ArrayList<>();
//			this.msgs.add(msg);
//			return this;
//		}
		
		public Builder<T> msgs(String msg) {
			if(this.msgs == null) this.msgs = new ArrayList<>();
			this.msgs.add(msg);
			return this;
		}
		

		public Return<T> build() {
			return new Return<T>(this);
		}
	}
	
	
}
