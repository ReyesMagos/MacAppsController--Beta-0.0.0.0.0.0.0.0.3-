package com.reyesmagossoft.macandroidcontroller.presentacion.actividades;

import com.example.androidclient.R;
import com.example.androidclient.R.id;
import com.example.androidclient.R.layout;
import com.example.androidclient.R.menu;
import com.reyesmagossoft.macandroidcontroller.controladores.FacadeController;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class SafariActivity extends Activity {
	private FacadeController facadeController;
	private EditText txtUrl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_safari);
		facadeController = FacadeController.getInstance();
		facadeController.registerActivityToControllers(this);
		txtUrl = (EditText) findViewById(R.id.txtUrl);
	}

	public void btnGetUrl_Click(View v) {
		if (!txtUrl.getText().toString().equals("")
				&& txtUrl.getText().toString().length() > 5)
			facadeController.sendMessageToServer("url;"
					+ txtUrl.getText().toString(), this);
	}

	public void btnBack_Click(View v) {
		facadeController.sendMessageToServer("safariBack", this);
	}

	public void btnForward_Click(View v) {
		facadeController.sendMessageToServer("safariForward", this);
	}

	public void btnRefresh_Click(View v) {
		facadeController.sendMessageToServer("safariRefresh", this);	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.safari, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
