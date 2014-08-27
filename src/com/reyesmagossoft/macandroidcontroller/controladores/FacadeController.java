package com.reyesmagossoft.macandroidcontroller.controladores;

import com.example.androidclient.KeyNoteActivity;
import com.reyesmagossoft.macandroidcontroller.presentacion.actividades.SafariActivity;
import com.reyesmagossoft.macandroidcontroller.presentacion.actividades.SpotifyActivity;

import android.app.Activity;

public class FacadeController {
	
	private static  FacadeController instance;
	private SpotifyController spotifyController;
	private SafariController safariActivity;
	private KeyNoteController keyNoteController;
	
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
		if(activity instanceof SafariActivity)
			this.safariActivity = new SafariController(activity);
		if(activity instanceof KeyNoteActivity)
			this.keyNoteController = new KeyNoteController(activity);
			
	}
	public void showServerMessageInActivity(String message, String activityName){
		if(activityName.equals("spotify")&& this.spotifyController!=null)
			spotifyController.showCurrentSongName(message);
	
	}

	public void sendMessageToServer(String message, Activity activity){
		if(activity instanceof SpotifyActivity)
			this.spotifyController.sendMessageToServer(message);
		if(activity instanceof SafariActivity)
			this.safariActivity.sendMessageToServer(message);
		if(activity instanceof KeyNoteActivity)
			this.keyNoteController.sendMessageToServer(message);
			
	}
}
