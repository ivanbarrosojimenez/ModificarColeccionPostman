package postman;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GrabarFichero {

    static File f;
    static FileWriter w;
    static BufferedWriter bw;
    static PrintWriter wr;

    public void crearFichero(String nombre) throws IOException {
        f = new File(nombre);
        w = new FileWriter(f);
        bw = new BufferedWriter(w);
        wr = new PrintWriter(bw);
    }

    public void agregarAFichero(String contenido) throws IOException {
        wr.write(contenido);
    }

    public void cerrarFichero() throws IOException {
        wr.flush();
        wr.close();
        bw.close();
    }
}
