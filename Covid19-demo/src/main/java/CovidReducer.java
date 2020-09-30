import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class CovidReducer extends Reducer<Text,CovidDataBean,CovidDataBean, NullWritable> {
    @Override
    protected void reduce(Text key, Iterable<CovidDataBean> values, Context context) throws IOException, InterruptedException {
        //super.reduce(key, values, context);

        CovidDataBean finalDataBean = new CovidDataBean();
        int month_death = 0;
        int month_case = 0;
        String month = null;
        String country = null;
        String k = null;

        for(CovidDataBean dataBean : values){
            month_case += dataBean.getNew_case();
            month_death += dataBean.getNew_death();
            month =dataBean.getDate();
            country = dataBean.getCountry();
            k = dataBean.getKey();
        }

        finalDataBean.setKey(k);
        finalDataBean.setDate(month);
        finalDataBean.setCountry(country);
        finalDataBean.setNew_case(month_case);
        finalDataBean.setNew_death(month_death);
        //System.out.println("newcase = "+month_case);
        //System.out.println("newcase = "+month_case);


        context.write(finalDataBean,NullWritable.get());
    }
}
