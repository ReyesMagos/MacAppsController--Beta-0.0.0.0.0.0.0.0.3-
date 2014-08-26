package com.reyesmagossoft.macandroidcontroller.presentacion.actividades;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.example.androidclient.R;
import com.reyesmagossoft.macandroidcontroller.controladores.ServerController;
import com.reyesmagossoft.macandroidcontroller.modelo.comunicador.ComunicadorGeneral;

public class SpotifyActivity extends FragmentActivity {

	private ServerController controller;
	private SeekBar volumenBar;
	private static TextView txtCancionActual;
	private ImageView btnPlay;
	private ImageView btnNext;
	private ImageView btnBack;
	private ImageView btnTrackName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spotify);
		ComunicadorGeneral.setCurrentActivityName("Spotify");
		initControlls();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spotify, menu);
		return true;
	}

	public void initControlls() {
		controller = ComunicadorGeneral.getController();
		btnPlay = (ImageView) findViewById(R.id.btnPlayPause);
		btnNext = (ImageView) findViewById(R.id.btnNext);
		btnBack = (ImageView) findViewById(R.id.btnPreview);
		btnTrackName = (ImageView) findViewById(R.id.btnTrackName);

		btnTrackName.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				controller.sendMessageToServer("nextSongName");
			}
		});

		btnPlay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				controller.sendMessageToServer("play");

			}
		});

		btnNext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				controller.sendMessageToServer("next");
			}
		});

		btnBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				controller.sendMessageToServer("back");
			}
		});
		volumenBar = (SeekBar) findViewById(R.id.volumenBar);
		txtCancionActual = (TextView) findViewById(R.id.txtCancionActual);
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

				controller.sendMessageToServer("volumen;"
						+ Integer.toString(progress * 10));
				// TODO Auto-generated method stub

			}
		});
	}

	public static void showCurrentSongName(String s) {
		if (s == null || txtCancionActual == null)
			return;
		txtCancionActual.setText(" ");
		Log.i("Escribire", s);
		txtCancionActual.setText(s);
	}

}
