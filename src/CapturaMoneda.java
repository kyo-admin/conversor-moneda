import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class CapturaMoneda {
    private String monedaOrigen;
    private String monedaDestino;

    private static final Set<String> MONEDAS_VALIDAS = new HashSet<>();

    static {
        String[] codigosISO = {
                "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN",
                "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL",
                "BSD", "BTN", "BWP", "BYN", "BZD", "CAD", "CDF", "CHF", "CLP", "CNY",
                "COP", "CRC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EGP",
                "ERN", "ETB", "EUR", "FJD", "FKP", "FOK", "GBP", "GEL", "GGP", "GHS",
                "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF",
                "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD",
                "JPY", "KES", "KGS", "KHR", "KID", "KMF", "KRW", "KWD", "KYD", "KZT",
                "LAK", "LBP", "LKR", "LRD", "LSL", "LYD", "MAD", "MDL", "MGA", "MKD",
                "MMK", "MNT", "MOP", "MRU", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN",
                "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK",
                "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR",
                "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLE", "SOS", "SRD", "SSP",
                "STN", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD",
                "TVD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VES", "VND",
                "VUV", "WST", "XAF", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMW", "ZWL"
        };

        for (String codigo : codigosISO) {
            MONEDAS_VALIDAS.add(codigo);
        }
    }

    public void seleccionaMoneda(Scanner scanner) {
        System.out.println("=== CAPTURA DE MONEDAS ISO 4217 ===");

        monedaOrigen = capturarYValidarMoneda(scanner, "origen");
        monedaDestino = capturarYValidarMoneda(scanner, "destino");

        // Validar que no sean la misma moneda
        if (monedaOrigen.equals(monedaDestino)) {
            System.out.println("⚠️  Advertencia: Las monedas de origen y destino son iguales");
        }

        System.out.println("✅ Monedas seleccionadas: " + monedaOrigen + " → " + monedaDestino);
    }

    private String capturarYValidarMoneda(Scanner scanner, String tipo) {
        while (true) {
            System.out.print("Ingrese moneda de " + tipo + " (3 letras): ");
            String moneda = scanner.nextLine().trim().toUpperCase();

            if (moneda.length() != 3) {
                System.out.println("❌ Error: El código debe tener exactamente 3 letras");
                continue;
            }

            if (!moneda.matches("[A-Z]{3}")) {
                System.out.println("❌ Error: Solo se permiten letras (A-Z)");
                continue;
            }

            if (!MONEDAS_VALIDAS.contains(moneda)) {
                System.out.println("❌ Error: '" + moneda + "' no es válido. Use códigos como:");
                System.out.println("   💡 Populares: USD, EUR, CLP, GBP, JPY, CAD, AUD");
                System.out.println("   💡 Latino: ARS, BRL, MXN, COP, PEN");
                continue;
            }

            return moneda; // Moneda válida
        }
    }

    // Getters
    public String getMonedaOrigen() { return monedaOrigen; }
    public String getMonedaDestino() { return monedaDestino; }

    // Método para verificar si una moneda es válida (útil para otras clases)
    public static boolean esMonedaValida(String moneda) {
        return MONEDAS_VALIDAS.contains(moneda.toUpperCase());
    }
}
//***************************************************************************************
//import java.util.Scanner;
//
//public class CapturaMoneda {
//    private String monedaOrigen;
//    private String monedaDestino;
//
//    public void seleccionaMoneda(Scanner scanner) {
//        System.out.println("=== CAPTURA DE MONEDAS ===");
//
//        System.out.print("Ingrese moneda de origen (ej: USD, EUR, CLP): ");
//        monedaOrigen = scanner.nextLine().toUpperCase();
//
//        System.out.print("Ingrese moneda de destino (ej: USD, EUR, CLP): ");
//        monedaDestino = scanner.nextLine().toUpperCase();
//
//        System.out.println("✅ Monedas seleccionadas: " + monedaOrigen + " → " + monedaDestino);
//    }
//
//    // Getters para acceder a los valores
//    public String getMonedaOrigen() { return monedaOrigen; }
//    public String getMonedaDestino() { return monedaDestino; }
//}



/// /////////////////////////////////////////////////////////////////////////////////////////////////////////////
//import java.util.Scanner;
//
//public class CapturaMoneda {
//    public void seleccionaMoneda() {
//        Scanner seleccionaMoneda = new Scanner(System.in);
//        String monedaOrigen = "";
//        String monedaDestino = ""; // Segunda variable agregada
//
//        /////////////////////////////////////////
//        System.out.println("=== CONVERSOR DE MONEDAS ===");
//
//        // Capturar moneda de ORIGEN
//        System.out.println("Ingrese la moneda de origen (ej: USD, EUR, CLP): ");
//        monedaOrigen = seleccionaMoneda.nextLine().toUpperCase();
//        System.out.println("Moneda de origen seleccionada: " + monedaOrigen);
//
//        // Capturar moneda de DESTINO
//        System.out.println("Ingrese la moneda de destino (ej: USD, EUR, CLP): ");
//        monedaDestino = seleccionaMoneda.nextLine().toUpperCase();
//        System.out.println("Moneda de destino seleccionada: " + monedaDestino);
//
//        // Mostrar ambas selecciones
//        System.out.println("\n--- Resumen de Conversión ---");
//        System.out.println("De: " + monedaOrigen + " → A: " + monedaDestino);
//
//        //seleccionaMoneda.close(); // Buen práctica: cerrar el Scanner
//    }
//}