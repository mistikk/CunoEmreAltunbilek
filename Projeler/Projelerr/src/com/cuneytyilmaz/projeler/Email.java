package com.cuneytyilmaz.projeler;

import com.cuneytyilmaz.projeler.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements OnClickListener{

	EditText alici_mailleri, mail_konusu, alici_adi, mesaj, kapanis_sozu;
	Button gonder;
	String alicilar,konu,adi,strmesaj,kapanis;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.emailgonder);
		ilkleme();
	}

	@Override
	public void onClick(View v) {
		stringCevir();
		String[] mail_adresleri = {alicilar};
		String mail_icerigi = "Merhabalar "+alicilar+"\n Söylemek istediðim bazý þeyler var. Þöyleki : \n"+konu
				+"Umarým düþüncelerime deðer verilir diyor ve mailimi bitiriyorum.\n"+kapanis+"\n Mailin sonu.... ";
		
		Intent yolla = new Intent(android.content.Intent.ACTION_SEND);
		yolla.putExtra(android.content.Intent.EXTRA_EMAIL, mail_adresleri);
		yolla.putExtra(android.content.Intent.EXTRA_SUBJECT, konu);
		yolla.setType("plain/text");
		yolla.putExtra(android.content.Intent.EXTRA_TEXT, mail_icerigi);
		
		startActivity(yolla);
	}

	public void ilkleme(){
		alici_mailleri = (EditText) findViewById(R.id.etAlici);
		mail_konusu = (EditText) findViewById(R.id.etKonu);
		alici_adi = (EditText) findViewById(R.id.etAdi);
		mesaj = (EditText) findViewById(R.id.etMesaj);
		kapanis_sozu = (EditText) findViewById(R.id.etKapanis);
		gonder = (Button) findViewById(R.id.bGonder);
	}
	
	public void stringCevir(){
		alicilar = alici_mailleri.getText().toString();
		konu = mail_konusu.getText().toString();
		adi = alici_adi.getText().toString();
		strmesaj = mesaj.getText().toString();
		kapanis = kapanis_sozu.getText().toString();
	}
}
