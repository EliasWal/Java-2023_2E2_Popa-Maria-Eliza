package Commands;

import java.awt.Desktop;
import java.io.*;

/**
 *
 * @author Elias
 */
public class View implements Generic {
    public void run(String path) throws IOException{
        Desktop.getDesktop().open(new File(path));
    }
}
