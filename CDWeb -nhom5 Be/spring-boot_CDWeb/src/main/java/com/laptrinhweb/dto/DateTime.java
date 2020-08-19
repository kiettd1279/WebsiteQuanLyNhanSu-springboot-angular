package com.laptrinhweb.dto;

import java.util.Calendar;

public class DateTime {
	private int date;
	private int time;

	public DateTime() {
	}

	// Nhận Date với đầy đủ giá trị dd mm yy hh mm
	public void setDateTime(int hour, int minute, int day, int month, int year) {
		date += year;
		date = date * 100 + month;
		date = date * 100 + day;

		time = hour * 60 + minute;
	}

	// nhận Date vời 1 chuỗi có định dạng 'mm:hh_dd/MM/YY
	public void setDate(String keywordCut) {
		String[] result = keywordCut.split(" ");
		for (int i = 0; i < result.length; i++) {
		}
		try {
			date = formDate(result[1]);

			time = formTime(result[0]);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public int subtractHours(int nowTime, int lastTime) {
		int hour = nowTime - lastTime;
		return (int) hour / 60;
	}

	public String format() {
		return getHour() + " " + getDay() + "/" + getMonth() + "/" + getYear();
	}

	public int formTime(String time) {
		int timeLate = 0;
		try {
			String[] result = time.split(":");
			timeLate = Integer.parseInt(result[0]) * 60 + Integer.parseInt(result[1]);

		} catch (Exception e) {

		}
		return timeLate;
	}

	public int formDate(String date) {
		String[] result = date.split("/");
		int dateTime = 0;
		try {
			dateTime += Integer.parseInt(result[2]);
			dateTime = dateTime * 100 + Integer.parseInt(result[1]);
			dateTime = dateTime * 100 + Integer.parseInt(result[0]);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return dateTime;
	}

	public int getMonth() {
		int month = this.date / 100;
		return month % 100;
	}

	public int getYear() {
		int year = this.date / 10000;
		return year;
	}

	public int getDay() {
		int day = this.date % 100;
		return day;
	}

	public String getHour() {
		return this.time / 60 + ":" + this.time % 60;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		DateTime date = new DateTime();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		date.setDateTime(hour, minute, day, hour, year);
		String time = date.format();
//		
//		;
//		
//		System.out.println(time);

		DateTime oldDate = new DateTime();
		oldDate.setDate("17:57 18/17/2020");
		System.out.println("old date :" + oldDate.format());
	}

}
