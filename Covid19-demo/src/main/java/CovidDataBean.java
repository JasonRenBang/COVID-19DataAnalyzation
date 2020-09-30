import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CovidDataBean implements Writable, DBWritable {
    private  String key;
    private  String date;
    private  String country;
    private  int new_case;
    private  int new_death;
   // private  int total_case;
    //private  int total_death;




    public CovidDataBean() {
    }


    public CovidDataBean(String key, String date, String country, int new_case, int new_death) {
        this.key = key;
        this.date = date;
        this.country = country;
        this.new_case = new_case;
        this.new_death = new_death;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNew_case() {
        return new_case;
    }

    public void setNew_case(int new_case) {
        this.new_case = new_case;
    }

    public int getNew_death() {
        return new_death;
    }

    public void setNew_death(int new_death) {
        this.new_death = new_death;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(key);
        out.writeUTF(date);
        out.writeUTF(country);
        out.writeInt(new_case);
        out.writeInt(new_death);
        //out.writeInt(total_case);
        //out.writeInt(total_death);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.key = in.readUTF();
        this.date = in.readUTF();
        this.country = in.readUTF();
        this.new_case = in.readInt();
        this.new_death = in.readInt();
       // this.total_case = in.readInt();
       // this.total_death = in.readInt();
    }

    @Override
    public void write(PreparedStatement statement) throws SQLException {
        statement.setString(1,key);
        statement.setString(2,date);
        statement.setString(3,country);
        statement.setInt(4,new_case);
        statement.setInt(5,new_death);
        //statement.setInt(6,total_case);
       // statement.setInt(7,total_death);
    }

    @Override
    public void readFields(ResultSet resultSet) throws SQLException {
       this.key = resultSet.getString(1);
       this.date = resultSet.getString(2);
       this.country = resultSet.getString(3);
       this.new_case = resultSet.getInt(4);
       this.new_death = resultSet.getInt(5);
       //this.total_case = resultSet.getInt(6);
       //this.total_death = resultSet.getInt(7);

    }

    @Override
    public String toString() {
        return "CovidDataBean{" +
                "key='" + key + '\'' +
                ", date='" + date + '\'' +
                ", country='" + country + '\'' +
                ", new_case=" + new_case +
                ", new_death=" + new_death +
                '}';
    }
}
