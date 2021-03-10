package postman;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ModificarPostMan {

    static JSONParser parser = new JSONParser();
    String FASE = "0";
    int numPruebaInicial = 1;

    public StringBuffer generarSalida(String plantilla, String nombreFichero,
            String nombreInicioPrueba) {
        StringBuffer sfRespuesta = new StringBuffer();
        try {

            // Pares de ficheros, poner de dos en dos
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(nombreFichero));
            // Elemento item (tiene el nombre carpeta y el array item)
            JSONArray arrayItemGeneral = (JSONArray) jsonObject.get("item");
            for (int i = 0; i < arrayItemGeneral.size(); i++) {
                JSONObject itemsGeneral = (JSONObject) arrayItemGeneral.get(i);
                JSONArray items = (JSONArray) itemsGeneral.get("item");

                for (int z = 0; z < items.size(); z++) {
                    JSONObject item = (JSONObject) items.get(z);

                    JSONArray execPlantilla = obtenerExec(plantilla);

                    JSONArray event = (JSONArray) item.get("event");
                    JSONObject event0 = (JSONObject) event.get(0);
                    JSONObject script = (JSONObject) event0.get("script");
                    JSONArray exec = (JSONArray) script.get("exec");
                    String nombrePrograma = obtenerNombrePrograma(exec, nombreInicioPrueba);
                    exec.clear();
                    exec = execPlantilla;
                    // System.out.println(exec);
                    exec.set(2, nombrePrograma);
                    // System.out.println(exec);
                    script.put("exec", exec);
                    numPruebaInicial++;
                }
            }
            // Grabar el objeto
            GrabarFichero grabarFichero = new GrabarFichero();
            grabarFichero.crearFichero("M" + nombreFichero, true);
            grabarFichero.agregarAFichero(jsonObject.toJSONString());
            grabarFichero.cerrarFichero();
            sfRespuesta.append(jsonObject.toJSONString());
        }

        catch (

        Exception e) {
            System.out.println(e);
        }
        finally {
            System.out.println("  Fin de proceso");

            return sfRespuesta;
        }
    }

    private JSONArray obtenerExec(String plantilla)
            throws FileNotFoundException, IOException, ParseException {
        // PLANTILLA CON SCRIPTS
        JSONObject jsonObjectP = (JSONObject) parser.parse(new FileReader(plantilla));
        // Elemento item (tiene el nombre carpeta y el array item)
        JSONArray arrayItemGeneralP = (JSONArray) jsonObjectP.get("item");
        JSONObject itemsGeneralP = (JSONObject) arrayItemGeneralP.get(0);
        JSONArray itemsP = (JSONArray) itemsGeneralP.get("item");
        JSONObject itemPplantilla = (JSONObject) itemsP.get(0);

        JSONArray eventP = (JSONArray) itemPplantilla.get("event");
        JSONObject event0P = (JSONObject) eventP.get(0);
        JSONObject scriptP = (JSONObject) event0P.get("script");
        JSONArray execP = (JSONArray) scriptP.get("exec");
        return execP;
    }

    private boolean contienePalabra(String cadena, String buscar) {
        return (cadena.contains(buscar));
    }

    private String obtenerNombrePrograma(JSONArray exec, String nombreInicioPrueba) {
        return "const NOMBRE_PRUEBA = \"fase_" + nombreInicioPrueba + "_prueba_#_"
                + numPruebaInicial + "\";";
        // for (int i = 0; i < exec.size(); i++) {
        // if (contienePalabra((String) exec.get(i), "const NOMBRE_PRUEBA")) {
        // System.out.println((String) exec.get(i));
        // return (String) exec.get(i);
        // }
        // }
        // return "";
    }

}
