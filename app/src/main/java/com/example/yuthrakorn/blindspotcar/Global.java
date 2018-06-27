package com.example.yuthrakorn.blindspotcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.Toast;


public class Global {
	static Global instance;
	static DisplayMetrics displaymetrics;
	static int display_width;
	static int display_height;
	public int เรียงแนวตั้ง = LinearLayout.VERTICAL;
	public int เรียงแนวนอน = LinearLayout.HORIZONTAL;
	public int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
	public int WRAP_CONTENT = LinearLayout.LayoutParams.WRAP_CONTENT;
	public String Host_IP = "";

	// -----------------------------------------------------------
	public static synchronized Global getInstance() {
		// เก็บค่าตัวแปรและฟังชั่นต่างๆในคลาส Global ไว้ที่ instance
		if (instance == null) {
			displaymetrics = new DisplayMetrics();
			instance = new Global();

		}
		// ส่งกลับค่าใน instance เมื่อคลาส Global ถูกเรียกใช้
		return instance;
	}


	// ฟังชั่นส่งค่าตัวแปรที่เก็บความละเอียดหน้าจอ
	public DisplayMetrics getDisplayMetrics() {
		return displaymetrics;
	}

	// -----------------------------------------------------------
	// ฟังชั่นเก็บค่าขนาด กว้าง x สูง ของหน้าจอ
	public void initialResolution() {
		display_width = displaymetrics.widthPixels;
		display_height = displaymetrics.heightPixels;
	}

	// -----------------------------------------------------------
	// ฟังชั่นส่งกลับขนาดตามอัตราส่วนความกว้างหน้าจอ 0-100%
	public int displayWidth(int percent) {
		return (display_width * percent) / 100;
	}

	// -----------------------------------------------------------
	// ฟังชั่นส่งกลับขนาดตามอัตราส่วนความสูงหน้าจอ 0-100%
	public int displayHeight(int percent) {
		return (display_height * percent) / 100;
	}

	// -----------------------------------------------------------
	// ฟังชั่นสร้างฟอร์มเลย์เอ้าท์แบบลิเนีย เต็มจอ
	public LinearLayout newFullScreenLinear(Context context, int Orientation) {
		LinearLayout screen = new LinearLayout(context);
		screen.setLayoutParams(new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.MATCH_PARENT));

		// Orientation = LinearLayout.VERTICAL เรียง object ในแนวตั้ง
		// Orientation = LinearLayout.HORIZONTAL เรียง object ในแนวนอน
		screen.setOrientation(Orientation);

		// ให้ object ในเลย์เอ้าท์อยู่ตรงกลางเริ่มจากด้านบนลงล่าง
		screen.setGravity(Gravity.CENTER | Gravity.TOP);
		return screen;
	}

	// -----------------------------------------------------------
	//
	public LinearLayout เฟรมอ็อบเจ็ค(Context context, int Orientation,
			LinearLayout.LayoutParams size) {
		LinearLayout screen = new LinearLayout(context);
		screen.setLayoutParams(size);

		// Orientation = LinearLayout.VERTICAL เรียง object ในแนวตั้ง
		// Orientation = LinearLayout.HORIZONTAL เรียง object ในแนวนอน
		screen.setOrientation(Orientation);

		return screen;
	}

	//-----------------------------------------------------------
	// ฟังชั่นแสดงข้อความตามสั่ง
	void message(Context context,String message){
		Toast.makeText(context,message, Toast.LENGTH_SHORT).show();
	}

	//-----------------------------------------------------------

	// -----------------------------------------------------------
	// ฟังชั่นเปลี่ยนข้อมูลอินพุทที่อ่านได้เป็นตัวอักษร
	public String getStringFromStream(InputStream datainput) {
		try {
			StringBuilder str = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					datainput));
			String line;
			while ((line = reader.readLine()) != null) {
				str.append(line);
			}
			return str.toString().trim();
		} catch (IOException ex) {

			return "";
		}
	}



}
