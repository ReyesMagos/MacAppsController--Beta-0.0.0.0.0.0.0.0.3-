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
import com.reyesmagossoft.macandroidcontroller.controladores.FacadeController;
import com.reyesmagossoft.macandroidcontroller.controladores.SpotifyController;
import com.reyesmagossoft.macandroidcontroller.modelo.comunicador.ComunicadorGeneral;

public class SpotifyActivity extends FragmentActivity {
	private FacadeController controller;
	private SeekBar volumenBar;
	private TextView txtCancionActual;
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
	
	public void sendMessage(String message){
		controller.sendMessageToServer(message, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spotify, menu);
		return true;
	}

	public void initControlls() {
		controller = FacadeController.getInstance();
		controller.registerActivityToControllers(this);
		btnPlay = (ImageView) findViewById(R.id.btnPlayPause);
		btnNext = (ImageView) findViewById(R.id.btnNext);
		btnBack = (ImageView) findViewById(R.id.btnPreview);
		btnTrackName = (ImageView) findViewById(R.id.btnTrackName);

		btnTrackName.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sendMessage("nextSongName");
			}
		});

		btnPlay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sendMessage("play");

			}
		});

		btnNext.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sendMessage("next");
			}
		});

		btnBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sendMessage("back");
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

				sendMessage("volumen;"
						+ Integer.toString(progress*10));
				// TODO Auto-generated method stub

			}
		});
	}



	public SeekBar getVolumenBar() {
		return volumenBar;
	}

	public void setVolumenBar(SeekBar volumenBar) {
		this.volumenBar = volumenBar;
	}

	public TextView getTxtCancionActual() {
		return txtCancionActual;
	}

	public void setTxtCancionActual(TextView txtCancionActual) {
		this.txtCancionActual = txtCancionActual;
	}

	public ImageView getBtnPlay() {
		return btnPlay;
	}

	public void setBtnPlay(ImageView btnPlay) {
		this.btnPlay = btnPlay;
	}

	public ImageView getBtnNext() {
		return btnNext;
	}

	public void setBtnNext(ImageView btnNext) {
		this.btnNext = btnNext;
	}

	public ImageView getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(ImageView btnBack) {
		this.btnBack = btnBack;
	}

	public ImageView getBtnTrackName() {
		return btnTrackName;
	}

	public void setBtnTrackName(ImageView btnTrackName) {
		this.btnTrackName = btnTrackName;
	}

	

}
