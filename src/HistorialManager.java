import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistorialManager {
    private static final String ARCHIVO_HISTORIAL = "historial_conversiones.txt";
    private static final DateTimeFormatter formateadorFecha =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Método para guardar una conversión en el historial
    public static void guardarConversion(String monedaOrigen, String monedaDestino,
                                         double monto, double resultado) {
        try (FileWriter fw = new FileWriter(ARCHIVO_HISTORIAL, true); // true = append mode
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            String fechaHora = LocalDateTime.now().format(formateadorFecha);
            String registro = String.format("[%s] %s %.2f = %s %.4f",
                    fechaHora, monedaOrigen, monto, monedaDestino, resultado);

            out.println(registro);
            System.out.println("📝 Conversión guardada en historial");

        } catch (IOException e) {
            System.out.println("❌ Error al guardar en historial: " + e.getMessage());
        }
    }

    // Método para mostrar el historial completo
    public static void mostrarHistorial() {
        File archivo = new File(ARCHIVO_HISTORIAL);

        if (!archivo.exists()) {
            System.out.println("📊 No hay historial de conversiones aún");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_HISTORIAL))) {
            System.out.println("\n📊 HISTORIAL DE CONVERSIONES");
            System.out.println("══════════════════════════════════════════════════");

            String linea;
            int contador = 1;

            while ((linea = br.readLine()) != null) {
                System.out.println(contador + ". " + linea);
                contador++;
            }

            if (contador == 1) {
                System.out.println("No hay conversiones registradas");
            }

        } catch (IOException e) {
            System.out.println("❌ Error al leer historial: " + e.getMessage());
        }
    }

    // Método para limpiar el historial (opcional)
    public static void limpiarHistorial() {
        File archivo = new File(ARCHIVO_HISTORIAL);
        if (archivo.exists() && archivo.delete()) {
            System.out.println("🗑️ Historial eliminado");
        } else {
            System.out.println("❌ No se pudo eliminar el historial");
        }
    }
}