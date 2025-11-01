// Convierte el Json a Objeto Java

public class ApiResponse {
    private double conversion_result;
    private String base_code;
    private String target_code;

    // Getters y Setters
    public double getConversionResult() { return conversion_result; }
    public void setConversionResult(double conversion_result) { this.conversion_result = conversion_result; }

    public String getBaseCode() { return base_code; }
    public void setBaseCode(String base_code) { this.base_code = base_code; }

    public String getTargetCode() { return target_code; }
    public void setTargetCode(String target_code) { this.target_code = target_code; }
}