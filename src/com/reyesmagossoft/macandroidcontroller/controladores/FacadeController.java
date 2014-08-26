package com.reyesmagossoft.macandroidcontroller.controladores;

import com.reyesmagossoft.macandroidcontroller.presentacion.actividades.SpotifyActivity;

import android.app.Activity;

public class FacadeController {
	
	private static  FacadeController instance;
	private SpotifyController spotifyController;
	
	private FacadeController(){
		
	}
	
	public  static FacadeController getInstance(){
		if(instance==null)
			instance = new FacadeController();
		return instance;
	}
	
	public void registerActivityToControllers(Activity activity){
		if(activity instanceof SpotifyActivity)
			this.spotifyController = new SpotifyController(activity);
	}
	public void showServerMessageInActivity(String message, String activityName){
		if(activityName.equals("spotify")&& this.spotifyController!=null)
			spotifyController.showCurrentSongName(message);
		
	}

	public void sendMessageToServer(String message, Activity activity){
		if(activity instanceof SpotifyActivity)
			this.spotifyController.sendMessageToServer(message);
	}
}
