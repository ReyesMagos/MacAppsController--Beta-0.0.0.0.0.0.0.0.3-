package com.reyesmagossoft.macandroidcontroller.presentacion.fragments;

import java.util.ArrayList;
import java.util.List;

import com.example.androidclient.R;
import com.reyesmagossoft.macandroidcontroller.modelo.adaptadores.AdaptadorGridAplicaciones;
import com.reyesmagossoft.macandroidcontroller.modelo.comunicador.ComunicadorGeneral;
import com.reyesmagossoft.macandroidcontroller.modelo.entidades.Aplicacion;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}

}
