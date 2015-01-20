package com.cuneytyilmaz.projeler;

import java.util.Random;

import com.cuneytyilmaz.projeler.R;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;


public class TextPlay extends Activity implements OnClickListener{

	EditText etGirilen;
	Button btGonder;
	ToggleButton tbGonder;
	TextView tvYazi;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.textplay);	

		ilkleme();
		
		tbGonder.setOnClickListener(this);
		
		btGonder.setOnClickListener(this);	
		
	}

	public void ilkleme(){
		etGirilen = (EditText) findViewById(R.id.etGirilen);
		btGonder = (Button) findViewById(R.id.bGonder);
		tbGonder = (ToggleButton) findViewById(R.id.tbOff);
		tvYazi = (TextView) findViewById(R.id.tvYazi);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tbOff:
			if (tbGonder.isChecked()) {
				etGirilen.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
			} else {
				etGirilen.setInputType(InputType.TYPE_CLASS_TEXT);
			}
			break;

		case R.id.bGonder:
			String girilen = etGirilen.getText().toString();
			tvYazi.setText(girilen);
			if (girilen.equals("sol")) {
				tvYazi.setGravity(Gravity.LEFT);
			} else if (girilen.equals("sag")) {
				tvYazi.setGravity(Gravity.RIGHT);
			} else if (girilen.equals("orta")) {
				tvYazi.setGravity(Gravity.CENTER);
			} else if (girilen.equals("cuneyt")) {
				Random crazy = new Random();
				tvYazi.setText(etGirilen.getText().toString());
				tvYazi.setTextSize(crazy.nextInt(80));
				tvYazi.setTextColor(Color.rgb(crazy.nextInt(256),
						crazy.nextInt(256), crazy.nextInt(256)));
				switch (crazy.nextInt(3)) {
				case 0:
					tvYazi.setGravity(Gravity.RIGHT);
					break;
				case 1:
					tvYazi.setGravity(Gravity.CENTER);
					break;
				case 2:
					tvYazi.setGravity(Gravity.LEFT);
					break;
				}
			} else {
				tvYazi.setText("Geçersiz deðer");
			}
			break;
		}

	}
}
