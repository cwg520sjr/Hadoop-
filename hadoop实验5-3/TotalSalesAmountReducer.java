package cwg.V17034460115.hadoop;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;


public class TotalSalesAmountReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {
    @Override
    protected void reduce(Text key, Iterable<FloatWritable> values, Context context)
            throws IOException, InterruptedException {
        int count = 0;
        for (FloatWritable value : values) {
            count += value.get();
        }
        context.write(key, new FloatWritable(count));
    }
}