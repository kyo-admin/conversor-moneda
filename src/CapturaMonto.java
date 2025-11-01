import java.util.Scanner;

public class CapturaMonto {
    public double seleccionaMonto(Scanner scanner) {
        while (true) {
            try {
                System.out.print("💵 Ingrese el monto a convertir: ");
                String input = scanner.nextLine().trim();

                // Validar que no esté vacío
                if (input.isEmpty()) {
                    System.out.println("❌ Error: No puede estar vacío");
                    continue;
                }

                // Validar que sea número
                double monto;
                try {
                    monto = Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    System.out.println("❌ Error: '" + input + "' no es un número válido");
                    continue;
                }

                // Validar que sea positivo
                if (monto <= 0) {
                    System.out.println("❌ Error: El monto debe ser mayor a 0");
                    continue;
                }

                // Validar que no sea demasiado grande
                if (monto > 1_000_000_000) {
                    System.out.println("❌ Error: El monto es demasiado grande");
                    continue;
                }

                System.out.println("✅ Monto ingresado: " + monto);
                return monto;

            } catch (Exception e) {
                System.out.println("❌ Error inesperado: " + e.getMessage());
            }
        }
    }
}

/// ////////////////////////////////////////////////////////////////////////////////////////////////////////

//import java.util.Scanner;
//
//public class CapturaMonto {
//    public double seleccionaMonto(Scanner scanner) {  // ← AGREGAR parámetro Scanner
//        System.out.print("Ingrese el monto a convertir: ");
//        double monto = scanner.nextDouble();
//        scanner.nextLine(); // Consumir salto de línea
//
//        System.out.println("✅ Monto ingresado: " + monto);
//        return monto;
//    }
//}
/// ////////////////////////////////////////////////////////////////////////////////////////////////////////
//import java.util.Scanner;
//
//public class CapturaMonto {
//    public double seleccionaMonto( ) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Ingrese el monto a convertir: ");
//        double monto = scanner.nextDouble();
//
//        System.out.println("el monto ingresado es: "+monto);
//
//        //scanner.close();
//        return monto;
//    }
//}