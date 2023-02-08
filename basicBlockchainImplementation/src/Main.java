import block.*;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        block firstBlock = new block(transactionData(),"0",0);
        System.out.println("Enter the prefix count:");
        Scanner sc = new Scanner(System.in);
        int prefix = sc.nextInt();
        firstBlock.mineBlock(prefix);
        System.out.println("Block Data:\n"+firstBlock.getData());
    }

    public static transaction transactionData() {

        transaction tr = new transaction();
        System.out.println("Enter the source:");
        Scanner sc = new Scanner(System.in);
        tr.setSource(sc.nextLine());
        System.out.println("Enter the destination:");
        tr.setDestination(sc.nextLine());
        System.out.println("Enter the transaction type:");
        tr.setTransType(sc.nextLine());
        System.out.println("Enter the transaction amount:");
        tr.setTransAmount(sc.nextInt());

        return tr;
    }


}