import java.util.*;

public class Blockchain {

    private ArrayList<Block> blockchain = new ArrayList<Block>();
    private int chainLength = 0;

    public Blockchain() {
        String[] transactions= {"Start"};
        Block genesisBlock= new Block(0, transactions);
        this.blockchain.add(genesisBlock);
        chainLength++;
    }

    public int getBlockHash(int blockNumber){
        return getBlockchain().get(blockNumber-1).getCurrentHash();
    }

    public void addBlock( String[]transaction){
        int lastIndexValue= this.blockchain.size()-1;
        int previousHash= getBlockchain().get(lastIndexValue).getCurrentHash();
        Block newBlock= new Block(previousHash, transaction);
        this.blockchain.add(newBlock);
        this.chainLength++;
    }

    public ArrayList<Block> getBlockchain() {
        return this.blockchain;
    }

    public int getChainLength() {
        return chainLength;
    }

    public static void main(String[] args) {
        // Individual transactions to added to the blockchain
        String[] genesis = {"Start"};
        String[] block1 = {"Block1"};
        String[] block2 = {"Block2"};
        String[] block3 = {"Block3"};
        String[] block4 = {"Block4"};

        // Individual blocks to test and compare with the blockchain
        Block genBlock = new Block(0,genesis);
        Block firstBlock = new Block(genBlock.getCurrentHash(),block1);
        Block secondBlock = new Block(firstBlock.getCurrentHash(),block2);
        Block thirdBlock = new Block(secondBlock.getCurrentHash(),block3);
        Block fourthBlock = new Block(thirdBlock.getCurrentHash(),block4);

        // Test blockchain that will hold the individual blocks
        Blockchain testChain = new Blockchain();
        Blockchain testChain2 = new Blockchain();
        testChain.addBlock(block1);
        testChain.addBlock(block2);
        testChain.addBlock(block3);
        testChain.addBlock(block4);

        // Regression tests
        System.out.println("****************  Regression Tests  ********************");
        System.out.println("");
        System.out.print("The Genesis Block's hash should equal to: ");
        System.out.println(genBlock.getCurrentHash());
        System.out.print("                               and it is: ");
        System.out.println(testChain.getBlockHash(1));
        System.out.println("");
        System.out.print("The First Block's hash should equal to: ");
        System.out.println(testChain.getBlockHash(2));
        System.out.print("                             and it is: ");
        System.out.println(firstBlock.getCurrentHash());
        System.out.println("");
        System.out.print("The Second Block's hash should equal to: ");
        System.out.println(secondBlock.getCurrentHash());
        System.out.print("                              and it is: ");
        System.out.println(testChain.getBlockHash(3));
        System.out.println("");
        System.out.print("The third Block's hash should equal to: ");
        System.out.println(testChain.getBlockHash(4));
        System.out.print("                             and it is: ");
        System.out.println(thirdBlock.getCurrentHash());
        System.out.println("");
        System.out.print("The fourth Block's hash should equal to: ");
        System.out.println(testChain.getBlockHash(5));
        System.out.print("                              and it is: ");
        System.out.println(fourthBlock.getCurrentHash());
        System.out.println("");

        System.out.print("A total of 4 Blocks were added so the chain length should be: ");
        System.out.println(5);
        System.out.print("                                                   and it is: ");
        System.out.println(testChain.getChainLength());
        System.out.println("");
        System.out.print("The second chain only has the genesis block, the length should be: ");
        System.out.println(1);
        System.out.print("                                                        and it is: ");
        System.out.println(testChain2.getChainLength());
        System.out.println("");

        // Adding a different block to the second chain to confirm that the hashes are different.
        String[] blockA = {"Changed Block"};
        testChain2.addBlock(blockA);
        testChain2.addBlock(block2);

        System.out.println("The second chain has a different value for block one, so the ");
        System.out.print("whole chain's hashes should be different: ");
        System.out.println(testChain2.getBlockHash(3));
        System.out.print("            and the first chain value is: ");
        System.out.println(testChain.getBlockHash(3));
        System.out.println("");
        System.out.println("****************  Completed Tests  ********************");
    }
}
