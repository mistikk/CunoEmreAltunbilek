package com.cuneytyilmaz.projeler;

import com.cuneytyilmaz.projeler.R;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String siniflar[] = { "MainActivity", "Liste", "TextPlay", "Email",
			"ResimCek", "Slider", "Tablar", "Browser", "Flipper",
			"SharedPrefs", "InternalData","ExternalData" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Full Screen Yapma Methodlarý
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		ArrayAdapter adaptor = new ArrayAdapter(this,
				android.R.layout.simple_list_item_1, siniflar);
		setListAdapter(adaptor);

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String secilen = siniflar[position];
		try {
			Class sinif = Class.forName("com.cuneytyilmaz.projeler." + secilen);
			Intent intent = new Intent(this, sinif);
			startActivity(intent);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater menucu = getMenuInflater();
		menucu.inflate(R.menu.ilk_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case R.id.hakkimizda:
			Intent hakkimizdaIntenti = new Intent(
					"android.intent.action.HAKKIMDA");
			startActivity(hakkimizdaIntenti);
			break;

		case R.id.ayarlar:
			Intent ayarlarIntenti = new Intent("android.intent.action.AYARLAR");
			startActivity(ayarlarIntenti);
			break;

		case R.id.cikis:
			finish();
			break;
		}
		return false;
	}

}
