package mn.infosystems.estimator.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EstimaterStaticFunctions {

	static String mas1[] = {"нэг","хоёр","гурав","дөрөв","тав","зургаа","долоо","найм","ес"};
	static String mas2[] = {"арав","хорь","гуч","дөч","тавь","жар","дал","ная","ер"};
	static String mas3[] = {"нэгэн","хоёр","гурван","дөрвөн","таван","зургаан","долоон","найман","есөн"};
	static String mas6[] = {"нэг","хоёр","гурван","дөрвөн","таван","зургаан","долоон","найман","есөн"};
	static String mas4[] = {"арван","хорин","гучин","дөчин","тавин","жаран","далан","наян","ерэн"};
	static String mas5[] = {" ","зуу","зуун","мяанга","сая"};
	
	public static String dateToStr(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}

	public static Date strToDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatter.parse(date);
		} catch (ParseException e) {
			return null;
		}
	}
	
	
	private static String[] split(String str){
		String[] mas = new String[3];
		int count = 0;
		while(str.length()>3){
			String element = str.substring(str.length()-3, str.length());
			str = str.substring(0, str.length()-3);
			mas[count++] = element;
		}
		if(str.length()>0) mas[count] = str;
		return mas;
	}
	
	private static String fillzero(String s){
		if(s.length()==1) s = "00"+s; else
		if(s.length()==2) s = "0"+s;
		return s;
	}
	
	public static String convertNumberToText(String str){
		String [] massiv = split(str);
		String text = "";
		try{
			char[] arr = fillzero(massiv[2]).toCharArray();
			if(arr[0]!='0'){
				int num = Integer.parseInt(String.valueOf(arr[0]));
				text = text + mas6[num-1] + mas5[0] + mas5[2]; 
			}
			if(arr[1]=='0' && arr[2]=='0') text = text + mas5[0] + mas5[4]; else
			if(arr[1]=='0' && arr[2]!='0') text = text + mas5[0] + mas6[Integer.parseInt(String.valueOf(arr[2]))-1] + mas5[0] + mas5[4]; else
			if(arr[1]!='0' && arr[2]=='0') text = text + mas5[0] + mas4[Integer.parseInt(String.valueOf(arr[1]))-1] + mas5[0] + mas5[4]; else
				text = text + mas5[0] + mas4[Integer.parseInt(String.valueOf(arr[1]))-1] + mas5[0] + mas3[Integer.parseInt(String.valueOf(arr[2]))-1] + mas5[0] + mas5[4];
		}catch(Exception e){}
		
		try{
			text = text + mas5[0];
			char[] arr = fillzero(massiv[1]).toCharArray();
			if(arr[0]!='0'){
				int num = Integer.parseInt(String.valueOf(arr[0]));
				text = text + mas6[num-1] + mas5[0] + mas5[2]; 
			}
			if(arr[0]=='0' && arr[1]=='0' && arr[2]=='0'); else
			if(arr[1]=='0' && arr[2]=='0') text = text + mas5[0] + mas5[3]; else
			if(arr[1]=='0' && arr[2]!='0') text = text + mas5[0] + mas6[Integer.parseInt(String.valueOf(arr[2]))-1] + mas5[0] + mas5[3]; else
			if(arr[1]!='0' && arr[2]=='0') text = text + mas5[0] + mas4[Integer.parseInt(String.valueOf(arr[1]))-1] + mas5[0] + mas5[3]; else
				text = text + mas5[0] + mas4[Integer.parseInt(String.valueOf(arr[1]))-1] + mas5[0] + mas3[Integer.parseInt(String.valueOf(arr[2]))-1] + mas5[0] + mas5[3];
		}catch(Exception e){}
		
		
		try{
			text = text + mas5[0];
			char[] arr = fillzero(massiv[0]).toCharArray();
			if(arr[0]!='0'){
				text = text + mas6[Integer.parseInt(String.valueOf(arr[0]))-1] + mas5[0];
				if(arr[1]=='0' && arr[2]=='0') text = text + mas5[1]; else text = text + mas5[2];
			}
			if(arr[1]=='0' && arr[2]!='0') text = text + mas5[0] + mas1[Integer.parseInt(String.valueOf(arr[2]))-1]; else
			if(arr[1]!='0' && arr[2]=='0') text = text + mas5[0] + mas2[Integer.parseInt(String.valueOf(arr[1]))-1]; else
			text = text + mas5[0] + mas4[Integer.parseInt(String.valueOf(arr[1]))-1] + mas5[0] + mas1[Integer.parseInt(String.valueOf(arr[2]))-1];
		}catch(Exception e){}
		
		return text;
	}
	
}
