import java.io.Serializable;

public class Person implements Serializable {
    private String cnic;
    private String name;
    private String gender;

    public Person(){
        cnic=null;
        name=null;
        gender=null;
    }
    public Person(String cnic, String name, String gender){
        this.cnic=cnic;
        this.name=name;
        this.gender=gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getCnic() {
        return cnic;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return
                "cnic=" + cnic + " " +
                ", name=" + name + " " +
                ", gender=" + gender + " ";
    }
}

