package com.reyesmagossoft.macandroidcontroller.modelo.controladores;

import android.app.Activity;
import android.content.Intent;

import com.reyesmagossoft.macandroidcontroller.presentacion.MainActivity;
import com.reyesmagossoft.macandroidcontroller.presentacion.SpotifyActivity;
import com.reyesmagossoft.macandroidcontroller.servicios.Servidor;

public class ServerController {

	private Servidor server;
	private boolean conectado;

	public ServerController(String ipPuerto, int port) {
		server = new Servidor(ipPuerto, port);

	}

	public void initServer() {
		if (server != null) {
			server.execute();
		}
	}

	public void sendMessageToServer(String s) {
		if (server != null) {
			server.sendMessage(s);
		}
	}

	public void changeActivity(Activity a) {
		Intent i = new Intent(a, SpotifyActivity.class);
		a.startActivity(i);
	}

	public void avisaConexion() {
		conectado = true;
	}
	
	public void showCurrentSongName(String s){
		
		if(s==null)return;
		SpotifyActivity.showCurrentSongName(s);
	}

}
