package model;

/**
 *
 * @author coen
 */
public class ItemCreation {

    public int ID;
    public String Name;
    public float Price;
    public String Notes;
    public String purchasedate;

    public ItemCreation(int ID, String purchaseDate, String Name, float Price, String Notes) {
        this.ID = ID;
        this.Name = Name;
        this.Price = Price;
        this.Notes = Notes;
        this.purchasedate = purchaseDate;
    }
    
    public ItemCreation(String purchaseDate, String Name, float Price, String Notes) {
        this.Name = Name;
        this.Price = Price;
        this.Notes = Notes;
        this.purchasedate = purchaseDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }

    public String getPurchasedate() {
        return purchasedate;
    }

    public void setPurchasedate(String purchasedate) {
        this.purchasedate = purchasedate;
    }

}
