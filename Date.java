import java.io.Serializable;

public class Date implements Serializable {
    private int day;
    private String month;
    private int year;

    public Date(){
        day=0;
        month=null;
        year=0;
    }
    public Date(String month, int day, int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }

    public int getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return month+" "+day+", "+year;
    }
}
