package independentcopy;

import java.io.FileWriter;

public class ListWriter implements Writer {
    ArrayList<String> list = new ArrayList<String>();
    FileWriter writer = new FileWriter("data.txt");
    for(String str: list) {
            writer.write(str);
        }
    writer.close();
}