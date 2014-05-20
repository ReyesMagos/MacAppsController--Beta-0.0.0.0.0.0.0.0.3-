package com.reyesmagossoft.macandroidcontroller.modelo.comunicador;

import android.app.Activity;

import com.reyesmagossoft.macandroidcontroller.modelo.controladores.ServerController;
import com.reyesmagossoft.macandroidcontroller.modelo.utilidades.Utilities;

/**
 * Esta Clase es el Comunicador se encarga de el paso de archivos entre todas
 * las actividades en especial de mantener guardada la actividad en la que se
 * encuentra la aplicacion
 * 
 * @author Oscarg798
 * 
 */
public class ComunicadorGeneral {

	public static ServerController controller;
	public static Activity currentActivity;
	public static Utilities.ActividadActual currentActivityName;

	/**
	 * Este metodo se encarga mantener el controlador del servidor para las
	 * demas actividades y clases
	 * 
	 * @return en controlador
	 */
	public static ServerController getController() {
		return controller;
	}

	/**
	 * Este metodo se encarga de setear el controlador
	 * 
	 * @param controller
	 *            controlador del servidor
	 */
	public static void setController(ServerController controller) {
		ComunicadorGeneral.controller = controller;
	}

	/**
	 * este metodo es para obtener la actividad en la cual se encuentra la
	 * aplicacion
	 * 
	 * @return retorna la actividad actual
	 */
	public static Activity getCurrentActivity() {
		return currentActivity;
	}

	/**
	 * Este metodo se encarga de setear la actividad actual en la cual se
	 * encuentra la aplicacion
	 * 
	 * @param actividad
	 *            actividad actual de la aplicacion
	 */
	public static void setCurrentActivity(Activity actividad) {
		ComunicadorGeneral.currentActivity = actividad;
	}

	/**
	 * Este metodo se encarga de devolver el nombre de la actividad actual si no
	 * hay nombre asignado a la enumeracion se devolvera error
	 * 
	 * @return nombre de la actividad o error
	 */
	public static Utilities.ActividadActual getCurrentActivityName() {
		if (currentActivity == null)
			return Utilities.ActividadActual.valueOf("Error");
		return currentActivityName;
	}

	/**
	 * Este metodo se encarga de setear el nombre de la actividad actual
	 * 
	 * @param nameActivity
	 *            nombre de la actividad
	 */
	public static void setCurrentActivityName(String nameActivity) {
		currentActivityName = Utilities.ActividadActual.valueOf(nameActivity);

	}

}
