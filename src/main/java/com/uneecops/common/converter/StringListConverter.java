package com.uneecops.common.converter;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StringListConverter implements AttributeConverter<List<String>, String> {

	@Override // Here converting List<String> into single string
	public String convertToDatabaseColumn(List<String> attribute) {
		return attribute == null || attribute.isEmpty() ? null : String.join(",", attribute);
	}

	@Override // Here converting available in list(single string) of string in db convert into
				// List<String>
	public List<String> convertToEntityAttribute(String dbData) {
		return (dbData == null || dbData.isEmpty()) ? List.of() : Arrays.asList(dbData.split(","));
	}
}
