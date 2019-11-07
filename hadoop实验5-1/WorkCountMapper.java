package cwg.V17034460115.hadoop;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class WorkCountMapper extends Mapper<LongWritable , Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key1, Text value1, Context context) throws IOException, InterruptedException {
        String data = value1.toString();
        String[] words = data.split(" ");
        for (String w:words){
            context.write(new Text(w), new IntWritable(1));
        }
    }
}
