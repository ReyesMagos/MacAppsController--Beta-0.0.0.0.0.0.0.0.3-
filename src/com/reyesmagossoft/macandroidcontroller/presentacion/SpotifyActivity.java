package com.reyesmagossoft.macandroidcontroller.presentacion;

import com.example.androidclient.R;
import com.example.androidclient.R.layout;
import com.example.androidclient.R.menu;
import com.reyesmagossoft.macandroidcontroller.modelo.comunicador.ComunicadorGeneral;
import com.reyesmagossoft.macandroidcontroller.modelo.controladores.ServerController;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class SpotifyActivity extends Activity {

	private ServerController controller;
	private SeekBar volumenBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spotify);
		controller = ComunicadorGeneral.getController();
		volumenBar = (SeekBar) findViewById(R.id.volumenBar);
		volumenBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				
				controller.sendMessageToServer("volumen;"+ Integer.toString(progress));
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spotify, menu);
		return true;
	}

	public void btnPlayPause_Click(View v) {
		controller.sendMessageToServer("play");
	}

	public void btnNext_Click(View v) {
		controller.sendMessageToServer("next");
	}

	public void btnPlayPreview_Click(View v) {
		controller.sendMessageToServer("back");

	}
	
	

}
