package rs.ac.uns.zuul.dto;

public class OrderLineItemDTO {

    private Long menuItemId;
    private String menuItemName;
    private int quantity;

    public OrderLineItemDTO() {
    }

    public OrderLineItemDTO(
            Long menuItemId,
            String menuItemName,
            int quantity
    ) {
        this.menuItemId = menuItemId;
        this.menuItemName = menuItemName;
        this.quantity = quantity;
    }

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
