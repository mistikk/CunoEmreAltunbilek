package com.cuneytyilmaz.projeler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Audio.Media;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ExternalData extends Activity implements OnItemSelectedListener,
		OnClickListener {

	private TextView canWrite, canRead;
	private String state;
	boolean canW, canR;
	Spinner spinner;

	String[] paths = { "Muzik", "Resimler", "Indirilenler" };

	File path = null;

	File fileName = null;
	EditText dosyayiKaydet;
	Button onayla, kaydet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.externaldata);

		ilkleme();

	}

	private void ilkleme() {
		// TODO Auto-generated method stub
		canWrite = (TextView) findViewById(R.id.tvWrite);
		canRead = (TextView) findViewById(R.id.tvRead);
		spinner = (Spinner) findViewById(R.id.spinner1);
		onayla = (Button) findViewById(R.id.bOnayla);
		kaydet = (Button) findViewById(R.id.bFarkliKaydet);
		dosyayiKaydet = (EditText) findViewById(R.id.etFarkliKaydet);

		onayla.setOnClickListener(this);
		kaydet.setOnClickListener(this);

		checkState();

		ArrayAdapter<String> adapter;
		adapter = new ArrayAdapter<String>(ExternalData.this,
				android.R.layout.simple_spinner_item, paths);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
	}

	private void checkState() {
		// TODO Auto-generated method stub
		state = Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			canWrite.setText("True");
			canRead.setText("True");
			canR = canW = true;
		} else if (state.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
			canWrite.setText("False");
			canRead.setText("True");
			canW = true;
			canR = false;
		} else {
			canRead.setText("False");
			canWrite.setText("False");
			canW = canR = false;
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bOnayla:
			kaydet.setVisibility(Button.VISIBLE);
			onayla.setVisibility(Button.GONE);
			break;
		case R.id.bFarkliKaydet:
			String f = dosyayiKaydet.getText().toString();
			fileName = new File(path, f + ".png");
			path.mkdirs();

			try {
				InputStream is = getResources().openRawResource(
						R.drawable.applebuyuk);
				OutputStream os = new FileOutputStream(fileName);
				byte[] data = new byte[is.available()];

				is.read(data);
				os.write(data);

				is.close();
				os.close();

				Toast t = Toast.makeText(ExternalData.this, "Dosya Kaydedildi",
						Toast.LENGTH_LONG);
				t.show();
				MediaScannerConnection.scanFile(ExternalData.this,
						new String[] { fileName.toString() }, null,
						new MediaScannerConnection.OnScanCompletedListener() {

							@Override
							public void onScanCompleted(String path, Uri uri) {
								// TODO Auto-generated method stub
								Toast t = Toast.makeText(ExternalData.this,
										"Tarama Tamamlandý", Toast.LENGTH_LONG);
								t.show();
							}
						});
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		int secilenItem = spinner.getSelectedItemPosition();
		switch (secilenItem) {
		case 0:
			path = Environment
					.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC);
			break;

		case 1:
			path = Environment
					.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
			break;

		case 2:
			path = Environment
					.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
			break;

		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

}
