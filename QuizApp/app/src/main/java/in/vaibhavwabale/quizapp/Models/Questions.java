package in.vaibhavwabale.quizapp.Models;

public class Questions {

    private String question;
    private String oA, oB, oC, oD;
    private String answers;

    public Questions(String question, String answers, String oA, String oB, String oC, String oD) {
        this.question = question;
        this.answers = answers;
        this.oA = oA;
        this.oB = oB;
        this.oC = oC;
        this.oD = oD;

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getoA() {
        return oA;
    }

    public void setoA(String oA) {
        this.oA = oA;
    }

    public String getoB() {
        return oB;
    }

    public void setoB(String oB) {
        this.oB = oB;
    }

    public String getoC() {
        return oC;
    }

    public void setoC(String oC) {
        this.oC = oC;
    }

    public String getoD() {
        return oD;
    }

    public void setoD(String oD) {
        this.oD = oD;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }
}
