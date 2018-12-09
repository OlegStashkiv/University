package data;

public class Professor {
    public int id;
    public String name;
    public Professor(int id){
        this.id=id;
        this.name=ProfNames.values()[id].name();
        System.out.println("Professor born! Id " + id + " name "+ name);
    }
    public void CheckStudents(){
    }
}