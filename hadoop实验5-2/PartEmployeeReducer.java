package cwg.V17034460115.hadoop;

import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;


public class PartEmployeeReducer extends Reducer<IntWritable, Employee, IntWritable, Employee> {
    @Override
    protected void reduce(IntWritable k3, Iterable<Employee> v3, Context context) throws IOException, InterruptedException {
        for (Employee e : v3)
            context.write(k3, e);
    }
}
