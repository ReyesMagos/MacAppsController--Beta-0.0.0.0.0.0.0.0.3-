package com.reyesmagossoft.macandroidcontroller.servicios;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.reyesmagossoft.macandroidcontroller.modelo.comunicador.ComunicadorGeneral;
import com.reyesmagossoft.macandroidcontroller.modelo.controladores.ServerController;

import android.os.AsyncTask;
import android.util.Log;

public class Servidor extends AsyncTask<Void, String, Void> {

	String dstAddress;
	int dstPort;
	String response = "";
	ObjectOutputStream out;
	String firstResponse = "";

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
	protected Void doInBackground(Void... arg0) {

		Socket socket = null;

		try {
			socket = new Socket(dstAddress, dstPort);
			out = new ObjectOutputStream(socket.getOutputStream());
			out.flush();

			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(
					1024);
			byte[] buffer = new byte[1024];

			int bytesRead;
			ObjectInputStream inputStream = new ObjectInputStream(
					socket.getInputStream());

			/*
			 * notice: inputStream.read() will block if no data return
			 */
			response = " ";
			int pos = 0;
			while (!response.equals("bye")) {
				response = (String) inputStream.readObject();
				Log.i("respuesta iiii ", response);
				 publishProgress(response);
			}

			Log.i("respuesta iiii ", response);

			/*
			 * / while ((bytesRead = inputStream.read(buffer)) != -1) {
			 * byteArrayOutputStream.write(buffer, 0, bytesRead);
			 * 
			 * response = byteArrayOutputStream.toString("UTF-8"); if
			 * (!response.equals(firstResponse)) { publishProgress(response); }
			 * 
			 * firstResponse = response; } /
			 */

			// Log.i("respuesta", response);

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
		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		// textResponse.setText(response);

		super.onPostExecute(result);
		Log.i("respuesta", response);
		ComunicadorGeneral.getController().showCurrentSongName(response);
	}

}
