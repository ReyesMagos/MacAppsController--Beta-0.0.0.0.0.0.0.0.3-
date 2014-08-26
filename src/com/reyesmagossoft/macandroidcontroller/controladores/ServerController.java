package com.reyesmagossoft.macandroidcontroller.controladores;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;

import com.reyesmagossoft.macandroidcontroller.modelo.comunicador.ComunicadorGeneral;
import com.reyesmagossoft.macandroidcontroller.modelo.utilidades.Utilities;
import com.reyesmagossoft.macandroidcontroller.servicios.Servidor;

/**
 * Esta clase es el controlador del servidor
 * 
 * @author Oscarg798
 * 
 */
@SuppressWarnings("unused")
public class ServerController extends Controller {

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
	 * @param activity
	 *            Actividad que llama el controlador
	 */
	public ServerController(String ipPuerto, int port, Activity activity) {
		super(activity);
		server = Servidor.getInstance();
		server.setDstAddress(ipPuerto);
		server.setDstPort(port);
		super.setServer(server);

	}

	@Override
	public void showAlertMessage(String title, String message) {
		// TODO Auto-generated method stub
		super.showAlertMessage(title, message);
	}

	@Override
	public void showProgressDialog(String title, String message) {
		// TODO Auto-generated method stub
		super.showProgressDialog(title, message);
	}

	@Override
	public void dissmissProgressDialog() {
		// TODO Auto-generated method stub
		super.dissmissProgressDialog();
	}

	@Override
	public void setProgressDialog(ProgressDialog progressDialog) {
		// TODO Auto-generated method stub
		super.setProgressDialog(progressDialog);
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
		super.sendMessageToServer(s);
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



}
