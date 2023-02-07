import block.block;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        block firstBlock = new block("Hello","0",0);
        System.out.println("Enter the prefix count:");
        Scanner sc = new Scanner(System.in);
        int prefix = sc.nextInt();
        firstBlock.mineBlock(prefix);
        System.out.println("Mined Hash: "+firstBlock.getHash());
    }


}