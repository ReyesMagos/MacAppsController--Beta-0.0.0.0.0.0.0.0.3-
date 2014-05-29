package com.reyesmagossoft.macandroidcontroller.modelo.controladores;

import android.content.Intent;

import com.reyesmagossoft.macandroidcontroller.modelo.comunicador.ComunicadorGeneral;
import com.reyesmagossoft.macandroidcontroller.modelo.utilidades.Utilities;
import com.reyesmagossoft.macandroidcontroller.presentacion.fragments.FragmentSpotify;
import com.reyesmagossoft.macandroidcontroller.servicios.Servidor;

/**
 * Esta clase es el controlador del servidor
 * 
 * @author Oscarg798
 * 
 */
public class ServerController {

	private Servidor server;
	private boolean conectado;

	/**
	 * Este es el constructor de la clase, en el se crea una instancia de la
	 * clase servidor
	 * 
	 * @param ipPuerto
	 *            direccion ip del servidor
	 * @param port
	 *            puerto abierto por el servidor
	 */
	public ServerController(String ipPuerto, int port) {
		server = new Servidor(ipPuerto, port);

	}

	/**
	 * Este metodo inicia el servidor y gestiona la conexion a el siempre y
	 * cuando existan una instancia ya creada
	 * 
	 */
	public void initServer() {
		if (server != null) {
			server.execute();
		}
	}

	/**
	 * este metodo le envia un mensaje al servidor
	 * 
	 * @param s
	 *            mensaje a enviar al servidor
	 * 
	 */
	public void sendMessageToServer(String s) {
		if (server != null) {
			server.sendMessage(s);
		}
	}

	/**
	 * Este metodo se encarga llamar la utilidad que se encarga de cambiar de
	 * actividad
	 * 
	 * @param a
	 *            actividad en la cual se encuentra la aplicacion
	 * @param clase
	 *            clase a la cual ira la aplicacion
	 */
	public void changeActivity(Class<?> clase) {
		Utilities.changeActivity(clase);
	}

	/**
	 * este metodo indica a una variable de tipo booleano que hubo conexion
	 */
	public void avisaConexion() {
		conectado = true;
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
		String ss = ComunicadorGeneral.getCurrentActivityName().toString();
		if (s == null
				|| !ss.equals("Spotify"))
			return;
		FragmentSpotify.showCurrentSongName(s);
	}

}
