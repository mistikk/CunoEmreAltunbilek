package com.cuneytyilmaz.projeler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ViewFlipper;

public class Flipper extends Activity implements OnClickListener {

	Button geriGit, ÝleriGit, otomatik;
	ViewFlipper flipper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viweflipper);

		ilkleme();
		geriGit.setOnClickListener(this);
		ÝleriGit.setOnClickListener(this);
		otomatik.setOnClickListener(this);
	}

	private void ilkleme() {
		// TODO Auto-generated method stub
		geriGit = (Button) findViewById(R.id.bGeriGit);
		ÝleriGit = (Button) findViewById(R.id.bIleriGit);
		otomatik = (Button) findViewById(R.id.bOtomatik);
		flipper = (ViewFlipper) findViewById(R.id.vfFlipper);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bGeriGit:
			if (flipper.isFlipping()) {
				flipper.stopFlipping();
			}
			flipper.showPrevious();
			break;
		case R.id.bIleriGit:
			if (flipper.isFlipping()) {
				flipper.stopFlipping();
			}
			flipper.showNext();
			break;
		case R.id.bOtomatik:
			flipper.setFlipInterval(2000);
			flipper.startFlipping();
			break;
		}

	}

}
