package set;

public abstract class BinaryTree implements IBinaryTree{

    private BinaryTree leftChild;
    private BinaryTree rightChild;
    private Object data;

    public BinaryTree(Object data, BinaryTree leftChild, BinaryTree rightChild){
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }

    public BinaryTree(Object data){
        leftChild = null;
        rightChild = null;
        this.data = data;
    }

    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(leftChild.toString());
        stringBuffer.append(rightChild.toString());
        return stringBuffer.toString();
    }


    @Override
    public Object getData() {
        return data;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public IBinaryTree getLeftChild() {
        return leftChild;
    }

    @Override
    public IBinaryTree getRightChild() {
        return rightChild;
    }

    @Override
    public void setLeftChild(IBinaryTree leftChild) {
        this.leftChild = (BinaryTree) leftChild;
    }

    @Override
    public void setRightChild(IBinaryTree rightChild) {
        this.rightChild = (BinaryTree) rightChild;
    }

    @Override
    public boolean isLeaf() {
        if(leftChild == null && rightChild == null)
            return true;
        return false;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getNumberNodes() {
        return 0;
    }
}
