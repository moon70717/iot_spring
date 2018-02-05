package com.iot.spring.vo;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Test {

	public static void main(String[] args) {
		ObjectMapper om = new ObjectMapper();

		String json = "{\r\n" + "   \"message\":{\r\n" + "      \"@type\":\"response\",\r\n" + "      \"@service\":\"naverservice.labs.api\",\r\n" + "      \"@version\":\"1.0.0\",\r\n" + "      \"result\":{\r\n"
				+ "         \"translatedText\":\"속성 'empSal에 필요한 형식 'int''형식''java.lang.String의 속성 값으로 변환하려고 할;입력 문자열입니다.\\\"A\\\"동안 중첩된 예외는 java.lang.NumberFormatException:지 못 했습니다.\",\r\n" + "         \"srcLangType\":\"en\"\r\n" + "      }\r\n"
				+ "   }\r\n" + "}";

		System.out.println(json);
		try {
			NaverMessage nm = om.readValue(json, NaverMessage.class);
			System.out.println(nm.getMessage().getResult().getTranslatedText());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
