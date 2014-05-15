package com.reyesmagossoft.macandroidcontroller.modelo.comunicador;

import com.reyesmagossoft.macandroidcontroller.modelo.controladores.ServerController;

public class ComunicadorGeneral {

	public static ServerController controller;


	public static ServerController getController() {
		return controller;
	}

	public static void setController(ServerController controller) {
		ComunicadorGeneral.controller = controller;
	}

	
	
	

}
