package hadoop.ch03.V17034460115;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

public class Download {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        URI uri = new URI("hdfs://192.168.30.131:8020");
        FileSystem fs = FileSystem.get(uri, conf, "hadoop");
        String localSrc ="D:\\V17034460115\\cwg.txt";
        Path dfs =new Path("/17034460115.test3.txt");
        OutputStream output=new FileOutputStream(localSrc);

        InputStream input=fs.open(dfs);
        byte[] buffer =new byte[1024];
        int length=0;
        while((length=input.read(buffer))>0){
            output.write(buffer,0,length);
        }
        output.flush();
        input.close();
        fs.close();
        System.out.println("success");


    }
}