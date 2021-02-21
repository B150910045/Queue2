import java.util.InputMismatchException;
import java.util.Scanner;

class Queue2<T>
{
    class Node
    {
        T data;
        Node next;
        Node(T x){
            data = x;
            next = null;
        }
    }

    Node front, rear;

    //CONSTRUCTOR
    public Queue2(){
        front = rear = null;
    }

    public boolean isEmpty(){
        return (front == null);
    }

    public T getFront(){
        return front.data;
    }

    public T getRear(){
        return rear.data;
    }

    //REMOVE
    public T remove(){
        if(isEmpty()){
            System.out.println("empty");
            return null;
        }
        Node temp = front;
        front = front.next;
        return temp.data;
    }
    
    //INSERT
    public void insert(T data)
    {
        Node temp = new Node(data);
        if(isEmpty())
        {
            front = rear = temp;
        }
        else
        {
            rear.next = temp;
            rear = temp;
        }
    }

    public void print(){
        Node temp = front;
        StringBuilder str = new StringBuilder("[");
        for(int i=0;i<3;i++){
            if(temp != null){
                str.append(temp.data);
                str.append(", ");
                temp = temp.next;
            }
        }
        str.append("]");
        System.out.println(str);
    }
    public static void main(String[] args){
        Queue2<Object> que = new Queue2<>();
        Scanner scn;
        Boolean bool = true;

        while(bool){
            System.out.println("1 - insert");
            System.out.println("2 - remove");
            System.out.println("3 - get front");
            System.out.println("4 - get rear");
            System.out.println("5 - print");
            System.out.println("6 - exit");

            try{
                scn = new Scanner(System.in);
                int input = scn.nextInt();

                switch(input){
                    case 1: 
                        Object item;
                        System.out.println("insert item :");
                        item = scn.next();
                        que.insert(item);
                        break;
                    case 2:
                        que.remove();
                        break;
                    case 3:
                        System.out.println(que.getFront());
                        break;
                    case 4:
                        System.out.println(que.getRear());
                        break;
                    case 5:
                        que.print();
                        break;
                    case 6:
                        bool = false;
                        break;
                    default :
                        System.out.println("Zuvhun 1-6 toonuud!");
                }
            }catch(InputMismatchException e){System.out.println("zuvhun 1-6 toonuud");}
        }
    }
}