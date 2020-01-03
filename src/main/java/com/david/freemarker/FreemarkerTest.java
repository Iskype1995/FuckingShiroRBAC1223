package com.david.freemarker;

import freemarker.template.*;
import java.util.*;
import java.io.*;

public class FreemarkerTest {
    public static void main(String[] args) throws Exception {
        Configuration configuration = new Configuration(Configuration.getVersion());
        configuration.setDirectoryForTemplateLoading(new File("src\\main\\webapp\\WEB-INF\\ftl"));
        configuration.setDefaultEncoding("UTF-8");
        Template template = configuration.getTemplate("template.ftl");
        HashMap map = new HashMap<>();
        map.put("msg","<h1><font color='red'>张柏芝又黑又紧</font></h1>");
        map.put("doctype","html");
        map.put("age",18);
        map.put("switcher","Bitch");
        map.put("fuckked","马蓉的炭烤纯黑骚屄");
        List list = new LinkedList();
        list.add("张柏芝");
        list.add("阿娇");
        list.add("范冰冰");
        list.add("谢芷惠");
        list.add("陈文媛");
        map.put("list",list);

        map.put("avg1", 654.32);
        map.put("avg2", 12345.6789);
        map.put("avg3", 88888.76543210);
        FileWriter fileWriter = new FileWriter("src\\main\\webapp\\WEB-INF\\html\\template.html");
        template.process(map, fileWriter);
        fileWriter.close();
    }
}