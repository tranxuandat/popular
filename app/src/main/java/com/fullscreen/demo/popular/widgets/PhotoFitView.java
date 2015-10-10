package com.fullscreen.demo.popular.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class PhotoFitView extends ImageView {

	public PhotoFitView(Context context) {
		super(context);
	}

	public PhotoFitView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public PhotoFitView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		
		Drawable d = getDrawable();
		if(d != null) {
			int width = MeasureSpec.getSize(widthMeasureSpec);
			int height = (int) Math.ceil((float) width * (float) (d.getIntrinsicHeight()) / (float) d.getIntrinsicWidth());
			setMeasuredDimension(width, height);
		} else {
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		}
	}
}
