package com.cuneytyilmaz.projeler;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPrefs extends Activity implements OnClickListener {

	Button kaydet, getir;
	EditText kaydedilecekVeri;
	TextView ekranaYaz;
	SharedPreferences paylasilanTercihler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreference);

		ilkleme();
		
		paylasilanTercihler = getSharedPreferences("verilerim", MODE_PRIVATE);
	}

	private void ilkleme() {
		// TODO Auto-generated method stub

		kaydet = (Button) findViewById(R.id.bKaydet);
		getir = (Button) findViewById(R.id.bGetir);
		kaydedilecekVeri = (EditText) findViewById(R.id.etVeri);
		ekranaYaz = (TextView) findViewById(R.id.tvYaz);

		kaydet.setOnClickListener(this);
		getir.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bKaydet:
			String gelenVeri = kaydedilecekVeri.getText().toString();
			SharedPreferences.Editor editorum = paylasilanTercihler.edit();
			
			editorum.putString("stringVerisi", gelenVeri);
			editorum.commit();
			break;
		case R.id.bGetir:

			paylasilanTercihler = getSharedPreferences("verilerim", MODE_PRIVATE);
			String okunanVeri="";
			okunanVeri = paylasilanTercihler.getString("stringVerisi", "VeriBulunamadý");
			ekranaYaz.setText(okunanVeri);
			break;

		}

	}

}
