package independentcopy;

import java.util.Scanner;

public class ListReader implements Reader {
    Scanner s = new Scanner(new File("data.txt"));
    ArrayList<String> list = new ArrayList<String>();
    while (s.hasNext()){
            list.add(s.next());
        }
    s.close();
}