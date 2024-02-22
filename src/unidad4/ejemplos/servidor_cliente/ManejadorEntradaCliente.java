package unidad4.ejemplos.servidor_cliente;

import java.io.BufferedReader;
import java.io.IOException;

public class ManejadorEntradaCliente implements Runnable {
        private BufferedReader entrada;

        public ManejadorEntradaCliente(BufferedReader entrada) {
            this.entrada = entrada;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String mensajeServidor = entrada.readLine();
                    if (mensajeServidor == null || mensajeServidor.equals("exit")) {
                        break;
                    }
                    System.out.println("Servidor: " + mensajeServidor);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
  }
    

