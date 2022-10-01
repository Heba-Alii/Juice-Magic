package eg.gov.iti.juicemagic.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class ResponseCart_Model implements Serializable {

    private ArrayList<Product> product;
    private int success;
    private String message;

    public ArrayList<Product> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Product> product) {
        this.product = product;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public class Product {
        private int cart_id;
        private float total;
        private Object client_id;

        public int getCart_id() {
            return cart_id;
        }

        public void setCart_id(int cart_id) {
            this.cart_id = cart_id;
        }

        public float getTotal() {
            return total;
        }

        public void setTotal(float total) {
            this.total = total;
        }

        public Object getClient_id() {
            return client_id;
        }

        public void setClient_id(Object client_id) {
            this.client_id = client_id;
        }
    }


}
