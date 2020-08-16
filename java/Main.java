public class Main{
    public static void main(String[] args) {
        var ak = new Gun("AK", 650, 30);
        Gun m4 = new Gun("M4");
        var aug = new AR("AUG");

        System.out.println(ak.getName());
        System.out.println(m4.getName());
        System.out.println(m4.getRPM());
        System.out.println(aug.getFire());
    }
}

class Gun{
    public String name;
    public int rpm;
    public int mag_size;

    public Gun(){
        this("Untitled");
    }
    
    public Gun(String _name){
        this.name = _name;
        this.rpm = 750;
        this.mag_size = 30;
    }

    public Gun(String _name, int _rpm, int _mag_size){
        this.name = _name;
        this.rpm = _rpm;
        this.mag_size = _mag_size;
    }

    public String getName(){
        return this.name;
    }

    public int getRPM() {
        return this.rpm;
    }
}

// Inheritance
class AR extends Gun{
    public boolean fullauto;

    public AR(String _name){
        this.name = _name;
        this.mag_size = 30;
        this.fullauto = true;
    }

    public String getFire(){
        if (this.fullauto){
            return "Full-auto";
        }else{
            return "Semi-auto";
        }
    }
}
