package data;

import java.util.ArrayList;
import java.util.List;

public class Group {
    public int id;
    public String name;
    public List<Student> students = new ArrayList<Student>();
    public Group(int id) {
        this.id = id;
        this.name = GroupNames.values()[id].name();
        System.out.println("Group created! Id " + id + " name " + name );
    }
    public void addStudent (Student student){
        students.add(student);
    }
    public Student getStudent (int index){
        return students.get(index);
    }
}