package util;

import java.util.Iterator;

public class QuestionBank<E> implements Iterable<E>
{
    private E[] list;
    private int size;
    private int capacity;

    public QuestionBank()
    {
        this.size = 0;
        this.capacity = 6;
        this.list = (E[]) new Object[capacity];
    }

    //Boolean Methods----------------------------------------------------------
    public boolean isFull()
    {
        if ( this.size == this.capacity ) return true;
        return false;
    }

    //E Methods----------------------------------------------------------------
    public E getQuestion(int pointer)
    {
        int tempPointer = 0;
        for ( E e: this.list )
        {
            if ( tempPointer == pointer )
            {
                return e;
            }
            tempPointer += 1;
        }
        return null;
    }

    //Void Methods-------------------------------------------------------------
    public void grow()
    {
        int newCpacity = capacity * 2;
        this.capacity = newCpacity;

        E[] tempList = (E[]) new Object[ newCpacity ];
        
        int pointer = 0;

        for( E e: this.list )
        {
            tempList[ pointer ] = e;
            pointer += 1;
        }

        this.list = tempList;
    }
    
    public void addQuestion(E question)
    {
        if ( isFull() ) grow();

        this.size += 1;

        this.list[ size - 1 ] = question;
    }

    @Override
    public Iterator<E> iterator()
    {
        Iterator<E> it = new Iterator<E>()
        {

            private int pointer = 0;

            @Override
            public boolean hasNext()
            {
                return pointer < size && list[pointer] != null;
            }

            @Override
            public E next()
            {
                return (E) list[pointer++];
            }

            @Override
            public void remove()
            {
                throw new UnsupportedOperationException("Chale, no salio");
            }
        };
        return it;
    }

    //Int Methods--------------------------------------------------------------
    public int howMany()
    {
        return this.size;
    }
    
}
