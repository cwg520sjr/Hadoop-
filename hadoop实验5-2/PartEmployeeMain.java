package cwg.V17034460115.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;


public class PartEmployeeMain {
    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        job.setJarByClass(PartEmployeeMain.class);

        job.setMapperClass(PartEmployeeMapper.class);
        job.setReducerClass(PartEmployeeReducer.class);

        job.setMapOutputKeyClass(IntWritable.class);
        job.setMapOutputValueClass(Employee.class);

        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(Employee.class);

        job.setPartitionerClass(MyEmployeePartitioner.class);
        job.setNumReduceTasks(3);

        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        try {
            job.waitForCompletion(true);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
