package com.reyesmagossoft.macandroidcontroller.servicios;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.reyesmagossoft.macandroidcontroller.controladores.FacadeController;
import com.reyesmagossoft.macandroidcontroller.modelo.utilidades.Utilities.Resultado;

import android.os.AsyncTask;
import android.util.Log;

public class Servidor extends AsyncTask<Void, String, Boolean> {

	private String dstAddress;
	private int dstPort;
	private String response = "";
	private ObjectOutputStream out;
	private String firstResponse = "";
	private Resultado resultado;
	private static  Servidor instance;

	private Servidor() {
		super();
		
	}
	
	public static Servidor getInstance(){
		if(instance==null)
			instance= new Servidor();
		return instance;
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
		FacadeController facadeController = FacadeController.getInstance();
		facadeController.showServerMessageInActivity(response, "spotify");
				
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

	
	public String getDstAddress() {
		return dstAddress;
	}

	public void setDstAddress(String dstAddress) {
		this.dstAddress = dstAddress;
	}

	public int getDstPort() {
		return dstPort;
	}

	public void setDstPort(int dstPort) {
		this.dstPort = dstPort;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public ObjectOutputStream getOut() {
		return out;
	}

	public void setOut(ObjectOutputStream out) {
		this.out = out;
	}

	public String getFirstResponse() {
		return firstResponse;
	}

	public void setFirstResponse(String firstResponse) {
		this.firstResponse = firstResponse;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	@Override
	protected void onPostExecute(Boolean result) {
		// textResponse.setText(response);

		super.onPostExecute(result);
		Log.i("respuesta", response);
		if (result) {
			//ComunicadorGeneral.getController().showCurrentSongName(response);
		}else{
			//ComunicadorGeneral.getController().showCurrentSongName("Error");
		}
	}

}
