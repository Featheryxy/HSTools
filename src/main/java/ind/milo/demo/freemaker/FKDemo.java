package ind.milo.demo.freemaker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Date 2022/10/8 16:34
 * @Created by Milo
 */
public class FKDemo {
    public static void step() throws IOException, TemplateException {
        // 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是FreeMarker对于的版本号。
        Configuration configuration = new Configuration(Configuration.getVersion());

        // 第二步：设置模板文件所在的路径。
        configuration.setDirectoryForTemplateLoading(new File("/ftl"));

        // 第三步：设置模板文件使用的字符集。一般就是utf-8.
        configuration.setDefaultEncoding("utf-8");

        // 第四步：加载一个模板，创建一个模板对象。
        Template template = configuration.getTemplate("hello.ftl");

        // 第五步：创建一个模板使用的数据集，可以是pojo也可以是map。一般是Map。
        Map dataModel = new HashMap<>();

        //向数据集中添加数据
        dataModel.put("hello", "this is my first FreeMarker test.");

        // 第六步：创建一个Writer对象，一般创建一FileWriter对象，指定生成的文件名。
        Writer out = new FileWriter(new File("/hello.html"));

        // 第七步：调用模板对象的process方法输出文件。
        template.process(dataModel, out);

        // 第八步：关闭流。
        out.close();
    }

    public static void main(String[] args) throws IOException, TemplateException {
        System.out.println(new File("ftl").getAbsolutePath());
        Configuration cfg = new Configuration(Configuration.getVersion());
        cfg.setDirectoryForTemplateLoading(new File("F:\\JavaFX\\HSTools\\src\\main\\resources\\ftl"));
        Template template = cfg.getTemplate("hello.ftl");
        Map map = new HashMap();
        map.put("hello", "Hello FreeMarker!");
        map.put("name", "这是一段带有攻击性的字符串请点击");
        StringWriter stringWriter = new StringWriter();
        template.process(map, stringWriter);
        String resultStr = stringWriter.toString();
        System.out.println(resultStr);
    }
}
