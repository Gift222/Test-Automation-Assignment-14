package delivery.dto;

public class orderDto {
    String status;
    int courierId;
    String customerName;
    String customerPhone;
    String comment;
    long id;
    //Constructor

    public orderDto(String customerName, String customerPhone, String comment) {
        this.status = "OPEN";
        this.courierId = 0;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.comment = comment;
        this.id = 0;
    }


}
