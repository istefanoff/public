package Core;

import elements.*;
import enums.Fonts;

import java.io.*;
import java.util.*;

public class InputParser {
    private static List<Element> htmlList;
    private static Map<String, List<String>> cssMap;
    private BufferedReader bufferedReader;

    public InputParser() {
        htmlList = new LinkedList<>();
        cssMap = new LinkedHashMap<>();
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public  static List<Element> getHtmlList() {
        return htmlList;
    }

    public static Map<String, List<String>> getCssMap() {
        return cssMap;
    }

    public void parse(String line){
        String[] lineData = line.split("\\|");

        switch (lineData[0]){
            case"Header":
                String id = lineData[1];
                int size = Integer.parseInt(lineData[2]);
                String title = lineData[3];
                htmlList.add(new Header(id, size,title));
                break;
            case "Paragraph":
                String paragraphId = lineData[1];
                String content = lineData[2];
                htmlList.add(new Paragraph(paragraphId,content));
                break;
            case "List":
                String listId = lineData[1];
                String[] listElements = lineData[2].split(",");
                htmlList.add(new UnorderedList(listId, listElements));
                break;
            case"Text":
                String textID = lineData[1];
                Fonts textFont = Fonts.valueOf(lineData[2]);
                String text = lineData[3];
                htmlList.add(new Text(textID,textFont,text));
                break;
            case"CSS":
                String elementId = "#"+lineData[1];
                String firstProperty = lineData[2];
                String secondProperty = lineData[3];
                cssMap.putIfAbsent(elementId, new ArrayList<>());
                cssMap.get(elementId).add(firstProperty +": "+ secondProperty+";");
                break;
        }


    }
}
