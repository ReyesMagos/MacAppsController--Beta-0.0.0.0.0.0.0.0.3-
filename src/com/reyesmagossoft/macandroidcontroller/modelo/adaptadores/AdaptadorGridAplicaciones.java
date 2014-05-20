package com.reyesmagossoft.macandroidcontroller.modelo.adaptadores;

import java.util.List;

import com.example.androidclient.R;
import com.reyesmagossoft.macandroidcontroller.modelo.entidades.Aplicacion;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorGridAplicaciones extends BaseAdapter {

	Context context;
	List<Aplicacion> appsList;

	/**
	 * 
	 * Aqui se inicia el adaptador. Es el constructor
	 * 
	 * @param context
	 *            contexto de la aplicacion donde se crea el adaptador o donde
	 *            este el layout
	 * @param resource
	 * @param appsList
	 *            lista de el nombre y el entero referente al recurso de la
	 *            aplicacion
	 */
	public AdaptadorGridAplicaciones(Context context, List<Aplicacion> appsList) {

		// TODO Auto-generated constructor stub
		this.appsList = appsList;
		this.context = context;
	}

	/**
	 * En este metodo se inicializa la vista se verifica si existe ya para
	 * usarla o se crea una nueva. Se asigna ademas el nombre de la aplicacion y
	 * la imagen
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		View item = convertView;
		ViewHolder view = new ViewHolder();
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (item == null) {

			item = inflater.inflate(
					R.layout.customs_adapter_select_applications, null);
			view = new ViewHolder();
			view.txtAppName = (TextView) item.findViewById(R.id.txtNombreApp);
			view.imgApp = (ImageView) item.findViewById(R.id.imgIconoApp);
			item.setTag(view);

		} else {
			view = (ViewHolder) item.getTag();
		}
		view.txtAppName.setText(appsList.get(position).getNameApp());
		view.imgApp.setImageResource(appsList.get(position).getImageLocation());

		return (item);

	}

	static class ViewHolder {
		TextView txtAppName;
		ImageView imgApp;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return appsList.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return appsList.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return appsList.indexOf(getItem(arg0));
	}

}
