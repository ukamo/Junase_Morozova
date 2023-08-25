package fiori.utils;

import eu.ibagroup.junase.model.util.FileUtil;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PropertiesReader {

    /**
     * The method parses JSON file and returns the value for the corresponding key.
     *
     * @param fileName ,
     * @param key ,
     * @return value
     */
    public static String parseJSONFile(String fileName, String key) throws IOException, ParseException {
        File importFile = FileUtil.createFileFromResource(fileName);
        Object object = new JSONParser().parse(new FileReader(importFile));
        JSONObject jsonObject = (JSONObject) object;
        return jsonObject.get(key).toString();
    }
}
