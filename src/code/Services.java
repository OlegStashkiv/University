package code;


import data.*;

import java.util.ArrayList;
import java.util.List;

public class Services {
    Univer univer;
    Services() {
        univer = null;
    }
    public int ChechUnivFound(){
        if (univer==null)
            return 0;
        else
            return 1;
    }
    public void SetUniver() {
        univer = new Univer("Oxford",(int) Math.round((Math.random() * 82) + 18));
    }
    public void SetScore() {
        if (univer == null) SetUniver();
        Score score = new Score(univer.StudNumber);
        univer.setScores(score);
        //       System.out.println(Arrays.toString(score.getScores(17)));
    }
    public void SetGroups() {
        Group group;
        for (int i = 0; i < 4; i++) {
            group = new Group(i);
            univer.addGroup(group);
        }
    }
    public void SetStudents() {
        Student student;
        for (int i = 0; i < univer.StudNumber; i++) {
            student = new Student(i, (univer.getScores(i)));
            univer.addStudent(student);
        }
    }
    public void SetProfs() {
        Professor proff;
        for (int i = 0; i < 4; i++) {
            proff = new Professor(i);
            univer.addProfessor(proff);
        }
    }
    public void StudRollCall(int groupId) {
        --groupId;
        Group group = univer.getGroup(groupId);
        System.out.println(group.name);
        Student student;
        List<Student> present = new ArrayList<Student>();
        List<Student> absent = new ArrayList<Student>();
        for (int i = 0; i < group.students.size(); i++) {
            student = group.getStudent(i);
            if (student.isPresent())
                present.add(student);
            else absent.add(student);
        }
        for (int i = 0; i < present.size(); i++) {
            student = present.get(i);
            System.out.println("Student " + student.getName() + " is Present");
        }
        for (int i = 0; i < absent.size(); i++) {
            student = absent.get(i);
            System.out.println("Student " + student.getName() + " is Absent");
        }
    }
    public void Election() {
        Student elector;
        Student candid;
        int rating;
        univer.setElection(new Election(univer.StudNumber));
        for (int el = 0; el < univer.students.size(); el++) {
            for (int can = 0; can < univer.students.size(); can++) {
                rating = 0;
                elector = univer.students.get(el);
                candid = univer.students.get(can);
                //if elector is present today
                if (elector.isPresent()) {
                    if (candid.isPresent())
                        ++rating;
                    if (elector.group.equalsIgnoreCase(candid.group))
                        ++rating;
                    if (elector.age < candid.age)
                        ++rating;
                    if (candid.scoreAverage > elector.scoreAverage)
                        ++rating;
                    if ((candid.scoreMainGroup > elector.scoreMainGroup)&(elector.group.equalsIgnoreCase(candid.group)))
                        ++rating;
                    univer.election.setResult(elector.getId(),candid.getId(),rating);
                    //                  System.out.println(el + " "+ can + " "+" el id " + elector.getId()+ " c ID " + candid.getId() );
                    candid.addPoints(rating);
                    System.out.println(elector.getName() +" gives "+ candid.getId() + " "+candid.getName() +" " +  rating +" points ");
                }
            }
        }
        univer.election.Total();
        for (int i = 0; i < univer.students.size(); i++) {
            Student student= univer.getStudent(i);
            System.out.println(" Student name "+student.getName()+" Election rating "+ univer.election.getScore(student.getId()) ); //+ " "+student.getRating() + " "+univer.election.total[i]
        }
        List <Integer> winnerId = univer.election.Winner();
        for (int i = 0; i < winnerId.size(); i++) {
            DeclareWinner(winnerId.get(i));
        }
    }
    public void DeclareWinner(int winnerId){
        Student winner = univer.getStudent(winnerId);
        System.out.println(" ");
        if (winner.sex=="Male")
            System.out.print("Mr. ");
        else             System.out.print("Mrs. ");
        System.out.println(winner.getName()+" has WON ELECTION with total score " + winner.raiting + " CONGRATULATIONS !!!!!!!!!" );
        System.out.println(" ");
        univer.teamleaders.add(winnerId);
    }
    public void UnivStructure(){
        System.out.println(" ");
        System.out.println(" University " + univer.name  + " was founded " + univer.timeStamp +" in " + univer.country);
        System.out.println("A " +univer.StudNumber + " students study here.");
        System.out.println("Famous professors working here, namely: ");
        for (int i = 0; i <univer.professors.size() ; i++) {
            Professor prof = univer.professors.get(i);
            System.out.println("Mr. "+prof.name);
        }
        System.out.println("There are 4 classes :");
        for (int i = 0; i < univer.groups.size(); i++) {
            System.out.println((univer.groups.get(i).name));
        }
        int avrMax = 0;
        int avrLeader=0;
        int avr=0;
        for (int i = 0; i <univer.StudNumber ; i++) {
            Student st = univer.getStudent(i);
            if (st.scoreAverage>avrMax){
                avrMax=st.scoreAverage;
                avrLeader=st.getId();
            }
            avr=avr+st.scoreAverage;
        }
        avr=avr/univer.StudNumber;
        System.out.println("avarage score of students is " + avr);
        Student st = univer.getStudent(avrLeader);
        System.out.println("The highest score of " + avrMax + " has student " +st.getName() + " age " + st.age + " group " + st.group);
        if (univer.teamleaders.size()>0){
            for (int i = 0; i <univer.teamleaders.size() ; i++) {
                Student stt = univer.getStudent(i);
                System.out.println("Teamleader is "+stt.getName() + " "+ stt.sex + " group " + stt.group + " age "+stt.age);
            }
        }
        else System.out.println("There are no teamleader elected. Please Elect one");
        System.out.println(" ");
    }
}
