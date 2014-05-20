package com.reyesmagossoft.macandroidcontroller.presentacion.actividades;

import com.example.androidclient.R;
import com.reyesmagossoft.macandroidcontroller.presentacion.fragments.FragmentSpotify;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class SpotifyActivity extends FragmentActivity {

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spotify);

		FragmentSpotify frgSpotify = new FragmentSpotify();

		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spotify, menu);
		return true;
	}


}
