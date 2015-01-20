package com.cuneytyilmaz.projeler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InternalData extends Activity implements OnClickListener {

	Button kaydet, getir;
	EditText kaydedilecekVeri;
	TextView ekranaYaz;
	String FILE_NAME = "InternalString";
	FileOutputStream fos;
	FileInputStream fis;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreference);

		ilkleme();
	}

	private void ilkleme() {
		// TODO Auto-generated method stub

		kaydet = (Button) findViewById(R.id.bKaydet);
		getir = (Button) findViewById(R.id.bGetir);
		kaydedilecekVeri = (EditText) findViewById(R.id.etVeri);
		ekranaYaz = (TextView) findViewById(R.id.tvYaz);

		kaydet.setOnClickListener(this);
		getir.setOnClickListener(this);

		try {
			fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bKaydet:
			String kaydedilecekData = kaydedilecekVeri.getText().toString();
			try {
				fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
				fos.write(kaydedilecekData.getBytes());
				fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.bGetir:
			
			new dosyamiOku().execute(FILE_NAME);
			
			break;

		}
	}

	
	public class dosyamiOku extends AsyncTask<String, Integer, String>{

		protected void OnPreExecute(){
			 
		}
		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			
			String dosyadanOkunanVeri = null;
			try {
				fis = openFileInput(FILE_NAME);
				byte[] okunanByteDizisi = new byte[fis.available()];
				
				while (fis.read(okunanByteDizisi)!=-1) {
					dosyadanOkunanVeri = new String(okunanByteDizisi);
					
				}
				fis.close();
				return dosyadanOkunanVeri;
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		};
		
		protected void onProgressUpdate(){
			
		}
		
		protected void onPostExecute(String result){
			ekranaYaz.setText(result);
		}
	}
}
