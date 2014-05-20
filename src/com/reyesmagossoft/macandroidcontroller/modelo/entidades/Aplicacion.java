package com.reyesmagossoft.macandroidcontroller.modelo.entidades;

public class Aplicacion {

	private int imageLocation;
	private String nameApp;

	/**
	 * Constructor en blanco
	 */
	public Aplicacion() {

	}

	/**
	 * Contructor con parametros
	 * 
	 * @param imageLocation
	 *            el entero que corresponde al recurso de la imagen
	 * @param nameApp
	 *            nombre de la aplicacion String
	 */
	public Aplicacion(int imageLocation, String nameApp) {
		super();
		this.imageLocation = imageLocation;
		this.nameApp = nameApp;
	}

	public int getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(int imageLocation) {
		this.imageLocation = imageLocation;
	}

	public String getNameApp() {
		return nameApp;
	}

	public void setNameApp(String nameApp) {
		this.nameApp = nameApp;
	}

}
