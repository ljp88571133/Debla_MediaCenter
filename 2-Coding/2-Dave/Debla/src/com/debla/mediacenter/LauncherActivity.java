package com.debla.mediacenter;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * 启动界面
 * @author Cocoonshu
 * @date   2014-10-18 12:58:22
 */
public class LauncherActivity extends Activity {

	private Handler   mHdrAnimationHandler   = null;
	private ImageView mIgvAppLogoOuter       = null;
	private ImageView mIgvAppLogoInner       = null;
	private ImageView mIgvCompanyLogo        = null;
	private Animation mAnmAppLogoOuterFadeIn = null;
	private Animation mAnmAppLogoInnerFadeIn = null;
	private Animation mAnmCompanyLogoFadeIn  = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        
        initializeControls();
        initializeAnimations();
        initializeComponents();
        executeAnimations();
    }

    @Override
    protected void onResume() {
    	super.onResume();
    	
    	redirectByIntent();
    }
    
    /**
     * 通过Intent来定向需要跳转的界面
     */
	private void redirectByIntent() {
		Intent intent = getIntent();
		if (intent != null) {
			// 处理Intent
		}
	}

	private void initializeAnimations() {
		mAnmAppLogoOuterFadeIn = AnimationUtils.loadAnimation(LauncherActivity.this, R.anim.app_logo_outer_fade_in);
		mAnmAppLogoInnerFadeIn = AnimationUtils.loadAnimation(LauncherActivity.this, R.anim.app_logo_inner_fade_in);
		mAnmCompanyLogoFadeIn  = AnimationUtils.loadAnimation(LauncherActivity.this, R.anim.company_logo_fade_in);
	}

	private void initializeControls() {
		mIgvAppLogoOuter = (ImageView) findViewById(R.id.ImageViewAppLogoOuter);
		mIgvAppLogoInner = (ImageView) findViewById(R.id.ImageViewAppLogoInner);
		mIgvCompanyLogo  = (ImageView) findViewById(R.id.ImageViewCompanyLogo);
	}

	private void initializeComponents() {
		mHdrAnimationHandler = new Handler(getMainLooper());
	}
	
	/**
	 * 执行启动动画
	 */
	private void executeAnimations() {
		if (mHdrAnimationHandler != null) {
			mHdrAnimationHandler.post(new Runnable() {
				
				@Override
				public void run() {
					mIgvAppLogoOuter.startAnimation(mAnmAppLogoOuterFadeIn);
					mIgvAppLogoInner.startAnimation(mAnmAppLogoInnerFadeIn);
					mIgvCompanyLogo.startAnimation(mAnmCompanyLogoFadeIn);
				}
				
			});
		}
	}
}
