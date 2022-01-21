import Core.CSSgenerator;
import Core.HTMLgenerator;
import Core.InputParser;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        //header|size|content
        //paragraph|content
        //list|var args...
        //text|format|content   ( format = normal, italic, bold)

    HTMLgenerator HTMLGenerator = new HTMLgenerator();
    CSSgenerator CSSgenerator = new CSSgenerator();
    InputParser inputParser = new InputParser();

       String line = input.readLine();


       while (!line.equals("Exit")) {

           inputParser.parse(line);

           line = input.readLine();
       }

        try{
       HTMLGenerator.generate();
       CSSgenerator.generate();
        }catch (IOException e){
            System.out.println("error");
        }


    }
}


// TODO: MAKE EVERY COMMAND ACCEPT ADDITIONAL PARAMETER -> ID
//       MAKE ADDITIONAL COMMAND -> CSS|{id}|{property}|{value}
//       EXAMPLE: Text|random-text|ITALICS|Lorem Ipsum Il Fador
//                CSS|random-text|background-color|blue
//       THE CHALLENGE IS THAT YOU HAVE TO GENERATE A SINGLE CSS SELECTOR AT THE END
//       EXAMPLE: Text|random-text|ITALICS|Lorem Ipsum Il Fador
//                CSS|random-text|background-color|blue
//                CSS|random-text|color|red
//                CSS|random-text|width|100%
//                CSS|random-text|text-align|center
//       THIS SHOULD RESULT IN:
//       HTML: <div id="random-text"><i>Lorem Ipsum Il Fador</i></div>
//       CSS: #random-text
//            {
//                background-color: blue;
//                color: red;
//                width: 100%;
//                text-align: center;
//            }