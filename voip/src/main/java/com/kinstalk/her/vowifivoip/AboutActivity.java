package com.kinstalk.her.vowifivoip;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.juphoon.rcs.utils.JRCommonUtils;


public class AboutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
//		String versionCode = JRCommonUtils.getVersionCode(this);
		String version = JRCommonUtils.getVersionName(this);
		((TextView)findViewById(R.id.textView_version)).setText(String.format(getString(R.string.about_version_num), version));
	}

	public void onClickAbout(View v) {
	    onBackPressed();
	}

}
