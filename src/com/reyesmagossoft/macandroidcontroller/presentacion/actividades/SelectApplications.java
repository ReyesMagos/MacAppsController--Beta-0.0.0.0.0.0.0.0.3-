package com.reyesmagossoft.macandroidcontroller.presentacion.actividades;

import com.example.androidclient.R;
import com.reyesmagossoft.macandroidcontroller.modelo.comunicador.ComunicadorGeneral;
import com.reyesmagossoft.macandroidcontroller.presentacion.fragments.FragmentosActividades;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SelectApplications extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selector_app);
		// Añadimos al comunicador la actividad presente
		ComunicadorGeneral.setCurrentActivity(this);
		ComunicadorGeneral.setCurrentActivityName("Selecccion");
		// Creamos el nuevo fragmento que utilizaremos
		FragmentosActividades fgrActividades = new FragmentosActividades();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select_applications, menu);
		return true;
	}

}
