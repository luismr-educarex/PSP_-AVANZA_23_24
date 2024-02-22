package unidad4.ejemplos.servidor_cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;



public class Cliente {
	
	private static final int PUERTO = 12345;

	public static void main(String[] args) throws IOException {
        
		Socket socket = new Socket("localhost", PUERTO);

        BufferedReader flujoEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter flujoSalida = new PrintWriter(socket.getOutputStream(), true);

        Thread hiloManejadorEntrada = new Thread(new ManejadorEntradaCliente(flujoEntrada));
        Thread hiloManejadorSalida = new Thread(new ManejadorSalidaCliente(flujoSalida));

        hiloManejadorEntrada.start();
        hiloManejadorSalida.start();
    }
}
