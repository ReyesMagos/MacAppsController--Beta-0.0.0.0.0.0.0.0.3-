package com.reyesmagossoft.macandroidcontroller.presentacion.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.example.androidclient.R;
import com.reyesmagossoft.macandroidcontroller.modelo.comunicador.ComunicadorGeneral;
import com.reyesmagossoft.macandroidcontroller.modelo.controladores.ServerController;

public class FragmentSpotify extends Fragment {

	private ServerController controller;
	private SeekBar volumenBar;
	private static TextView txtCancionActual;
	private ImageView btnPlay;
	private ImageView btnNext;
	private ImageView btnBack;
	private ImageView btnTrackName;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_spotify, container, false);
		// TODO Auto-generated method stub	
		initControlls(v);
		return v;

	}

	public void initControlls(View v) {
		controller = ComunicadorGeneral.getController();
		btnPlay = (ImageView) v.findViewById(R.id.btnPlayPause);
		btnNext = (ImageView) v.findViewById(R.id.btnNext);
		btnBack = (ImageView) v.findViewById(R.id.btnPreview);
		btnTrackName = (ImageView) v.findViewById(R.id.btnTrackName);

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
		volumenBar = (SeekBar) v.findViewById(R.id.volumenBar);
		txtCancionActual = (TextView) v.findViewById(R.id.txtCancionActual);
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



	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}

}
