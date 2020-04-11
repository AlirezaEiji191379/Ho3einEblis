import com.google.gson.*;
import com.google.gson.reflect.TypeToken;


import java.util.*;
import java.io.*;
import java.nio.*;


public class GsonSampleTest {
    public static void main(String[] args) {
        String json = "{\"fullName\":\"RezaPishro\", \"age\": 34}";
        Student firstStudnet = new Student("Alireza Eiji", 19);
        firstStudnet.addPhoneNumber("33824264");
        firstStudnet.addPhoneNumber("09140307011");
        firstStudnet.addPhoneNumber("09125961023");
        Student secondStudent = new Student("Amir Ho3ein Shamsi", 19);
        Student thirdStudent = new Student("Adolf Hitler", 56);
        ArrayList<Student> allStudent = Student.getAllStudent();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        json = gson.toJson(allStudent);
        ArrayList <Student> newAllStudents=gson.fromJson(json , new TypeToken<List<Student>>(){}.getType());
        for(Student student:newAllStudents){
            System.out.println(student);
        }
        System.out.println("the End!!!!!!");

    }
}


class Student {
    private static ArrayList<Student> allStudent = new ArrayList<>();
    String fullName;
    int age;
    private ArrayList<String>allPhoneNumbers;
    Student(String fullName, int age) {
        this.setAge(age);
        this.setFullName(fullName);
        this.allPhoneNumbers=new ArrayList<>();
        Student.allStudent.add(this);
    }

    public ArrayList<String> getAllPhoneNumbers() {
        return allPhoneNumbers;
    }

    public void addPhoneNumber(String newPhoneNumber){
        this.allPhoneNumbers.add(newPhoneNumber);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public static ArrayList<Student> getAllStudent() {
        return Student.allStudent;
    }

    @Override
    public String toString() {
        String [] allPhoneNumbers= this.allPhoneNumbers.toArray(new String[this.allPhoneNumbers.size()]);
        String information=String.format("%s    %d", this.getFullName(), this.getAge());
        return information;
    }

}