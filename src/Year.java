public class Year implements Cloneable{

    private int year;

    public Year(){
        this.year=0;
    }
    public Year(int year){
        this.year=year;
    }


    @Override
    public String toString() {
        return String.valueOf(year);
    }
}
