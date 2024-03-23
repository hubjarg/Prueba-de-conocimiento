import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClaroTest {
    public static void main(String[] args) {
            if (args.length < 1) {
                System.out.println("Ingresa un archivo que contenga una clase de java para describir los atributos y las firmas de los metodos que contenga");
                return;
            }
                 String rutaDelArchivo = args[0];
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(rutaDelArchivo));
            StringBuilder contenido = new StringBuilder();
            String linea;

            while ((linea = bufferedReader.readLine()) != null)
            {
                contenido.append(linea).append("\n");
            }
            bufferedReader.close();
                String strContenido = contenido.toString();
                Pattern patronBuscaClase = Pattern.compile("(private|protected|public|static)\\s+class\\s+(\\w+)\\s*\\{");
                Matcher coicidenciapatronClase = patronBuscaClase.matcher(strContenido);
                if (coicidenciapatronClase.find())
                 {
                    String scope = coicidenciapatronClase.group(1);
                    String nombreClase = coicidenciapatronClase.group(2);
                    System.out.println("Class Name: " + nombreClase);
                    System.out.println("Scope: " + scope);
                    System.out.println("Constructor: " + nombreClase);
                 }
                 
                    dibujarTablaEncabezado();
                    Pattern patronBuscaAtributo = Pattern.compile("(public|protected|private|static)?\\s+(\\w+)\\s+(\\w+)(\\s*=\\s*.+)?;");
                    Matcher  coicidenciaPatronAtributo = patronBuscaAtributo.matcher(strContenido);

                    while (coicidenciaPatronAtributo.find()) {
                        String scope = coicidenciaPatronAtributo.group(1); 
                        String signatur = " Type: ".concat(coicidenciaPatronAtributo.group(2));
                        String nombre = coicidenciaPatronAtributo.group(3); 
                        String vari = "A";
                        dibujarTablaFila(nombre, vari, scope, signatur);
                    }
                   //IMPRIMIR ROWS
                   Pattern patronBuscaMetodo = Pattern.compile("(public|protected|private|static)\\s+(\\w+)\\s+(\\w+)\\s*\\((.*?)\\)");
                   Matcher   coicidenciaPatronMetodo= patronBuscaMetodo.matcher(strContenido);

                   while (coicidenciaPatronMetodo.find()) {
                       String scope = coicidenciaPatronMetodo.group(1); 
                       String signature = coicidenciaPatronMetodo.group(2);
                       String name = coicidenciaPatronMetodo.group(3); 
                       String params = coicidenciaPatronMetodo.group(4);
                       String vari = "M";
                       String signatur =" RTYPE: ".concat(signature).concat(", PARAMS:").concat(params);
                       dibujarTablaFila(name, vari, scope, signatur );                                             
                   }

                
                   //FIN 
                    dibujarTablaPie();
             } catch (IOException e) {
                 System.out.println("Error al leer el archivo: " + e.getMessage());
             }
    }

    private static void dibujarTablaEncabezado() {
        System.out.format(" -------------------------------------------------------------------------------------------%n");
        System.out.format("| NAME            | VARI            | SCOPE      | SIGNATURE                               |%n");
        System.out.format(" -------------------------------------------------------------------------------------------%n");
    }

    private static void dibujarTablaFila(String name, String vari, String scope, String signature) {
        String alinearizq = "| %-15s | %-15s | %-10s | %-40s |%n";
        System.out.format(alinearizq, name, vari, scope, signature);
    }

    private static void dibujarTablaPie() {
        System.out.format("--------------------------------------------------------------------------------------------%n");
    }
}
