package com.reyesmagossoft.macandroidcontroller.controladores;

import com.reyesmagossoft.macandroidcontroller.presentacion.actividades.SpotifyActivity;

import android.app.Activity;

public class SpotifyController extends Controller{

	public SpotifyController(Activity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Este metodo muestra el nombre actual de la cancion que esta sonando en el
	 * spotify del cliente, este metodo debera ser pasado a un controlador
	 * propio de Spotify, dado que contaremos con muchas aplicaciones.
	 * 
	 * @param s
	 *            nombre de la cancion
	 */
	public void showCurrentSongName(String s) {
		if (s == null)
			return;
		SpotifyActivity act = (SpotifyActivity)getActivity();
		act.getTxtCancionActual().setText(" ");
		act.getTxtCancionActual().setText(s);
		

	}

	@Override
	public void sendMessageToServer(String s) {
		// TODO Auto-generated method stub
		super.sendMessageToServer(s);
	}
	
	
	

}
