import java.io.Serializable;
import java.security.SecureRandomParameters;

public class Employee extends Person implements Serializable {
    private String ssn;
    private double salary;
    private boolean onDuty;

    private Date date;

    public Employee() {
        super();
        ssn=null;
        salary=0.0;
        onDuty=false;
        date=new Date();
    }



    public Employee(String cnic, String name, String gender, String ssn, double salary, boolean onDuty, String month, int day, int year){
        super(cnic, name, gender);
        this.ssn=ssn;
        this.salary=salary;
        this.onDuty=onDuty;
        this.date=new Date(month,day,year);
    }

    public String getSsn() {
        return ssn;
    }

    public Date getDate() {
        return date;
    }
    public boolean getOnDuty(){
        return onDuty;
    }

    public double getSalary() {
        return salary;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setOnDuty(boolean onDuty) {
        this.onDuty = onDuty;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Employee{"+super.toString() +
                "ssn='" + ssn + '\'' +
                ", salary=" + salary +
                ", onDuty=" + onDuty +
                ", date=" + date.toString() +
                '}';
    }
}
