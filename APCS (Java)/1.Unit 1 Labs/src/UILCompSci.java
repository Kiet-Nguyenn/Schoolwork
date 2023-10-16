public class UILCompSci {
    private String name;
    private int correct;
    private int incorrect;
    private int questions;
    private int score;

    public UILCompSci(){
    }
    public UILCompSci(String name, int correct, int incorrect, int questions){
        this.name = name;
        this.correct = correct;
        this.incorrect = incorrect;
        this.questions = questions;
        this.score = (correct * 6) - (incorrect * 2);
    }


    public String toString(){
        return ("Contestant's Name : " + name +
                "\nCorrect           : " + correct +
                "\nIncorrect         : " + incorrect +
                "\nSkips             : " + (questions - (correct + incorrect)) +
                "\n------------------------------" +
                "\nScore             : " + score);

    }
}

class UILTester{
    public static void main(String[] args) {
        UILCompSci test = new UILCompSci(Utility.readString("Enter contestant's name --> "),
                                         Utility.readInt("Number correct --> "),
                                         Utility.readInt("Number incorrect --> "), 40);
        Utility.blankLines(1);
        System.out.println(test);
    }
}