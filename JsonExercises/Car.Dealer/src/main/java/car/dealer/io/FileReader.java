package car.dealer.io;


import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileReader {
    public String readFile(String path){

        StringBuilder stringBuilder = new StringBuilder();

        try (
                InputStream is = this.getClass().getResourceAsStream(path);
                BufferedReader bf = new BufferedReader(new InputStreamReader(is))
        ){

            String line  = bf.readLine();

            while (line!=null){
                stringBuilder.append(line);
                line = bf.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }

    public  void writeFile(String path, String content){
       File file = new File(System.getProperty("user.dir")+ path);

       if (!file.exists()){

           try {
               file.createNewFile();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
        try(
                OutputStream os = new FileOutputStream(System.getProperty("user.dir")+ path);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os))

                ){
            bw.write(content);

        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

}
