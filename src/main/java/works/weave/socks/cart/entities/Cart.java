package works.weave.socks.cart.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Document
public class Cart {
    @NotNull
    public String custId; // Public instead of getters/setters.
    @Id
    private String id;
    @DBRef
    private List<Item> items = new ArrayList<>();

    public Cart(String custId) {
        this.custId = custId;
    }

    public Cart() {
        this(null);
    }

    public List<Item> contents() {
        return items;
    }

    public Cart add(Item item) {
        items.add(item);
        return this;
    }

    public Cart remove(Item item) {
        items.remove(item);
        return this;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", custId='" + custId + '\'' +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (custId != null ? !custId.equals(cart.custId) : cart.custId != null) return false;
        if (id != null ? !id.equals(cart.id) : cart.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = custId != null ? custId.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
