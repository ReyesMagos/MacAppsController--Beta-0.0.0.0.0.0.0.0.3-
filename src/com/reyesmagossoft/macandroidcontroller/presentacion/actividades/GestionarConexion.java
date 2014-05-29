package com.reyesmagossoft.macandroidcontroller.presentacion.actividades;

import com.example.androidclient.R;
import com.reyesmagossoft.macandroidcontroller.modelo.comunicador.ComunicadorGeneral;
import com.reyesmagossoft.macandroidcontroller.modelo.controladores.ServerController;
import com.reyesmagossoft.macandroidcontroller.modelo.utilidades.Utilities;
import com.reyesmagossoft.macandroidcontroller.servicios.Servidor;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GestionarConexion extends Activity {

	static TextView textResponse;
	EditText editTextAddress, editTextPort;
	Button buttonConnect, buttonClear;
	TextView txtMensaje;
	ServerController controladorServidor;
	Servidor miServidor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ComunicadorGeneral.setCurrentActivity(this);
		ComunicadorGeneral.setCurrentActivityName("Gestion");
		initControllers();

	}

	public void initControllers() {
		editTextAddress = (EditText) findViewById(R.id.address);
		editTextPort = (EditText) findViewById(R.id.port);
		buttonConnect = (Button) findViewById(R.id.connect);
		buttonClear = (Button) findViewById(R.id.clear);
		textResponse = (TextView) findViewById(R.id.response);

	}

	public static void showResponse(String s) {
		textResponse.setText(s);
	}

	public void btnClear_Click(View v) {
		textResponse.setText("");
	}

	public void btnConectar_Click(View v) {
		String ip;
		String port;
		port = editTextPort.getText().toString();
		ip = editTextAddress.getText().toString();
		if (ip != null && ip.length() >= 11) {
			if (port != null && port.length() > 1) {
				if (Utilities.checkNumberToText(port)) {
					controladorServidor = new ServerController(ip,
							Integer.parseInt(port));
					controladorServidor.initServer();
					ComunicadorGeneral.setController(controladorServidor);
					controladorServidor
							.changeActivity(SelectApplications.class);

				}
			}

		}

	}

}
