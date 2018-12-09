package data;

import java.util.ArrayList;
import java.util.List;

public class Election {
    public int[][] result;
    public int[] total;
    int studNum;
    public Election(int studNum) {
        result = new int[studNum][studNum];
        total = new int[studNum];
        this.studNum=studNum;
    }
    public void setResult(int vouter, int candid, int val) {
        this.result[vouter][candid] = val;
    }
    public int getScore(int studentId) {
        int total = 0;
        for (int i = 0; i < studNum; i++) {
            total = total + result[i][studentId];
        }
        return total;
    }
    public void Total() {
        for (int i = 0; i < studNum; i++) {
            total[i] = getScore(i);
        }
    }
    public List <Integer> Winner() {
        List <Integer>winners=new ArrayList<Integer>();
        int largest = total[0], indexlast = 0;
        int indexfirst = 0;
        for (int i = 1; i < total.length; i++) {
            if (total[i] >= largest) {
                largest = total[i];
                indexfirst = i;
            }
        }
        largest = total[total.length-1];
        for (int i = total.length-1; i >= 0; i--) {
            if (total[i] >= largest) {
                largest = total[i];
                indexlast = i;
            }
        }
        if (indexfirst == indexlast) {
            winners.add(indexlast);
        } else {
            winners.add(indexlast);
            winners.add(indexfirst);
        }
        return winners;
    }
}
