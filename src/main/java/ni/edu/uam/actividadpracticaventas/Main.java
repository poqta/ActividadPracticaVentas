package ni.edu.uam.actividadpracticaventas;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        ni.edu.uam.actividadpracticaventas.Caja caja = new ni.edu.uam.actividadpracticaventas.Caja();

        // Runnable representa la tarea de cada vendedor usando el método auxiliar
        Runnable vendedor1 = () -> procesarVentas("Vendedor 1", caja);
        Runnable vendedor2 = () -> procesarVentas("Vendedor 2", caja);
        Runnable vendedor3 = () -> procesarVentas("Vendedor 3", caja);

        // Crear los tres hilos de ejecución
        Thread hilo1 = new Thread(vendedor1);
        Thread hilo2 = new Thread(vendedor2);
        Thread hilo3 = new Thread(vendedor3);

        System.out.println("---- Inicio del proceso de ventas ----");

        // Iniciar el procesamiento concurrente de los 3 vendedores
        hilo1.start();
        hilo2.start();
        hilo3.start();

        // join() obliga al hilo main a esperar que los 3 vendedores terminen
        hilo1.join();
        hilo2.join();
        hilo3.join();

        // Impresión de resultados finales esperados (15 ventas | C$ 1,500)
        System.out.println("\n---- Resultados finales ----");
        System.out.println("Cantidad total de ventas: " + caja.getCantidadVentas());
        System.out.println("Total recaudado: C$: " + caja.getTotalRecaudado());
    }

    private static void procesarVentas(String vendedor, Caja caja) {
        // En el reto práctico son 5 ventas por vendedor (1 a 5)
        for (int i = 1; i <= 5; i++) {
            try {
                // Pausa requerida de 100 ms por venta
                Thread.sleep(100);
                caja.registrarVenta(vendedor, 100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(vendedor + " fue interrumpido");
                return;
            }
        }
    }
}