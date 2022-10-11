package ind.milo.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.utility.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2022/10/8 17:01
 * @Created by Milo
 */
@Slf4j
public class FreemarkerUtil {
    private  String ftlPath;
    private  String ftlName;
    private Configuration cfg;
    private Template template;

    public FreemarkerUtil(String ftlPath, String ftlName) {
        this.ftlPath = ftlPath;
        this.ftlName = ftlName;
//        config();
    }

    private void setConfig() throws IOException {
        cfg = new Configuration(Configuration.getVersion());
        cfg.setDirectoryForTemplateLoading(new File(ftlPath));
    }

    public void exce(Object dataModel) throws IOException, TemplateException {
        setConfig();
        template = cfg.getTemplate(ftlName);

        StringWriter stringWriter = new StringWriter();
        template.process(dataModel, stringWriter);
        String resultStr = stringWriter.toString();
        System.out.println(resultStr);
    }


    public static void main(String[] args) throws TemplateException, IOException {
        String ftlPath = "F:\\JavaFX\\HSTools\\src\\main\\resources\\ftl";
        String ftlName = "hello.ftl";
        FreemarkerUtil freemarkerUtil = new FreemarkerUtil(ftlPath, ftlName);
        Map map = new HashMap();
        map.put("hello", "Hello FreeMarker!");
        map.put("name", "这是一段带有攻击性的字符串请点击");
        freemarkerUtil.exce(map);

    }
}
