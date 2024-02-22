package unidad4.ejemplos.servidor_cliente;

import java.io.BufferedReader;
import java.io.IOException;

public class ManejadorEntradaServidor implements Runnable {
        private BufferedReader entrada;

        public ManejadorEntradaServidor(BufferedReader entrada) {
            this.entrada = entrada;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String mensajeCliente = entrada.readLine();
                    if (mensajeCliente == null || mensajeCliente.equals("exit")) {
                        break;
                    }
                    System.out.println("Cliente: " + mensajeCliente);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
  }
