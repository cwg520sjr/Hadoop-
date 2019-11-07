package hadoop.ch03.V17034460115;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;

public class ReadHDFSFileAttr {

    public static void main (String[] args) throws  Exception {
        Configuration conf = new Configuration();
        URI uri = new URI("hdfs://192.168.30.131:8020");// 配置NameNode地址
        FileSystem fs = FileSystem.get(uri, conf, "hadoop");// 指定用户名,获取FileSystem对象
        Path dfs =new Path("/17034460115.test3.txt");

        String name = "user.id";
        byte[] value = new byte[2];
        value [0] = 1;
        value [1] = 5;

        try {
            fs.setXAttr(dfs, name, value); //设置拓展属性
        }catch(IOException e){
            e.printStackTrace();
        }
        byte[] result = null;
        try {
            result = fs.getXAttr(dfs,name);
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.print("my user.id = ");

        for (int i =0; i<2; i++) {
            System.out.print(result[i]);
        }
        fs.close();//关闭FileSystem
    }
}