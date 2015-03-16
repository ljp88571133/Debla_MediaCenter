package com.example.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class HelloActivity extends Activity{
	private ImageView splesh;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_hello);
		
		ImageView logo_com;
		ImageView logo_inner;
		ImageView logo_outer;
		logo_com=(ImageView)this.findViewById(R.id.myImageView);
		logo_inner=(ImageView)this.findViewById(R.id.logo_inner);
		logo_outer=(ImageView)this.findViewById(R.id.logo_outer);
		Animation comAnimation = AnimationUtils.loadAnimation(this, R.anim.com_anim);
		Animation innerAnimation=AnimationUtils.loadAnimation(this, R.anim.logo_inner);
		Animation outerAnimation=AnimationUtils.loadAnimation(this, R.anim.logo_outer);
		logo_inner.startAnimation(innerAnimation);
		logo_com.startAnimation(comAnimation);
		logo_outer.startAnimation(outerAnimation);
	}
	
}
