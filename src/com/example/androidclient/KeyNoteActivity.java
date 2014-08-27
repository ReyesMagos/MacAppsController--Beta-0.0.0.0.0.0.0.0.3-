package com.example.androidclient;

import com.reyesmagossoft.macandroidcontroller.controladores.FacadeController;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class KeyNoteActivity extends Activity {
	private FacadeController facadeController;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_key_note);
		facadeController = FacadeController.getInstance();
		facadeController.registerActivityToControllers(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.key_note, menu);
		return true;
	}
	
	public void nextSlideButton_Click(View v){
		facadeController.sendMessageToServer("nextSlide", this);
	}

	public void previousSlideButton_Click(View v){
		facadeController.sendMessageToServer("previousSlide", this);
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
