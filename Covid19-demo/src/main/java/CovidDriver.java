import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.db.DBConfiguration;
import org.apache.hadoop.mapreduce.lib.db.DBOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.CombineTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class CovidDriver {
    public static void main(String[] args) throws Exception{
        args = new String[]{"C:\\Users\\86189\\Desktop\\data\\210txt","C:\\Users\\86189\\Desktop\\data\\result"};

        Configuration configuration = new Configuration();
        DBConfiguration.configureDB(configuration,"com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/covid19","root", "123456");
        Job job = Job.getInstance(configuration);

        job.setJarByClass(CovidDriver.class);
        job.setMapperClass(CovidMapper.class);
        job.setReducerClass(CovidReducer.class);

        job.setInputFormatClass(CombineTextInputFormat.class);
        CombineTextInputFormat.setMaxInputSplitSize(job,9194304);


        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(CovidDataBean.class);

        job.setOutputKeyClass(Text.class);
        //job.setOutputValueClass(CovidDataBean.class);
        job.setOutputFormatClass(DBOutputFormat.class);


        FileInputFormat.setInputPaths(job, new Path(args[0]));
        //FileOutputFormat.setOutputPath(job, new Path(args[1]));

        DBOutputFormat.setOutput(job,"t_covid", "MONTH_COUNTRY_KEY","MONTH","COUNTRY","MONTHLY_CASE","MONTHLY_DEATH");

        boolean rs = job.waitForCompletion(true);
        System.out.println(rs?"成功":"失败");
    }

}
