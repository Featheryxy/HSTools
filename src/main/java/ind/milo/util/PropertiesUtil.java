package ind.milo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil {
    private Properties properties;
    private Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    public PropertiesUtil(String fileName) {
        readProperties(fileName);
    }

    private void readProperties(String fileName) {
        logger.info("读取配置文件: {}", fileName);
        properties = new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        try {
            properties.load(inputStreamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据key读取对应的value
     *
     * @param key
     * @return
     */
    public String get(String key) {
        return properties.getProperty(key);
    }


    /**
     * 得到所有的配置信息
     *
     * @return
     */
    public Map<?, ?> getAll() {
        Map<String, String> map = new HashMap<String, String>();
        Enumeration<?> enu = properties.propertyNames();
        while (enu.hasMoreElements()) {
            String key = (String) enu.nextElement();
            String value = properties.getProperty(key);
            map.put(key, value);
        }
        return map;
    }

    public static void main(String[] args) {
        PropertiesUtil prop = new PropertiesUtil("config.properties");
        System.out.println(prop.get("jobnumber"));
    }
}
