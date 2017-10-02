package set;

public class Main {

    public static void main(String[] args){

        Queue q = new Queue(10);
        q.push_front(new Integer(1));
        q.push_front(new Integer(2));

        System.out.println(q);

        System.out.println(q.pop_back());
        System.out.println(q.pop_back());

        System.out.println(q);

    }

}
