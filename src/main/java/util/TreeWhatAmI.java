package util;

import java.util.Scanner;

import Interface.RusticInterface;

public class TreeWhatAmI<E>
{
    public E data;

    public TreeWhatAmI<E> left; //SI
    public TreeWhatAmI<E> right; //NO

    //Consturctor
    public TreeWhatAmI(E data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    //Boolean methods----------------------------------------------------------------------------
    
    //Metodos especificos utilizados
    public boolean isLeftNull()
    {
        return this.left == null;
    }

    public boolean isRightNull()
    {
        return this.right == null;
    }

    public boolean doIKnow() //si sabe la respuesta, retorna true
    {
        if( this.data != null ) return true;
        return false;
    }

    //Metodos adicionales
    public boolean isEmpty()
    {
        if ( data == null ) return true; //Valida si el padre esta vacio
        if ( isLeftNull() && isRightNull() ) return true; //Valida si los hijos estan vacios
        
        return false;
    }

    public boolean isAnswer() //Donde los hijos son null,
    {
        if ( isLeftNull() && isRightNull() ) return true;
        return false;
    }

    //Void methods--------------------------------------------------------------------------------
    public void insertAnswer(E data, String side)
    {
        if( isEmpty() )
        {
            if( side.equals("left") )
            {
                this.left = new TreeWhatAmI<E>(data);
            }
            else
            {
                this.right = new TreeWhatAmI<E>(data);
            }
        }
    }

    //Arreglar
    public void insertQuestion(E data, String side)
    {
        if ( data != null )
        {
            if ( side.equals("si") && !isLeftNull() ) this.left.insertAnswer(data, side);
            
            if ( side.equals("no") && !isRightNull() ) this.right.insertAnswer(data, side);
        }
    }

    public void cheat()
    {

    }

    //E methods----------------------------------------------------------------
    public E getLeftData()
    {
        return this.left.data;
    }

    public E getRightData()
    {
        return this.right.data;
    }
    //----------------------------------------------------------------------------------
    public void preOrder()
    {
        if ( data != null )
        {
            System.out.print("" + data + ", "); //Se imprime la informacion del nodo
            if ( left != null ) left.preOrder(); //Siempre que exista un elemento a la izquierda, se acudira a la recursividad
            if ( right != null ) right.preOrder(); //Siempre que exista un elemento a la derecha, se acudira a la recursividad
        }
        else
        {
            System.out.print("El arbol esta vacio xd");
        }
    }

    public void tryGuess(int pointer, QuestionBank quest)
    {
        if( !isAnswer() ) System.out.print( quest.getQuestion(pointer) + ": " );
        Scanner sc = new Scanner( System.in );
        String answer = "";

        if( !isAnswer() ) answer = sc.next();
        else System.out.print("Piensas en: " + this.data);

        if ( data != null )
        {
            if ( answer.equals("si") && !isLeftNull() && !isAnswer() ) this.left.tryGuess( pointer + 1,quest );
            
            if ( answer.equals("no") && !isRightNull() && !isAnswer() ) this.right.tryGuess( pointer + 1,quest );
        }
    }

}
