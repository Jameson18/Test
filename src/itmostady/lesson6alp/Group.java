package itmostady.lesson6alp;

import java.util.Arrays;

public class Group {
    private Alpinist[] alpinist;
    private Mountain mountain;
    private String status = "Набор закрыт";


    public Group(int count){
        if (count > 3)
            throw new IllegalArgumentException("count не должен быть более 3");
        alpinist = new Alpinist[count];
    }


    public Group(int count, String status){
        this(count);
        setStatus(status);
    }


    public Mountain getMountain() {
        return mountain;
    }

    public void setMountain(Mountain mountain) {
        this.mountain = mountain;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void addAlpinist(Alpinist alp){
        for (int i = 0; i < alpinist.length; i++) {
            if (alpinist[i] == null){
                alpinist[i] = alp;
                return;
            }

        }
    }
    public String getAlpsInfo(){
        StringBuilder sb = new StringBuilder();
        for (Alpinist alp: alpinist) {
            if (alp != null)
                sb.append(alp.getName())
                .append(" ")
                .append(alp.getAddress())
                .append("\n");
        }
        return sb.toString();
    }
    public void getAlpsInfo(String info){
        System.out.println(Arrays.toString(alpinist));
    }
    public void addMountain(Mountain mount){
        StringBuilder s = new StringBuilder();
        if (mount != null){
            s.append(getMountain());
        }


    }



    @Override
    public String toString() {
        return "Group{" +
                "alpinist=" + Arrays.toString(alpinist) +
                ", mountain='" + mountain.getName() + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
