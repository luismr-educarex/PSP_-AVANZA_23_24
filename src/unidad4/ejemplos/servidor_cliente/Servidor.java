package unidad4.ejemplos.servidor_cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;



public class Servidor {
	
	private static final int PUERTO = 12345;

	public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PUERTO);

        System.out.println("Esperando la conexión del cliente...");
        Socket clientSocket = serverSocket.accept();

        System.out.println("Cliente conectado");

        BufferedReader flujoEntrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter flujoSalida = new PrintWriter(clientSocket.getOutputStream(), true);

        Thread hiloManejadorEntrada = new Thread(new ManejadorEntradaServidor(flujoEntrada));
        Thread hiloManejadorSalida = new Thread(new ManejadorSalidaServidor(flujoSalida));

        hiloManejadorEntrada.start();
        hiloManejadorSalida.start();
    }
	
}
