import java.util.Arrays;

public class Block {

    private int previousHash;
    private int currentHash;
    private String[] transactionList;

    public Block(int previousHash, String[] transactionList) {
        this.previousHash = previousHash;
        this.transactionList = transactionList;
        Object[] contents= {Arrays.hashCode(transactionList),previousHash};
        this.currentHash= Arrays.hashCode(contents);
    }

    public int getCurrentHash() { return currentHash; }

}
