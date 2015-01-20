package com.cuneytyilmaz.projeler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Tablar extends Activity implements OnClickListener{
	
	TabHost tabHost;
	Button yeniTabEkle,startButonu,stopButonu;
	TextView sonuclariGoster;
	long start=0,stop,sonuc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tablar);
		
		ilkleme();

		yeniTabEkle.setOnClickListener(this);
		startButonu.setOnClickListener(this);
		stopButonu.setOnClickListener(this);
		
		tabHost.setup();
		
		TabSpec tabOzellikleri;
		tabOzellikleri = tabHost.newTabSpec("tag1");
		tabOzellikleri.setContent(R.id.tab1);
		tabOzellikleri.setIndicator("Kronometre");
		tabHost.addTab(tabOzellikleri);
		
		tabOzellikleri = tabHost.newTabSpec("tag1");
		tabOzellikleri.setContent(R.id.tab2);
		tabOzellikleri.setIndicator("2. Tab");
		tabHost.addTab(tabOzellikleri);
		
		tabOzellikleri = tabHost.newTabSpec("tag1");
		tabOzellikleri.setContent(R.id.tYeniTabEkle);
		tabOzellikleri.setIndicator("Tab Ekle");
		tabHost.addTab(tabOzellikleri);
		
	}

	private void ilkleme() {
		// TODO Auto-generated method stub
		tabHost = (TabHost)findViewById(R.id.tabHost);
		yeniTabEkle = (Button)findViewById(R.id.bYeniTab);
		startButonu = (Button)findViewById(R.id.bStart);
		stopButonu = (Button)findViewById(R.id.bStop);
		sonuclariGoster = (TextView)findViewById(R.id.tvSonuc);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bYeniTab:
			TabSpec yeniTabSpec = tabHost.newTabSpec("tag1");
			yeniTabSpec.setContent(new TabHost.TabContentFactory() {
				
				@Override
				public View createTabContent(String tag) {
					// TODO Auto-generated method stub
					TextView text = new TextView(Tablar.this);
					text.setText("Yeni Tab Oluþtu");
					return text;
				}
			});
			yeniTabSpec.setIndicator("Yeni");
			tabHost.addTab(yeniTabSpec);
			break;
		
		case R.id.bStart:
			start = System.currentTimeMillis();
			break;
		
		case R.id.bStop:
			stop=System.currentTimeMillis();
			
			if (start != 0) {
				sonuc=stop-start;
				int miliSaniye = (int) sonuc;
				int saniye = (int) sonuc/1000;
				int dakika = saniye/60;
				miliSaniye = miliSaniye % 100;
				dakika = dakika % 60;
				
				sonuclariGoster.setText(String.format("%d : %02d : %02d", dakika, saniye, miliSaniye));
			}
			break;

		default:
			break;
		}
	}

}
