package hadoop.ch03.V17034460115;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.*;
import java.net.URI;

public class Upload {
    public static void main(String[] args) throws Exception {
        Configuration conf=new Configuration();
        URI uri=new URI("hdfs://192.168.30.131:8020");
        FileSystem fs=FileSystem.get(uri,conf,"hadoop");

        Path dfs=new Path("/V17034460115.test3.txt");
        String localUrl="D:\\17034460115\\cwg.txt";


        OutputStream output =fs.create(dfs);
        InputStream input=new FileInputStream(localUrl);
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