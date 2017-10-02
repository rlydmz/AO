package set;

public class Queue implements IQueue{

    private Object[] queue;

    public Queue(int taille){
        queue = new Object[taille];
        for(int i=0; i<taille; i++){
            queue[i] = null;
        }
    }

    @Override
    public void push_front(Object o) {
        if(size() != queue.length){
            for(int i=0; i<queue.length; i++){
                if(queue[i] == null){
                    queue[i] = o;
                    break;
                }
            }
        }
    }

    @Override
    public Object pop_back() {
        Object o = queue[0];
        for(int i=0; i<size(); i++){
            queue[i] = queue[i+1];
        }
        return o;
    }

    @Override
    public boolean empty() {
        if(size() == 0)
            return true;
        return false;
    }

    @Override
    public void clear() {
        for(int i=0; i<queue.length; i++){
            queue[i] = null;
        }
    }

    @Override
    public int size() {
        int cpt = 0;
        for(int i=0; i<queue.length; i++){
            if(queue[i] == (null)){
                break;
            }
            else{
                cpt++;
            }
        }
        return cpt;
    }

    public Object getElementAt(int index){
        return queue[index];
    }

    public String toString(){
        StringBuffer str = new StringBuffer();
        for(int i=0; i<queue.length; i++){
            str.append(i + " : " + queue[i] + "\n");
        }
        return str.toString();
    }
}
