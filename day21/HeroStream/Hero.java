package banban.study12.JiHe.流式api;

public class Hero {
    private int id;
    private String name;
    private String address;
    private String sex;
    private int birth;
    private int die;
    private int wuli;
    private int shouming;
    public Hero() {
    }

    public Hero(int id, String name, String address, String sex, int birth, int die, int wuli) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.sex = sex;
        this.birth = birth;
        this.die = die;
        this.wuli = wuli;
        this.shouming = die-birth;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", die=" + die +
                ", wuli=" + wuli +
                ", shouming=" + shouming +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public int getDie() {
        return die;
    }

    public void setDie(int die) {
        this.die = die;
    }

    public int getWuli() {
        return wuli;
    }

    public void setWuli(int wuli) {
        this.wuli = wuli;
    }

    public int getShouming() {
        return shouming;
    }

    public void setShouming(int shouming) {
        this.shouming = shouming;
    }
}
