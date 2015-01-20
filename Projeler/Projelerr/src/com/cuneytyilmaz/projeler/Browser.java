package com.cuneytyilmaz.projeler;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class Browser extends Activity implements OnClickListener {

	Button git,geri,ileri,gecmisiSil,yenile;
	WebView browser;
	EditText webAdresi;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browser);
		
		ilkleme();
		
		browser.getSettings().setJavaScriptEnabled(true);
		browser.getSettings().setLoadWithOverviewMode(true);
		browser.getSettings().setUseWideViewPort(true);
		
		browser.setWebViewClient(new benimClient());
		
		git.setOnClickListener(this);
		geri.setOnClickListener(this);
		ileri.setOnClickListener(this);
		gecmisiSil.setOnClickListener(this);
		yenile.setOnClickListener(this);
		
	}

	private void ilkleme() {
		// TODO Auto-generated method stub
		git = (Button)findViewById(R.id.bGit);
		geri = (Button)findViewById(R.id.bGeri);
		ileri = (Button)findViewById(R.id.bIleri);
		gecmisiSil = (Button)findViewById(R.id.bSil);
		yenile = (Button)findViewById(R.id.bYenile);
		browser = (WebView)findViewById(R.id.wvBrowser);
		webAdresi = (EditText)findViewById(R.id.etAdres);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bGit:
			String gidilecekAdres = webAdresi.getText().toString();
			browser.loadUrl(gidilecekAdres);
			
			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(webAdresi.getWindowToken(), 0);
			break;
		case R.id.bGeri:
			if (browser.canGoBack()) {
				browser.goBack();
			}
			break;
		case R.id.bIleri:
			if (browser.canGoForward()) {
				browser.goForward();
			}
			break;
		case R.id.bYenile:
			browser.reload();
			break;
		case R.id.bSil:
			browser.clearHistory();
			break;
		}
		
	}

	
}
