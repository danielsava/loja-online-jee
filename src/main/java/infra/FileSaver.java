package infra;

import javax.servlet.http.Part;
import java.io.IOException;

public class FileSaver {

    public static final String SERVER_PATH =  "c:\\casadocodigo";

    public String write(Part arquivo, String path) {
        try {
            String relativePath = path + "\\" + arquivo.getSubmittedFileName();
            arquivo.write(SERVER_PATH + "\\" + relativePath);
            return relativePath;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
