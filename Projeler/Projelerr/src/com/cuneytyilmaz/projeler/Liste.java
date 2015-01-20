package com.cuneytyilmaz.projeler;
import com.cuneytyilmaz.projeler.R;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Liste extends Activity{
	String ulkeler[]={"Turkiye","Ispanya","Fransa","Almanya","Bulgaristan"};
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lliste);
		ListView ulkelerlistesi = (ListView) findViewById(R.id.listeview);
		
		ArrayAdapter<String> adaptor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, ulkeler);
		ulkelerlistesi.setAdapter(adaptor);
		
		OnItemClickListener listener = new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				AlertDialog.Builder diyalog = new AlertDialog.Builder(Liste.this);
				diyalog.setMessage(ulkeler[position]);
				diyalog.setCancelable(false);
				diyalog.setPositiveButton("Tamam", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();
						
					};
				});
				diyalog.create().show();
			}
	};
	ulkelerlistesi.setOnItemClickListener(listener);
}
}
