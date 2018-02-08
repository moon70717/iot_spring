package com.iot.spring;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Exam {
	/*
	 * 주어진 문자열(공백 없이 쉼표로 구분되어 있음)을 가지고 아래 문제에 대한 프로그램을 작성하세요.
	 * 
	 * 이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌
	 * 
	 * 김씨와 이씨는 각각 몇 명 인가요? "이재영"이란 이름이 몇 번 반복되나요? 중복을 제거한 이름을 출력하세요. 중복을 제거한 이름을
	 * 오름차순으로 정렬하여 출력하세요.
	 * 
	 */
	public static void main(String[]args) {
		String str="이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌";
		String arr[]=str.split(",");
		Map<Integer, String> hList = new TreeMap<Integer, String>();
		int temp=0;
		int temp2=0;
		int temp3=0;
		int temp4=0;
		for(String s:arr) {
			if(s.matches("이.*")) {
				temp++;
			}
			if(s.matches("김.*")) {
				temp2++;
			}
			if(s.matches("이재영")) {
				temp3++;
			}
			if(hList.containsValue(s)) {
				System.out.println(s+"는 중복입니다");
			}
			hList.put(temp4++, s);
		}
		System.out.println("이씨는 "+temp+"명");
		System.out.println("김씨는 "+temp2+"명");
		System.out.println("이재영은 "+temp3+"명");
		System.out.println("정렬");
		String[] ss=new String[hList.size()];
		int i=0;
		for(String s:hList.values()) {
			ss[i++]=s;
		}
		Arrays.sort(ss);
		for(String s:ss){
			System.out.println(s);
		}
	}
}
