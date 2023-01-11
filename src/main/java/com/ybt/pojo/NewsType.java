package com.ybt.pojo;

public class NewsType {
	private int typeId; // 类型ID
	private String typeName; // 类型名称

	public NewsType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewsType(int typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "NewsType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}

}