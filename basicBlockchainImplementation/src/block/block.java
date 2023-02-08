package block;
import java.io.*;
import java.util.logging.*;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class block {

    private static Logger logger = Logger.getLogger(block.class.getName());
    private String hash;
    private String previousHash;
    private String data;
    private long timeStamp;
    private int nonce;
    private transaction transactionData;

    public block(transaction data, String previousHash, long timeStamp) {
        this.data = data.getDataString();
        this.previousHash = previousHash;
        this.timeStamp = timeStamp;
        this.hash = calculateBlockHash();
        this.transactionData = data;
    }

    public String calculateBlockHash() {
        String hashInput = previousHash + Long.toString(timeStamp) + Long.toString(nonce) + data;
        MessageDigest digest = null;
        byte[] bytes = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(hashInput.getBytes(StandardCharsets.UTF_8));
        }
        catch (NoSuchAlgorithmException ex) {
            logger.log(Level.SEVERE, ex.getMessage());
        }

        StringBuffer buffer = new StringBuffer();
        for(byte b:bytes) {
            buffer.append(String.format("%02x",b));
        }
        return buffer.toString();
    }

    public String mineBlock(int prefixCount) {
        String prefixString = new String(new char[prefixCount]).replace('\0','0');
        while (!hash.substring(0,prefixCount).equals((prefixString))) {
            nonce++;
            hash = calculateBlockHash();
        }
        return hash;
    }
    public String getHash() {
        return this.hash;
    }

    public String getPreviousHash() {
        return this.previousHash;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return this.transactionData.getData();
    }
}
