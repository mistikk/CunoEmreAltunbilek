package com.cuneytyilmaz.projeler;

import com.cuneytyilmaz.projeler.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore.Audio.Media;

public class HosgeldinEkrani extends Activity{
	MediaPlayer muzik;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hosgeldin);
		muzik = MediaPlayer.create(HosgeldinEkrani.this, R.raw.gun);
		SharedPreferences ayarlariCek = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		
		boolean muzikDurumu = ayarlariCek.getBoolean("cbpMuzik",true);
		
		if (muzikDurumu) {
			muzik.start();
		}	
		
		Thread zaman = new Thread(){

			@Override
			public void run() {
				super.run();
				
				try {
					sleep(3500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					Intent sayfa = new Intent("android.intent.action.MENU");
					startActivity(sayfa);			
				}								
			}		
			
		};
		
		zaman.start();
	}

	protected void onPause() {
		super.onPause();
		muzik.release();
		finish();
	}
}
