// Created by Andreas Ødegaard on 13.12.2016.
public class ExampleCode {

    public static void main(String[] args) {

        ExamExamples ex = new ExamExamples();

        int[] i =  ex.lotto();
        for (int j = 0; j < i.length; j++) {
            System.out.print(i[j] + " ");
        }
        System.out.println();
        System.out.println(ex.bigestNumber(i));

        int[] test = new int[] {1, 2, 3, 3, 4, 4, 4, 4, 7, 9, 10, 11, 12};
        int[] testResults = ex.rydd(test, 4);
        for (int j = 0; j < testResults.length; j++) {
            System.out.println(testResults[j]);
        }


    }
}
