package com.cuneytyilmaz.projeler;

import com.cuneytyilmaz.projeler.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	boolean kapat=false;
	int sonuc=0;
	Button ekle,cikar;
	TextView txt;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ilkleme();
        
        ekle.setOnClickListener(this);   
        cikar.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void ilkleme(){
        ekle = (Button) findViewById(R.id.bEkle);
        cikar = (Button) findViewById(R.id.bCikar);
        txt = (TextView) findViewById(R.id.tvSonuc); 	
    }


	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bEkle :
			sonuc=sonuc+1;
			txt.setText("Sonuç = "+sonuc);
			break;
			
		case R.id.bCikar :
			sonuc=sonuc-1;
			txt.setText("Sonuç = "+sonuc);
			break;
		}	
	}	
    
}
