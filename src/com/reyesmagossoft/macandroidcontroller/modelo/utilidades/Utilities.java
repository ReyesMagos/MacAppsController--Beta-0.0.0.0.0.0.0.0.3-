package com.reyesmagossoft.macandroidcontroller.modelo.utilidades;

import android.content.Intent;

import com.reyesmagossoft.macandroidcontroller.modelo.comunicador.ComunicadorGeneral;

/**
 * Clase de utilidades, contiene metodos usados por la mayoria de las
 * aplicaciones
 * 
 * @author Oscarg798
 * 
 */
public class Utilities {

	/**
	 * este metodo chequea si un string es de caracteres numericos
	 * 
	 * @param s
	 *            String a chequear
	 * @return verdadero si es numerico, falso de lo contrario
	 */
	public static boolean checkNumberToText(String s) {
		try {
			Integer.parseInt(s);

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * Enumeracion de resultados
	 * 
	 * @author Oscarg798
	 * 
	 */
	public static enum Resultado {
		ok, error;
	}

	/**
	 * Enumeracion correspondiente al nombre de la actividad acutal
	 * 
	 * @author Oscarg798
	 * 
	 */
	public static enum ActividadActual {
		Spotify, Chrome, Error;
	}

	/**
	 * metodo encargado de inicializar el intent de la proxima aplicacion
	 * 
	 * @param clase
	 *  clase a la cual pasara el intent
	 */
	public static void changeActivity(Class<?> clase) {
		Intent i = new Intent(ComunicadorGeneral.getCurrentActivity(), clase);
		ComunicadorGeneral.getCurrentActivity().startActivity(i);
	}
}
