public class Book
{
    // instance variables
    private String studentName;
    private String bookNumber;
    // constructors
    public Book(){
    }
    public Book(String studentName, String bookNumber){
        this.studentName = studentName;
        this.bookNumber = bookNumber;
    }
    // accessor methods

    public String getStudentName() {
        return studentName;
    }
    public String getBookNumber() {
        return bookNumber;
    }
    // toString method
    @Override
    public String toString(){
        return "Student Name = " + studentName +
                "\nBook Number = " + bookNumber;
    }
}