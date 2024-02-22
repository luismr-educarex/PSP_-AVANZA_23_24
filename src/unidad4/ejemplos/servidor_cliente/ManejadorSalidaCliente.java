package unidad4.ejemplos.servidor_cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class ManejadorSalidaCliente implements Runnable {
    private PrintWriter salida;

    public ManejadorSalidaCliente(PrintWriter salida) {
        this.salida = salida;
    }

    @Override
    public void run() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String mensajeAEnviar = entrada.readLine();
                salida.println(mensajeAEnviar);

                if (mensajeAEnviar.equals("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}