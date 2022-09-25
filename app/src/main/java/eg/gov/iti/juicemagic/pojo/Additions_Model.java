package eg.gov.iti.juicemagic.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class Additions_Model implements Serializable {

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
        private String addition_id;
        private Object with_image;
        private String addition_name;
        private String addition_price;

        public String getAddition_id() {
            return addition_id;
        }

        public void setAddition_id(String addition_id) {
            this.addition_id = addition_id;
        }

        public Object getWith_image() {
            return with_image;
        }

        public void setWith_image(Object with_image) {
            this.with_image = with_image;
        }

        public String getAddition_name() {
            return addition_name;
        }

        public void setAddition_name(String addition_name) {
            this.addition_name = addition_name;
        }

        public String getAddition_price() {
            return addition_price;
        }

        public void setAddition_price(String addition_price) {
            this.addition_price = addition_price;
        }
    }


}
