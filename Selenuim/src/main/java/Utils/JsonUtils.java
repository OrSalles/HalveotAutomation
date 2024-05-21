package Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtils {

    /**
     * Return json object
     *
     * @param partialPath to the file json
     * @param key         key in the file
     * @return json object
     */

    public static JSONObject returnJsonObject(String partialPath, String key) throws IOException {
        String path = "src/test/resources/" + partialPath;

        String content = readFile(path, StandardCharsets.UTF_8);

        JSONTokener tokener = new JSONTokener(content);

        JSONObject jsonObject = new JSONObject(tokener);
        return (JSONObject) jsonObject.get(key);
    }



    public static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }


}














