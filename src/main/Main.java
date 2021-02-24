
package main;

import java.io.IOException;

import postman.ModificarPostMan;

public class Main {
    /** plantilla postman entrada */
    static String NOMBRE_FICHERO_ENTRADA_PLANTILLA_POSTMAN = "plantilla.json";

    /** Modificar colecciones postman entrada */
    static String NOMBRE_FICHERO_COLECCION_ENTRADA_0 =
            "Operaciones proveedores 0.1.postman_collection.json";
    static String NOMBRE_FICHERO_COLECCION_ENTRADA_1 =
            "Operaciones proveedores 0.2.postman_collection.json";
    static String NOMBRE_FICHERO_COLECCION_ENTRADA_2 =
            "Operaciones proveedores 0.3.postman_collection.json";
    static String NOMBRE_FICHERO_COLECCION_ENTRADA_3 = "ColeccionPostman_fase_1_2.json";
    static String NOMBRE_FICHERO_COLECCION_ENTRADA_4 = "ColeccionPostman_fase_1_3.json";
    static String NOMBRE_FICHERO_COLECCION_ENTRADA_5 = "ColeccionPostman_fase_1_4.json";
    static String NOMBRE_FICHERO_COLECCION_ENTRADA_6 = "ColeccionPostman_fase_1_5.json";

    public static void main(String[] args) throws IOException {

        /** Modificar postman */
        ModificarPostMan modificarPostMan = new ModificarPostMan();
        modificarPostMan.generarSalida(NOMBRE_FICHERO_ENTRADA_PLANTILLA_POSTMAN,
                NOMBRE_FICHERO_COLECCION_ENTRADA_0, "0.1");
        modificarPostMan.generarSalida(NOMBRE_FICHERO_ENTRADA_PLANTILLA_POSTMAN,
                NOMBRE_FICHERO_COLECCION_ENTRADA_1, "0.2");
        modificarPostMan.generarSalida(NOMBRE_FICHERO_ENTRADA_PLANTILLA_POSTMAN,
                NOMBRE_FICHERO_COLECCION_ENTRADA_2, "0.3");
        modificarPostMan.generarSalida(NOMBRE_FICHERO_ENTRADA_PLANTILLA_POSTMAN,
                NOMBRE_FICHERO_COLECCION_ENTRADA_2, NOMBRE_FICHERO_COLECCION_ENTRADA_2);
        modificarPostMan.generarSalida(NOMBRE_FICHERO_ENTRADA_PLANTILLA_POSTMAN,
                NOMBRE_FICHERO_COLECCION_ENTRADA_3, NOMBRE_FICHERO_COLECCION_ENTRADA_3);
        modificarPostMan.generarSalida(NOMBRE_FICHERO_ENTRADA_PLANTILLA_POSTMAN,
                NOMBRE_FICHERO_COLECCION_ENTRADA_4, NOMBRE_FICHERO_COLECCION_ENTRADA_4);
        modificarPostMan.generarSalida(NOMBRE_FICHERO_ENTRADA_PLANTILLA_POSTMAN,
                NOMBRE_FICHERO_COLECCION_ENTRADA_5, NOMBRE_FICHERO_COLECCION_ENTRADA_5);
        modificarPostMan.generarSalida(NOMBRE_FICHERO_ENTRADA_PLANTILLA_POSTMAN,
                NOMBRE_FICHERO_COLECCION_ENTRADA_6, NOMBRE_FICHERO_COLECCION_ENTRADA_6);
        /** Fin Modificar postman */
    }
}
