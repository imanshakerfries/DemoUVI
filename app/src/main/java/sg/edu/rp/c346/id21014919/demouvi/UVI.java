package sg.edu.rp.c346.id21014919.demouvi;

public class UVI {
    int value;
    String timestamp;

    public UVI(int value, String timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public int getIndex() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setDate(String date) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "UVI Index in Singapore" + "\n" +
                "Index: " + value + "\n" +
                "Date: " + timestamp;
    }
}

