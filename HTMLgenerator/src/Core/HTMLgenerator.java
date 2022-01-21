package Core;

import elements.*;
import enums.Constants.HTMLSkeletonEnum;

import java.io.*;
import java.util.Date;


public class HTMLgenerator extends GeneratorImpl implements Generator {

    public HTMLgenerator() throws IOException {
        super.bufferedWriter = new BufferedWriter(new FileWriter(new Date().getTime()+".html"));
    }

    @Override
    public void generate() throws IOException {
        bufferedWriter.write(HTMLSkeletonEnum.HTMLSkeleton.getText());
        for (Element htmLelement : InputParser.getHtmlList()) {
        bufferedWriter.write(htmLelement.toString() + System.lineSeparator());

        }
        bufferedWriter.write("</body>\n</html>");
        bufferedWriter.close();
    }


}
