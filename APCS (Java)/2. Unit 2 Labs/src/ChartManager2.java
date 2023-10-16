import org.omg.CosNaming.BindingIterator;

public class ChartManager2
{
    public static void main(String[] args)
    {
        Student[][] chart = {{new Student("Ben","1"), new Student("Adam","2"), new Student("Jen","3"), new Student("Anne",""), new Student("Sarah","4")},
                {new Student("Zav",""), new Student("Stan","5"), new Student("Grant","6"), new Student("Steph",""), new Student("chad","7")},
                {new Student("Kyle","8"), new Student("Spottem",""), new Student("Gottem","9"), new Student("swag","10"), new Student("Casey","11")},
                {new Student("Shen","12"), new Student("Zoe","13"), new Student("Kari","14"), new Student("Claire",""), new Student("Randy","")},
        };


        //randomly setting 20% to problem students
        for(int r = 0; r < chart.length; r++){
            for(int c = 0; c < chart[0].length; c++){
                if(Math.random() < .20){
                    chart[r][c].setDistractor(true);
                }
            }
        }

        SeatingChart seatingChart = new SeatingChart(chart);
        System.out.println("---------------------------");
        System.out.println("   Original Seating Chart");
        System.out.println("---------------------------");
        seatingChart.displayChart();


        System.out.println("---------------------------");
        System.out.println("   Test mostDistracted");
        System.out.println("---------------------------");
        seatingChart.initDistracted(chart);
        seatingChart.displayDistracted();
        System.out.println("Most distracted: " + seatingChart.getMostDistractedStudent());


    }
}