package basics; // Java 包名和路径名对应

public class TestInheritance{ // 类名和文件名对应
    public static void main(final String[] args) {
        final var ak = new Gun("AK", 650, 30);
        final Gun m4 = new Gun("M4");
        final var aug = new AR("AUG");

        System.out.println(ak.getName());
        System.out.println(m4.getName());
        System.out.println(m4.getRPM());
        System.out.println(aug.getFire());
    }
}

class Gun {
    public String name;
    public int rpm;
    public int mag_size;

    public Gun() {
        this("Untitled");
    }

    public Gun(final String _name) {
        this.name = _name;
        this.rpm = 750;
        this.mag_size = 30;
    }

    public Gun(final String _name, final int _rpm, final int _mag_size) {
        this.name = _name;
        this.rpm = _rpm;
        this.mag_size = _mag_size;
    }

    public String getName() {
        return this.name;
    }

    public int getRPM() {
        return this.rpm;
    }
}

// Inheritance
class AR extends Gun {
    public boolean fullauto;

    public AR(final String _name) {
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
