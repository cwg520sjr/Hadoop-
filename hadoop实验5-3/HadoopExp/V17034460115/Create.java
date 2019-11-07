package hadoop.ch03.V17034460115;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;

/**
 * Hello world!
 *
 */
public class Create
{
    public static void main( String[] args )throws Exception {
        Configuration conf = new Configuration();
        URI uri = new URI("hdfs://192.168.30.131:8020");
        FileSystem fs = FileSystem.get(uri, conf, "hadoop");
        Path dfs = new Path("/17034460115.test3.txt");
        FSDataOutputStream os = fs.create(dfs, true);
        os.writeBytes("hello,hdfs!");
        os.close();
        fs.close();
    }

    }


