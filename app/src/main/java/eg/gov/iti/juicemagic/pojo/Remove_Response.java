package eg.gov.iti.juicemagic.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class Remove_Response implements Serializable {

    private ArrayList<Product> product;
    private int success;

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

    public class Product {
        private String remove_id;
        private String remove_title;

        public String getRemove_id() {
            return remove_id;
        }

        public void setRemove_id(String remove_id) {
            this.remove_id = remove_id;
        }

        public String getRemove_title() {
            return remove_title;
        }

        public void setRemove_title(String remove_title) {
            this.remove_title = remove_title;
        }
    }


}
