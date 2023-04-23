package Commands;

import com.mycompany.lab5.*;
import freemarker.template.*;
import java.awt.Desktop;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elias
 */
public class Report implements Generic{
    Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
    
    public void run ( Catalog catalog ) throws IOException
    {
        try { 
            cfg.setDirectoryForTemplateLoading(new File("C:\\Users\\Elias\\Desktop\\Facultate\\An II Sem 2\\JAVA\\lab5\\src\\main\\java\\com\\mycompany\\lab5\\Commands"));
        } catch (IOException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
        Map<String, Object> data = new HashMap<>();
        data.put("catalog", catalog);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
        cfg.setSQLDateAndTimeTimeZone(TimeZone.getDefault());
        Template temp = cfg.getTemplate("data.html");
        try (Writer out = new FileWriter("report.html")) {
            temp.process(data, out);
        } catch (TemplateException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
        File htmlFile = new File("report.html");
        Desktop.getDesktop().browse(htmlFile.toURI());
    }
}
