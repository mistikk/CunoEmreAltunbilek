package com.cuneytyilmaz.projeler;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Ayarlar extends PreferenceActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.ayar);
	}
}
