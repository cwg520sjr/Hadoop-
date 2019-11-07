package cwg.V17034460115.hadoop;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


import java.io.IOException;


public class PartEmployeeMapper extends Mapper<LongWritable, Text, IntWritable, Employee> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String data = value.toString();
        String[] words = data.split(",");
        Employee e = new Employee();
        e.setEmpno(Integer.parseInt(words[0]));
        e.setEname(words[1]);
        e.setJob(words[2]);
        try {
            e.setMgr(Integer.parseInt(words[3]));
        } catch (Exception e2) {
            e.setMgr(-1);
        }
        e.setHiredate(words[4]);
        e.setSal(Integer.parseInt(words[5]));
        try {
            e.setComm(Integer.parseInt(words[6]));
        } catch (Exception e2) {
            e.setComm(0);
        }
        e.setDeptno(Integer.parseInt(words[7]));
        context.write(new IntWritable(e.getSal()), e);
    }
}
