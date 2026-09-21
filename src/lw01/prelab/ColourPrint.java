package lw01.prelab;

public class ColourPrint extends PrintJob {
    ColourPrint(String id, int pages) {
        super(id, pages);
    }
    
    @Override 
    public int calculateCharge() {
        int pages = getPages();
        int charge;
        if(pages<=10) {
            charge = pages * 1500;
        } else {
            charge = 15000 + ((pages - 10) * 1000);
        }
        return charge +2000;
    }

    @Override 
    public String label() {
        return "Colour";
    } 
}
