package data;

public class Score {
    public int[][] score;
    public Score (int studnum){
        score = new int[4][studnum];
        for (int i=0;i < score.length;i++) {
            for (int j=0;j < score[i].length;j++) {
                score[i][j]=(int) Math.round((Math.random() * 11) +1);
            }
        }

    }
    public int [] getScores(int studentId)
    {
        int []result=new int [4];
        for (int i = 0; i <score.length ; i++) {
            result[i]=score[i][studentId];
        }
        return result;
    }
}