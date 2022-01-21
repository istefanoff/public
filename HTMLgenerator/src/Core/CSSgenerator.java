package Core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSSgenerator extends GeneratorImpl implements Generator {
   // Map<String, List<String>> cssMap; //


    public CSSgenerator() throws IOException {
        super.bufferedWriter = new BufferedWriter(new FileWriter("stylesheet.css"));
    }

    @Override
    public void generate() throws IOException {
        InputParser.getCssMap().forEach((key, value) -> {
            try {
                bufferedWriter.write(key + System.lineSeparator() +"{" + System.lineSeparator());
                for (String s : value) {
                    bufferedWriter.write(s + System.lineSeparator());
                }
                bufferedWriter.write("}" + System.lineSeparator());
            } catch (IOException err) {
                System.out.println("error while generating css");
            }


        });
        bufferedWriter.close();
//        InputParser.getCssMap().entrySet().forEach(e -> {
//            try {
//                bufferedWriter.write("#" + e.getKey().getClass().getDeclaredField("id") + System.lineSeparator() + "\\{" + System.lineSeparator());
//
//            for (String s : e.getValue()) {
//                bufferedWriter.write(s + System.lineSeparator());
//            }
//            bufferedWriter.write("\\}" + System.lineSeparator());
//
//            } catch (IOException | NoSuchFieldException ex) {
//                ex.printStackTrace();
//            }
//
//        });
    }
//    //private class Test {
//   private List<String> list;
//}
//then you can get it via reflection:
//
//Type type = ((ParameterizedType) Test.class.getDeclaredField("list")
//     .getGenericType()).getActualTypeArguments()[0];

    //        bufferedWriter.write(HTMLSkeletonEnum.HTMLSkeleton.getText());
    //        for (Element htmLelement : InputParser.getHtmlList()) {
    //        bufferedWriter.write(htmLelement.toString() + System.lineSeparator());
    //
    //        }
    //        bufferedWriter.write("</body>\n</html>");
    //        bufferedWriter.close();
}
