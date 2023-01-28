package ind.milo.demo.basic;

public enum StatusEnum {
    DOING("进行中", "DOING"),
    DONE("已完成", "DONE"),
    CANCELLED("已取消", "CANCELLED");
    private String name;
    private String status;

    StatusEnum(String name, String status){
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StatusEnum{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public static void main(String[] args) {
        StatusEnum[] values = StatusEnum.values();
        for (StatusEnum tmp : values) {
            System.out.println("name: "+tmp.getName());
            System.out.println("status: "+tmp.getStatus());
            System.out.println("ordinal: "+tmp.ordinal());

            System.out.println();
        }
    }
}
