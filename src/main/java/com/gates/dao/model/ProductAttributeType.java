package com.gates.dao.model;

public enum ProductAttributeType {
	TEXT_VALUE(0 ,"Elle değer girilecek" ),
	OPTIONAL_VALUE(1, "Seçmeli değer");
	
	private int value;
	private String description;
	
	private ProductAttributeType(int value, String description) {
		this.value = value;
		this.description = description;
		
	}
	
	public int getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}


}
