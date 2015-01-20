package com.cuneytyilmaz.projeler;

import java.io.IOException;
import java.io.InputStream;

import org.xml.sax.InputSource;

import com.cuneytyilmaz.projeler.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.IBinder;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ResimCek extends Activity implements OnClickListener{

	ImageView ivresim;
	ImageButton ibkamera;
	Button bayarla;
	Bitmap bmp;
	Intent i;
	final static int kamera = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kamera);
		ilkleme();
		InputStream is = getResources().openRawResource(R.drawable.applebuyuk);
		bmp = BitmapFactory.decodeStream(is);
		
	}

	public void ilkleme(){
		ivresim = (ImageView) findViewById(R.id.ivResim);
		ibkamera = (ImageButton) findViewById(R.id.ibResimCek);
		bayarla = (Button) findViewById(R.id.bWallpaper);
		ibkamera.setOnClickListener(this);
		bayarla.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.ibResimCek :
			i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(i, kamera);
			
			break;
		case R.id.bWallpaper :
			try {
				getApplicationContext().setWallpaper(bmp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if (resultCode == RESULT_OK) {
			Bundle cerceve = data.getExtras();
			bmp = (Bitmap) cerceve.get("data");
			ivresim.setImageBitmap(bmp);
		}
	}

}
