package Interface;

import util.QuestionBank;
import util.TreeWhatAmI;

public class RusticInterface
{
    private int pointer = 0;
    
    public RusticInterface()
    {
    }

    public void generateData( TreeWhatAmI<String> root )
    {
        //Root
        
        //Level 1
        root.left = new TreeWhatAmI<String>("1 Y");
        root.right = new TreeWhatAmI<String>("1 N");

        //level 2
            //Izquierda
            root.left.left = new TreeWhatAmI<String>("2 Y");
            root.left.right = new TreeWhatAmI<String>("2 N");
            //Derecha
            root.right.left = new TreeWhatAmI<String>("2 Y");
            root.right.right = new TreeWhatAmI<String>("2 N");
        
        //level 3
            //Izquierda
                //Izquierda
                root.left.left.left = new TreeWhatAmI<String>("3 Y (NULL)");
                root.left.left.right = new TreeWhatAmI<String>("3 N (SI C)");
                //Derecha
                root.left.right.left = new TreeWhatAmI<String>("3 Y (SI C)");
                root.left.right.right = new TreeWhatAmI<String>("3 N");
            //Derecha
                //Izquierda
                root.right.left.left = new TreeWhatAmI<String>("3 Y (SI C)");
                root.right.left.right = new TreeWhatAmI<String>("3 N (SI C)");
                //Derecha
                root.right.right.left = new TreeWhatAmI<String>("3 Y (NULL)");
                root.right.right.right = new TreeWhatAmI<String>("3 N");

        //level 4
            //Izquierda
                //Izquierda
                    //Izquierda

                    //Derecha

                //Derecha
                    //Izquierda
                    
                    //Derecha
                    root.left.right.right.left = new TreeWhatAmI<String>("4 Y");
                    root.left.right.right.right = new TreeWhatAmI<String>("4 N (NULL)");
            //Derecha
                //Izquierda
                    //Izquierda

                    //Derecha

                //Derecha
                    //Izquierda

                    //Derecha
                    root.right.right.right.left = new TreeWhatAmI<String>("4 Y (SI C)");
                    root.right.right.right.right = new TreeWhatAmI<String>("4 N (NULL)");
        
        //level 5
            //Izquierda
                //Izquierda
                    //Izquierda
                        //Izquierda

                        //Derecha

                    //Derecha
                        //Izquierda

                        //Derecha

                //Derecha
                    //Izquierda
                        //Izquierda

                        //Derecha

                    //Derecha
                        //Izquierda
                        root.left.right.right.right.left = new TreeWhatAmI<String>("5 Y");
                        root.left.right.right.right.right = new TreeWhatAmI<String>("5 N (NULL)");
                        //Derecha

            //Derecha
                //Izquierda
                    //Izquierda
                        //Izquierda
                        
                        //Derecha

                    //Derecha
                        //Izquierda

                        //Derecha

                //Derecha
                    //Izquierda
                        //Izquierda

                        //Derecha

                    //Derecha
                        //Izquierda

                        //Derecha
        //level 6
                        root.left.right.right.left.left = new TreeWhatAmI<String>("6 Y (NULL)");
                        root.left.right.right.left.right = new TreeWhatAmI<String>("6 N (SI C)");
    }

    public void generateQuestions( QuestionBank<String> quest )
    {
        quest.addQuestion("DFlamis 0");
        quest.addQuestion("DFlamis 1");
        quest.addQuestion("DFlamis 2");
        quest.addQuestion("DFlamis 3");
        quest.addQuestion("DFlamis 4");
        quest.addQuestion("DFlamis 5");
        quest.addQuestion("DFlamis 6");
    }

    public static String ask(int pointer, QuestionBank<String> quest)
    {
        return quest.getQuestion(pointer);
    }

    public static void main(String[] args)
    {
        TreeWhatAmI<String> root = new TreeWhatAmI<String>("root");
        QuestionBank<String> quest = new QuestionBank<String>();

        RusticInterface ri = new RusticInterface();
        ri.generateData(root);
        ri.generateQuestions(quest);

        // root.preOrder();
        
        root.tryGuess(0);        
    }
}
