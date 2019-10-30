import java.io.*;
import java.util.*;

public class ListToFile {


    private static String generate()
    {
        StringBuilder str=new StringBuilder();
        Random rand=new Random();
        for (int i = 0; i <rand.nextInt(30-10)+10 ; i++) {
            str.append((char)(rand.nextInt(122-97)+97));
        }

        return str.toString();
    }

    private static List<String> generateList()
    {
        List<String> l=new ArrayList<String>();
        for (int i = 0; i <30 ; i++) {
            l.add(generate());
        }
        return l;
    }
    private static void sortString(List<String> list) {


        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.length()-t1.length();
            }

        });

    }
    private static File WriteToFile(File file,List<String> list) throws IOException {
        FileWriter write=new FileWriter(file);

        for(String s:list) {
            write.write(s);
            write.write("\n");
        }
        write.close();
        return file;
    }
    public static List<String> ReadFile(File f) throws IOException {
        FileReader file=new FileReader(f);
        BufferedReader buf=new BufferedReader(file);
        List<String> list=new ArrayList<String >();
        String str;
        while ((str=buf.readLine())!=null)
            list.add(str);


        return list;
    }

    public static void main(String[] args) throws IOException {
        List<String> list=generateList();
        File file=new File("output.txt");
        File WritenFile= WriteToFile(file,list);


        List<String> read=ReadFile(new File(String.valueOf(WritenFile)));

        sortString(read);

        WriteToFile(new File("SortedOutput.txt"),read);

    }
}
