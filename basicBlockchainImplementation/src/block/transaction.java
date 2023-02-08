package block;

public class transaction {
    private String sourceId;
    private String destinationId;
    private String transactionFormat;
    private int transactionAmount;

    public String getDataString() {
        return sourceId+destinationId+Long.toString(transactionAmount)+transactionFormat;
    }

    public void setSource(String sourceId) {
        this.sourceId = sourceId;
    }

    public void setDestination(String destinationId) {
        this.destinationId = destinationId;
    }

    public void setTransType(String transactionFormat) {
        this.transactionFormat = transactionFormat;
    }

    public void setTransAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getSource() {
        return this.sourceId;
    }

    public String getDestination() {
        return this.destinationId;
    }

    public String getTransType() {
        return this.transactionFormat;
    }

    public int getTransAmount() {
        return this.transactionAmount;
    }

    public String getData() {
        String result = "";
        result += "Source ID: "+getSource()+"\n";
        result += "Destination ID: "+getDestination()+"\n";
        result+= "Transaction Type: "+getTransType()+"\n";
        result += "Transaction Amount: "+ Long.toString(getTransAmount())+"\n";
        return result;
    }
}
