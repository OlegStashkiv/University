package data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Univer {
    public List<Student> students;
    public List<Group> groups;
    public List<Professor> professors;
    public Score scores;
    public Election election;
    public List<Integer> teamleaders;
    public boolean founded = false;
    public String timeStamp;
    public String name;
    public int StudNumber;
    public String country;
    public Univer(String UnivName, int studNum) {
        this.students = new ArrayList<Student>();
        this.groups = new ArrayList<Group>();
        this.professors = new ArrayList<Professor>();
        this.teamleaders = new ArrayList<>();
        this.founded = true;
        Locale locale = Locale.getDefault();
        this.country= locale.getDisplayCountry();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        timeStamp=dateFormat.format(cal.getTime());
        this.name = UnivName;
        this.StudNumber = studNum;
    }
    public void setScores(Score scores) {
        this.scores = scores;
    }
    public void setElection(Election election) {
        this.election = election;
    }
    public int[] getScores(int studentId) {
        int[] result = new int[4];
        for (int i = 0; i < scores.score.length; i++) {
            result[i] = scores.score[i][studentId];
        }
        return result;
    }
    public void addStudent(Student student) {
        students.add(student);
        int groupId = GroupNames.valueOf(student.group).ordinal();
        Group group = getGroup(groupId);
        group.addStudent(student);
    }
    public Student getStudent(int index) {
        return students.get(index);
    }
    public void addProfessor(Professor prof) {
        professors.add(prof);
    }
    public Professor getProfessor(int index) {
        return professors.get(index);
    }
    public void addGroup(Group group) {
        groups.add(group);
    }
    public Group getGroup(int index) {
        return groups.get(index);
    }
    public void Vote(int studId, int candidate, int rate) {
        election.setResult(studId, candidate, rate);
    }
}