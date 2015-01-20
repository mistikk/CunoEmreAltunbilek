package com.cuneytyilmaz.projeler;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

public class Slider extends Activity implements OnClickListener, OnCheckedChangeListener, OnDrawerOpenListener {

	Button ac, kapat, degistir;
	CheckBox kilitle;
	SlidingDrawer slider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sliding);
		
		ilkleme();
		
		ac.setOnClickListener(this);
		kapat.setOnClickListener(this);
		degistir.setOnClickListener(this);
		
		kilitle.setOnCheckedChangeListener(this);
		
		slider.setOnDrawerOpenListener(this);
	}

	private void ilkleme() {
		// TODO Auto-generated method stub
		ac = (Button) findViewById(R.id.bAc);
		kapat = (Button) findViewById(R.id.bKapat);
		degistir = (Button) findViewById(R.id.bDegistir);
		kilitle = (CheckBox) findViewById(R.id.cbKilitle);
		slider = (SlidingDrawer) findViewById(R.id.sdSlider);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bAc:
			slider.open();
			break;
		case R.id.bKapat:
			slider.close();
			break;
		case R.id.bDegistir:
			slider.toggle();
			break;

		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		if (kilitle.isChecked()) {
			slider.lock();
		}else{
			slider.unlock();
		}
	}

	@Override
	public void onDrawerOpened() {
		// TODO Auto-generated method stub
		MediaPlayer cal = MediaPlayer.create(this, R.raw.pop);
		cal.start();
	}

}
