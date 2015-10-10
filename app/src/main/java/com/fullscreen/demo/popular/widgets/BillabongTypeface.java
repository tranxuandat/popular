package com.fullscreen.demo.popular.widgets;

import android.content.Context;
import android.graphics.Typeface;

public class BillabongTypeface {
	public static Typeface instance;
	public static Typeface getInstance(Context context) {
		if (instance!=null){
			return instance;
		} else {
			instance = Typeface.createFromAsset(context.getAssets(), "font/billabong.ttf");
			return instance;
		}
	}
}
