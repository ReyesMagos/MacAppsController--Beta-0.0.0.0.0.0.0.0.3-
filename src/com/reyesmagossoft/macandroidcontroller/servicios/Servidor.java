package com.reyesmagossoft.macandroidcontroller.servicios;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.reyesmagossoft.macandroidcontroller.controladores.ServerController;
import com.reyesmagossoft.macandroidcontroller.modelo.comunicador.ComunicadorGeneral;
import com.reyesmagossoft.macandroidcontroller.modelo.utilidades.Utilities.Resultado;

import android.database.CursorJoiner.Result;
import android.os.AsyncTask;
import android.util.Log;

public class Servidor extends AsyncTask<Void, String, Boolean> {

	String dstAddress;
	int dstPort;
	String response = "";
	ObjectOutputStream out;
	String firstResponse = "";
	Resultado resultado;

	public Servidor(String addr, int port) {
		super();
		dstAddress = addr;
		dstPort = port;

	}

	public void sendMessage(String msg) {
		if (msg != null && msg.length() > 3)
			try {
				out.writeObject(msg);
				out.flush();
				System.out.println("client>" + msg);
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
	}

	@Override
	protected void onProgressUpdate(String... values) {
		// TODO Auto-generated method stub

		super.onProgressUpdate(values);
		ComunicadorGeneral.getController().showCurrentSongName(response);
		Log.i("respuesta", response);
	}

	@Override
	protected Boolean doInBackground(Void... arg0) {

		Socket socket = null;
		boolean resultado = false;

		try {
			socket = new Socket(dstAddress, dstPort);
			out = new ObjectOutputStream(socket.getOutputStream());
			out.flush();

			ObjectInputStream inputStream = new ObjectInputStream(
					socket.getInputStream());

			/*
			 * notice: inputStream.read() will block if no data return
			 */
			response = " ";

			while (!response.equals("bye")) {
				response = (String) inputStream.readObject();
				Log.i("respuesta iiii ", response);
				publishProgress(response);
			}
			resultado = true;

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = "UnknownHostException: " + e.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = "IOException: " + e.toString();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("data received in unknown format");
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return resultado;
	}

	@Override
	protected void onPostExecute(Boolean result) {
		// textResponse.setText(response);

		super.onPostExecute(result);
		Log.i("respuesta", response);
		if (result) {
			ComunicadorGeneral.getController().showCurrentSongName(response);
		}else{
			ComunicadorGeneral.getController().showCurrentSongName("Error");
		}
	}

}
