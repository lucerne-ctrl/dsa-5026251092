package lw01.prelab;

public abstract class PrintJob implements Chargable {
    private String id;
    private int pages;

    protected PrintJob (String id, int pages) {
        if (pages <= 0) throw new IllegalArgumentException("Pages must be positive");
        this.id = id;
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public abstract int calculateCharge();

    public int calculateCharge(int copies) {
        if (copies <= 0) throw new IllegalArgumentException("Copies must be positive");
        return copies * calculateCharge();
    }

    //overload dalam kelas sama, parameter beda, nama method sama
    // override beda kelas, parameter sama, nama method sama

    public String label() {
        return "Print";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }
}