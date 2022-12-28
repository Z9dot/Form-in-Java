import java.io.*;
import java.util.ArrayList;

public class Filing implements Serializable{
    File file=new File("Employee.dat");
    public void Save(Employee emp) throws IOException, ClassNotFoundException {
        if (file.exists()) {
            //read the file
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("Employee.dat"));
            ArrayList<Employee> arr1 = (ArrayList<Employee>) input.readObject();
            input.close();
            //add the student
            arr1.add(emp);
            //write the file
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject(arr1);
            output.close();
        } else {
            //create the file
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
            ArrayList<Employee> arr1 = new ArrayList<>();
            arr1.add(emp);
            output.writeObject(arr1);
            output.close();
        }

    }

    public Employee SearchAStudent(String cnic) throws IOException, ClassNotFoundException {
        ObjectInputStream input=new ObjectInputStream(new FileInputStream("Employee.dat"));
        ArrayList<Employee> list=(ArrayList<Employee>)input.readObject();
        input.close();
        Employee emp1=new Employee();
        boolean found=false;
        for(Employee i: list){
            if(cnic.equals(i.getCnic())){
                emp1=i;
                found=true;
                System.out.println(emp1);
                break;
            }

        }
        if(!found)
            System.out.println("No Match Found");
        return emp1;
    }

    public void DeleteAStudent(String cnic) throws IOException, ClassNotFoundException {
        ObjectInputStream input=new ObjectInputStream(new FileInputStream("Employee.dat"));
        ArrayList<Employee> list=(ArrayList<Employee>)input.readObject();
        input.close();
        boolean found=false;
        for(Employee i: list){
            if(cnic.equals(i.getCnic())){
                list.remove(i);
                System.out.println("Deleted Successfully");
                found=true;
                break;
            }
        }

        if(!found)
            System.out.println("No Match Found");
        ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream("Employee.dat"));
        output.writeObject(list);
        output.close();
    }

    public void Display() throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
        ArrayList<Employee> arr1 = (ArrayList<Employee>) input.readObject();
        System.out.println(arr1.toString());
        input.close();
    }
}
