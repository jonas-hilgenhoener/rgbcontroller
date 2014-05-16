package com.example.rgbcontroller;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import android.os.AsyncTask;

class NetworkClass extends AsyncTask<String, Void, Void> {

    private Exception exception;

    protected Void doInBackground(String... message) {
    	byte[] sendBuffer = message[1].getBytes();
    	DatagramSocket socket;
		try {
			socket = new DatagramSocket();
			InetAddress address = InetAddress.getByName(message[0]);
			DatagramPacket packet = new DatagramPacket( sendBuffer, sendBuffer.length, address, 8888 );
			socket.send( packet );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    protected void onPostExecute() {
        // TODO: check this.exception 
        // TODO: do something with the feed
    }
}
