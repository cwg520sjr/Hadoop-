package hadoop.ch03.V17034460115;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.*;
import java.net.URI;

public class ReadHDFSFile {
    public static void main(String[] args) throws Exception{
        Configuration conf = new Configuration();
        URI uri = new URI("hdfs://192.168.30.131:8020");
        FileSystem fs = FileSystem.get(uri, conf, "hadoop");
        Path dfs =new Path("/17034460115.test2.txt");

        FSDataInputStream in = fs.open(dfs);
        BufferedReader d = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while ((line = d.readLine()) != null) {
            String[] strarray = line.split(" ");
            for (int i = 0; i < strarray.length; i++) {
                System.out.print(strarray[i]);
                System.out.print(" ");

            }

            System.out.println(" ");
        }
        d.close();
        in.close();
        fs.close();
    }
}
