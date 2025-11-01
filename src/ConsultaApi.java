
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class ConsultaApi {
    private Gson gson = new Gson();

    public void realizarConversion(String monedaOrigen, String monedaDestino, double monto) {
        try {
            // Formatear el monto
            String montoFormateado = formatearMontoParaAPI(monto);

            String url = String.format(
                    "https://v6.exchangerate-api.com/v6/f15b4c7acecc5766c2fd7bfe/pair/%s/%s/%s",
                    monedaOrigen, monedaDestino, montoFormateado);
            String urlninja = String.format(
                    "https://v6.exchangerate-api.com/v6/URL-Ninja/pair/%s/%s/%s",
                    monedaOrigen, monedaDestino, montoFormateado
            );

            //System.out.println("🔗 Consultando API: " + url);
            System.out.println("🔗 Consultando API: " +  urlninja);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            procesarRespuestaConGson(response.body(), monedaOrigen, monedaDestino, monto);

        } catch (Exception e) {
            System.out.println("❌ Error al consultar la API: " + e.getMessage());
        }
    }

    private void procesarRespuestaConGson(String jsonRespuesta, String monedaOrigen, String monedaDestino, double monto) {
        try {
            // Convertir JSON a objeto Java automáticamente
            ApiResponse respuesta = gson.fromJson(jsonRespuesta, ApiResponse.class);

            double resultado = respuesta.getConversionResult();

            // ✅ NUEVO: Guardar en historial ANTES de mostrar resultado
            HistorialManager.guardarConversion(monedaOrigen, monedaDestino, monto, resultado);

            System.out.println("\n💰 RESULTADO DE LA CONVERSIÓN:");
            System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
            System.out.printf("%s %s = %s %.4f%n",
                    monedaOrigen,
                    formatearMontoParaAPI(monto),
                    monedaDestino,
                    resultado
            );
            System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");

        } catch (Exception e) {
            System.out.println("❌ Error procesando JSON: " + e.getMessage());
            System.out.println("JSON recibido: " + jsonRespuesta);
        }
    }

    private String formatearMontoParaAPI(double monto) {
        if (monto == (int) monto) {
            return String.valueOf((int) monto);
        } else {
            return String.valueOf(monto);
        }
    }
}
//***************************************************************************************************************
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import com.google.gson.Gson;
//
//public class ConsultaApi {
//    private Gson gson = new Gson();
//
//    public void realizarConversion(String monedaOrigen, String monedaDestino, double monto) {
//        try {
//            // Formatear el monto
//            String montoFormateado = formatearMontoParaAPI(monto);
//
//            String url = String.format(
//                    "https://v6.exchangerate-api.com/v6/f15b4c7acecc5766c2fd7bfe/pair/%s/%s/%s",
//                    monedaOrigen, monedaDestino, montoFormateado);
//            String urlninja = String.format(
//                    "https://v6.exchangerate-api.com/v6/URL-Ninja/pair/%s/%s/%s",
//                    monedaOrigen, monedaDestino, montoFormateado
//            );
//
//            //System.out.println("🔗 Consultando API: " + url);
//            System.out.println("🔗 Consultando API: " +  urlninja);
//
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(url))
//                    .GET()
//                    .build();
//
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            procesarRespuestaConGson(response.body(), monedaOrigen, monedaDestino, monto);
//
//        } catch (Exception e) {
//            System.out.println("❌ Error al consultar la API: " + e.getMessage());
//        }
//    }
//
//    private void procesarRespuestaConGson(String jsonRespuesta, String monedaOrigen, String monedaDestino, double monto) {
//        try {
//            // Convertir JSON a objeto Java automáticamente
//            ApiResponse respuesta = gson.fromJson(jsonRespuesta, ApiResponse.class);
//
//            double resultado = respuesta.getConversionResult();
//
//            System.out.println("\n💰 RESULTADO DE LA CONVERSIÓN:");
//            System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
//            System.out.printf("%s %s = %s %.4f%n",
//                    monedaOrigen,
//                    formatearMontoParaAPI(monto),
//                    monedaDestino,
//                    resultado
//            );
//            System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
//
//        } catch (Exception e) {
//            System.out.println("❌ Error procesando JSON: " + e.getMessage());
//            System.out.println("JSON recibido: " + jsonRespuesta);
//        }
//    }
//
//    private String formatearMontoParaAPI(double monto) {
//        if (monto == (int) monto) {
//            return String.valueOf((int) monto);
//        } else {
//            return String.valueOf(monto);
//        }
//    }
//}
//*****************************************************************************************************
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import com.google.gson.Gson;
//
//public class ConsultaApi {
//    private Gson gson = new Gson();
//
//    public void realizarConversion(String monedaOrigen, String monedaDestino, double monto) {
//        try {
//            // Formatear el monto
//            String montoFormateado = formatearMontoParaAPI(monto);
//
//            String url = String.format(
//                    "https://v6.exchangerate-api.com/v6/f15b4c7acecc5766c2fd7bfe/pair/%s/%s/%s",
//                    monedaOrigen, monedaDestino, montoFormateado);
//            String urlninja = String.format(
//                    "https://v6.exchangerate-api.com/v6/URL-Ninja/pair/%s/%s/%s",
//                    monedaOrigen, monedaDestino, montoFormateado
//            );
//
//            //System.out.println("🔗 Consultando API: " + url);
//            System.out.println("🔗 Consultando API: " +  urlninja);
//
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(url))
//                    .GET()
//                    .build();
//
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            procesarRespuestaConGson(response.body(), monedaOrigen, monedaDestino, monto);
//
//        } catch (Exception e) {
//            System.out.println("❌ Error al consultar la API: " + e.getMessage());
//        }
//    }
//
//    private void procesarRespuestaConGson(String jsonRespuesta, String monedaOrigen, String monedaDestino, double monto) {
//        try {
//            // Convertir JSON a objeto Java automáticamente
//            ApiResponse respuesta = gson.fromJson(jsonRespuesta, ApiResponse.class);
//
//            double resultado = respuesta.getConversionResult();
//
//            System.out.println("\n💰 RESULTADO DE LA CONVERSIÓN:");
//            System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
//            System.out.printf("%s %s = %s %.4f%n",
//                    monedaOrigen,
//                    formatearMontoParaAPI(monto),
//                    monedaDestino,
//                    resultado
//            );
//            System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
//
//        } catch (Exception e) {
//            System.out.println("❌ Error procesando JSON: " + e.getMessage());
//            System.out.println("JSON recibido: " + jsonRespuesta);
//        }
//    }
//
//    private String formatearMontoParaAPI(double monto) {
//        if (monto == (int) monto) {
//            return String.valueOf((int) monto);
//        } else {
//            return String.valueOf(monto);
//        }
//    }
//}
//***************************************************************************************************************
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//
//public class ConsultaApi {
//
//    public void realizarConversion(String monedaOrigen, String monedaDestino, double monto) {
//        try {
//            // Formatear el monto SIN decimales si es entero
//            String montoFormateado = formatearMontoParaAPI(monto);
//
//            String url = String.format(
//                    "https://v6.exchangerate-api.com/v6/f15b4c7acecc5766c2fd7bfe/pair/%s/%s/%s",
//                    monedaOrigen, monedaDestino, montoFormateado
//            );
//
//            System.out.println("🔗 Consultando API: " + url);
//
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(url))
//                    .GET()
//                    .build();
//
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            procesarRespuesta(response.body(), monedaOrigen, monedaDestino, monto);
//
//        } catch (Exception e) {
//            System.out.println("❌ Error al consultar la API: " + e.getMessage());
//        }
//    }
//
//    private String formatearMontoParaAPI(double monto) {
//        // Si el monto es entero (ej: 1000.0), quitar decimales
//        if (monto == (int) monto) {
//            return String.valueOf((int) monto); // Devuelve "1000"
//        } else {
//            return String.valueOf(monto); // Devuelve "1500.50"
//        }
//    }
//
//    private void procesarRespuesta(String jsonRespuesta, String monedaOrigen, String monedaDestino, double monto) {
//        try {
//            String[] partes = jsonRespuesta.split("\"conversion_result\":");
//            if (partes.length > 1) {
//                String resultadoParte = partes[1].split(",")[0];
//                double resultado = Double.parseDouble(resultadoParte);
//
//                System.out.println("\n💰 RESULTADO DE LA CONVERSIÓN:");
//                System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
//                System.out.printf("%s %s = %s %.2f%n",
//                        monedaOrigen,
//                        formatearMontoParaAPI(monto), // Usar mismo formateo para mostrar
//                        monedaDestino,
//                        resultado
//                );
//                System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
//            } else {
//                System.out.println("❌ No se pudo obtener el resultado");
//            }
//        } catch (Exception e) {
//            System.out.println("❌ Error al procesar respuesta: " + e.getMessage());
//        }
//    }
//}




//***************************************************************************************************************
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.util.Scanner;
//
//public class ConsultaApi {
//
//    public void realizarConversion(String monedaOrigen, String monedaDestino, double monto) {
//        try {
//            // Construir la URL con los parámetros
//            String url = String.format(
//                    "https://v6.exchangerate-api.com/v6/f15b4c7acecc5766c2fd7bfe/pair/%s/%s/%.2f",
//                    monedaOrigen, monedaDestino, monto
//            );
//
//            System.out.println("🔗 Consultando API: " + url);
//
//            // Crear cliente HTTP
//            HttpClient client = HttpClient.newHttpClient();
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(url))
//                    .GET()
//                    .build();
//
//            // Enviar solicitud y obtener respuesta
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//            // Procesar la respuesta
//            procesarRespuesta(response.body(), monedaOrigen, monedaDestino, monto);
//
//        } catch (Exception e) {
//            System.out.println("❌ Error al consultar la API: " + e.getMessage());
//        }
//    }
//
//    private void procesarRespuesta(String jsonRespuesta, String monedaOrigen, String monedaDestino, double monto) {
//        // Extraer el resultado de la conversión del JSON
//        // Ejemplo de respuesta: {"conversion_result":85.50,"base_code":"USD","target_code":"EUR"}
//
//        try {
//            // Buscar el campo "conversion_result" en el JSON
//            String[] partes = jsonRespuesta.split("\"conversion_result\":");
//            if (partes.length > 1) {
//                String resultadoParte = partes[1].split(",")[0];
//                double resultado = Double.parseDouble(resultadoParte);
//
//                System.out.println("\n💰 RESULTADO DE LA CONVERSIÓN:");
//                System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
//                System.out.printf("%s %.2f = %s %.2f%n", monedaOrigen, monto, monedaDestino, resultado);
//                System.out.println("▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬");
//            } else {
//                System.out.println("❌ No se pudo obtener el resultado de la conversión");
//                System.out.println("Respuesta completa: " + jsonRespuesta);
//            }
//
//        } catch (Exception e) {
//            System.out.println("❌ Error al procesar la respuesta: " + e.getMessage());
//            System.out.println("Respuesta recibida: " + jsonRespuesta);
//        }
//    }
//}