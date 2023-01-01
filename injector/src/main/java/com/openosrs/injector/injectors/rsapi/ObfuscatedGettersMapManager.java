package com.openosrs.injector.injectors.rsapi;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Map;

public class ObfuscatedGettersMapManager {
    private static Map<String, Number> obfuscatedGettersMap;
    static {
        Type type = new TypeToken<Map<String, Number>>(){}.getType();
        try (Reader reader = new FileReader("./src/main/resources/mult.json")) {
            obfuscatedGettersMap = new Gson().fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Number getNumber(String classAndField) {
        return obfuscatedGettersMap.get(classAndField);
    }

    public ObfuscatedGettersMapManager() {}
}
