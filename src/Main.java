import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuPrincipal menuPrincipal = new MenuPrincipal(scanner);

        try {
            // Esta única línea ejecuta TODO el flujo:
            // - Muestra menú principal
            // - Captura monedas (MenuPaises + CapturaMoneda)
            // - Captura monto (CapturaMonto)
            // - Consulta API (ConsultaApi)
            // - Maneja historial (HistorialManager)
            menuPrincipal.ejecutar();
        } finally {
            scanner.close();
        }
    }
}
//************************************************************************************************
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        boolean continuar = true;
//
//
//        System.out.println("🌎 CONVERSOR DE MONEDAS INTERNACIONAL");
//        System.out.println("=====================================");
//
//        try {
//            while (continuar) {
//                // 1. Mostrar menú de países
//                MenuPaises menu = new MenuPaises();
//                menu.imprimirMenu();
//
//                // 2. Capturar monedas
//                CapturaMoneda moneda = new CapturaMoneda();
//                moneda.seleccionaMoneda(scanner);
//
//                // 3. Capturar monto
//                CapturaMonto monto = new CapturaMonto();
//                double cantidad = monto.seleccionaMonto(scanner);
//
//                // 4. Realizar consulta a la API
//                ConsultaApi api = new ConsultaApi();
//                api.realizarConversion(
//                        moneda.getMonedaOrigen(),
//                        moneda.getMonedaDestino(),
//                        cantidad
//                );
//                //6. Preguntar si desea continuar
//                continuar = preguntarContinuar(scanner);
//            }
//
//            System.out.println("👋 ¡Gracias por usar el Conversor de Monedas!");
//
//        } finally {
//            scanner.close();
//        }
//    }
//
//    private static boolean preguntarContinuar(Scanner scanner) {
//        System.out.println("\n¿Qué deseas hacer ahora?");
//        System.out.println("↵ Enter - Realizar otra conversión");
//        System.out.println("ESC (o 'q') - Salir del programa");
//        System.out.print("Tu elección: ");
//
//        String input = scanner.nextLine().trim();
//
//        // Si presiona Enter (vacío) o cualquier tecla que no sea ESC/q, continuar
//        if (input.isEmpty() || (!input.equalsIgnoreCase("q") && !input.equalsIgnoreCase("esc"))) {
//            System.out.println("\n".repeat(3)); // Limpiar pantalla
//            return true;
//        } else {
//            return false;
//        }
//    }
//}

//*****************************************************************
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        try {
//            System.out.println("🌎 CONVERSOR DE MONEDAS INTERNACIONAL");
//            System.out.println("=====================================");
//
//            // 1. Mostrar menú de países
//            MenuPaises menu = new MenuPaises();
//            menu.imprimirMenu();
//
//            // 2. Capturar monedas
//            CapturaMoneda moneda = new CapturaMoneda();
//            moneda.seleccionaMoneda(scanner);
//
//            // 3. Capturar monto
//            CapturaMonto monto = new CapturaMonto();
//            double cantidad = monto.seleccionaMonto(scanner);
//
//            // 4. Realizar consulta a la API
//            ConsultaApi api = new ConsultaApi();
//            api.realizarConversion(
//                    moneda.getMonedaOrigen(),
//                    moneda.getMonedaDestino(),
//                    cantidad
//            );
//
//        } finally {
//            scanner.close();
//        }
//    }
//}






















////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
//// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//public class Main {
//    public static void main(String[] args) {
//            System.out.println("hello world");
//
//            MenuPaises menu = new MenuPaises();
//            menu.imprimirMenu();
//
//           CapturaMoneda moneda = new CapturaMoneda();
//           moneda.seleccionaMoneda();
//
//            // ver monto
//            CapturaMonto monto = new CapturaMonto();
//            monto.seleccionaMonto();
//        }
//    }
