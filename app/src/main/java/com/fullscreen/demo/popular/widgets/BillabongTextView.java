package com.fullscreen.demo.popular.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class BillabongTextView extends TextView {

	public BillabongTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setTypeface(BillabongTypeface.getInstance(context));
	}

}
