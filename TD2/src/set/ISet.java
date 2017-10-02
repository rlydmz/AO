package set;

public interface ISet {

    boolean contains(Object element);
    ISet union(ISet set);
    ISet intersect(ISet set);
    ISet diff(ISet set);
    void add(IComparable element);
    void remove(IComparable element);
    int size();
    boolean isEmpty();

}
