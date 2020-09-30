import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

import java.io.IOException;

public class CovidMapper extends Mapper<LongWritable, Text, Text, CovidDataBean> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //super.map(key, value, context);


        String line = value.toString();
        String[] infos = line.split("\t");

        String date = infos[0];
        String country = infos[1];
        String primaryKey = null;

        String new_case = infos[2];
        String new_death = infos[3];
        System.out.println("newcase= "+infos[2]);

        if(new_case.equals("")){
            new_case = "0";
        }

        if(new_death.equals("")){
            new_death = "0";
        }

        //int new_case = Integer.valueOf(infos[2]).intValue();
        //int new_death = Integer.valueOf(infos[3]).intValue();
        //int total_case = Integer.valueOf(infos[4]);
        //int total_death = Integer.valueOf(infos[5]);
        CovidDataBean covidDataBean = new CovidDataBean();

        //System.out.println(covidDataBean.toString());
        if(infos[0].startsWith("1")) {
            primaryKey = "1-" + country;
            System.out.println(primaryKey);
            covidDataBean.setKey(primaryKey);
            covidDataBean.setDate("1");
        } else if(infos[0].startsWith("2")) {
             primaryKey = "2-" + country;
             System.out.println(primaryKey);
             covidDataBean.setKey(primaryKey);
             covidDataBean.setDate("2");
        }else if(infos[0].startsWith("3")) {
             primaryKey = "3-" + country;
             System.out.println(primaryKey);
             covidDataBean.setKey(primaryKey);
             covidDataBean.setDate("3");
        }else if(infos[0].startsWith("4")) {
             primaryKey = "4-" + country;
            System.out.println(primaryKey);
            covidDataBean.setKey(primaryKey);
            covidDataBean.setDate("4");
        }else if(infos[0].startsWith("5")) {
             primaryKey = "5-" + country;
            System.out.println(primaryKey);
            covidDataBean.setKey(primaryKey);
            covidDataBean.setDate("5");
        }else if(infos[0].startsWith("6")) {
             primaryKey = "6-" + country;
            System.out.println(primaryKey);
            covidDataBean.setKey(primaryKey);
            covidDataBean.setDate("6");
        }else if(infos[0].startsWith("7")) {
             primaryKey = "7-" + country;
            System.out.println(primaryKey);
            covidDataBean.setKey(primaryKey);
             covidDataBean.setDate("7");
        }else if(infos[0].startsWith("8")) {
             primaryKey = "8-" + country;
            System.out.println(primaryKey);
            covidDataBean.setKey(primaryKey);
             covidDataBean.setDate("8");
        }else if(infos[0].startsWith("9")) {
             primaryKey = "9-" + country;
            System.out.println(primaryKey);
            covidDataBean.setKey(primaryKey);
             covidDataBean.setDate("9");
        }





        covidDataBean.setCountry(country);
        covidDataBean.setNew_case(Integer.parseInt(new_case));
        covidDataBean.setNew_death(Integer.parseInt(new_death));
        //covidDataBean.setTotal_case(total_case);
        //covidDataBean.setTotal_death(total_death);
       // System.out.println(covidDataBean.toString());
        context.write(new Text(primaryKey),covidDataBean);

    }
}
