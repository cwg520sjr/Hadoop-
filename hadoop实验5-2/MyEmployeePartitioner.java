package cwg.V17034460115.hadoop;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;


public class MyEmployeePartitioner extends Partitioner<IntWritable, Employee> {
    @Override
    public int getPartition(IntWritable k2, Employee v2, int i) {
        if (v2.getSal() < 1500) {
            return 1 % i;
        }else if (v2.getSal() >= 1500 && v2.getSal() < 3000) {
            return 2 % i;
        }else{
            return 3 % i;
        }
    }
}
