package com.reyesmagossoft.macandroidcontroller.presentacion.fragments;

import java.util.ArrayList;
import java.util.List;

import com.example.androidclient.R;
import com.reyesmagossoft.macandroidcontroller.modelo.adaptadores.AdaptadorGridAplicaciones;
import com.reyesmagossoft.macandroidcontroller.modelo.comunicador.ComunicadorGeneral;
import com.reyesmagossoft.macandroidcontroller.modelo.entidades.Aplicacion;
import com.reyesmagossoft.macandroidcontroller.modelo.utilidades.Utilities;
import com.reyesmagossoft.macandroidcontroller.presentacion.actividades.SafariActivity;
import com.reyesmagossoft.macandroidcontroller.presentacion.actividades.SpotifyActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;

public class FragmentosActividades extends Fragment {

	GridView gridAplicaciones;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_grid_apps_selector,
				container, false);
		initComponets(v);

		return v;
	}

	public void initComponets(View v) {
		List<Aplicacion> appsList = new ArrayList<Aplicacion>();
		Aplicacion a = new Aplicacion(R.drawable.ic_launcher, "Spotify");
		appsList.add(a);
		a = new Aplicacion(R.drawable.ic_launcher, "Chrome");
		appsList.add(a);
		AdaptadorGridAplicaciones adapter = new AdaptadorGridAplicaciones(
				v.getContext(), appsList);
		gridAplicaciones = (GridView) v.findViewById(R.id.gridApplicaciones);
		gridAplicaciones.setAdapter(adapter);
		gridAplicaciones
				.setOnItemSelectedListener(new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						// TODO Auto-generated method stub
						Aplicacion a = (Aplicacion) arg0
								.getItemAtPosition(arg2);
						Log.i("Gay", a.getNameApp().toString());

					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub

					}
				});

		gridAplicaciones.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				// Aplicacion a= (Aplicacion)arg0.getItemAtPosition(arg2);
				// if(a.getNameApp().equals("Spotify")){
				// Utilities.changeActivity(SpotifyActivity.class);
				// }
				if(arg2==0){
					 Utilities.changeActivity(SpotifyActivity.class);
				}else if(arg2==1){
					 Utilities.changeActivity(SafariActivity.class);
				}
			}
		});

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}

}
