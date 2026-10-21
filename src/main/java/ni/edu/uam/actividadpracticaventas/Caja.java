package ni.edu.uam.actividadpracticaventas;

public class Caja {

    private int cantidadVentas = 0;
    private int totalRecaudado = 0;

    // Agregamos 'synchronized' para garantizar que solo UN vendedor a la vez
    // pueda modificar las variables y evitar que se pierdan datos por concurrencia.
    public synchronized void registrarVenta(String vendedor, int monto) {
        cantidadVentas++;
        totalRecaudado += monto;
        System.out.println(vendedor + " registró una venta de C$: " + monto
                + " | Ventas acumuladas: " + cantidadVentas
                + " | Total acumulado: C$: " + totalRecaudado);
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public int getTotalRecaudado() {
        return totalRecaudado;
    }
}