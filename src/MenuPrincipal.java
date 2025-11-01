import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner;

    public MenuPrincipal(Scanner scanner) {
        this.scanner = scanner;
    }

    // Método principal que ejecuta todo el flujo del menú
    public void ejecutar() {
        boolean continuar = true;

        mostrarBanner();

        while (continuar) {
            mostrarOpciones();
            int opcion = obtenerOpcionUsuario();

            switch (opcion) {
                case 1:
                    realizarConversion();
                    break;

                case 2:
                    mostrarHistorial();
                    break;

                case 3:
                    limpiarHistorial();
                    break;

                case 4:
                    continuar = false;
                    mostrarMensajeSalida();
                    break;

                default:
                    mostrarOpcionInvalida();
            }
        }
    }

    private void mostrarBanner() {
        System.out.println("🌎 CONVERSOR DE MONEDAS INTERNACIONAL");
        System.out.println("=====================================");
    }

    private void mostrarOpciones() {
        System.out.println("""
        ┌────────────────────────────────────────┐
        │           MENÚ PRINCIPAL               │
        ├────────────────────────────────────────┤
        │  [1] Realizar conversión               │
        │  [2] Ver historial de conversiones     │
        │  [3] Limpiar historial                 │
        │  [4] Salir                             │
        └────────────────────────────────────────┘""");
    }

    private int obtenerOpcionUsuario() {
        System.out.print("Ingrese opción (1-4): ");
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1; // Opción inválida
        }
    }

    private void realizarConversion() {
        // 1. Mostrar menú de países
        MenuPaises menuPaises = new MenuPaises();
        menuPaises.imprimirMenu();

        // 2. Capturar monedas
        CapturaMoneda capturaMoneda = new CapturaMoneda();
        capturaMoneda.seleccionaMoneda(scanner);

        // 3. Capturar monto
        CapturaMonto capturaMonto = new CapturaMonto();
        double cantidad = capturaMonto.seleccionaMonto(scanner);

        // 4. Realizar consulta a la API
        ConsultaApi api = new ConsultaApi();
        api.realizarConversion(
                capturaMoneda.getMonedaOrigen(),
                capturaMoneda.getMonedaDestino(),
                cantidad
        );
    }

    private void mostrarHistorial() {
        HistorialManager.mostrarHistorial();
    }

    private void limpiarHistorial() {
        System.out.print("¿Estás seguro de limpiar el historial? (s/n): ");
        String confirmacion = scanner.nextLine().trim().toLowerCase();
        if (confirmacion.equals("s") || confirmacion.equals("si")) {
            HistorialManager.limpiarHistorial();
        } else {
            System.out.println("Operación cancelada");
        }
    }

    private void mostrarMensajeSalida() {
        System.out.println("👋 ¡Gracias por usar el Conversor de Monedas!");
    }

    private void mostrarOpcionInvalida() {
        System.out.println("❌ Opción no válida. Por favor elige 1-4");
    }
}