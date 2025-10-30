package lecteurFichiers.readers;

import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lecteurFichiers.ReadAbstract;

public class JsonRead extends ReadAbstract {
    public JsonRead(String pathFile) {
        super(pathFile);
    }

    @Override
    public void read() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(new File(this.pathFile));
            // override toString
            System.out.println(root.toPrettyString()); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
