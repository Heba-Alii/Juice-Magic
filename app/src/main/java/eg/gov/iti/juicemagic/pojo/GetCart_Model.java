package eg.gov.iti.juicemagic.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class GetCart_Model implements Serializable {
    private ArrayList<Product> product;
    private int success;
    private int count_all;

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

    public int getCount_all() {
        return count_all;
    }

    public void setCount_all(int count_all) {
        this.count_all = count_all;
    }

    public class Addition {
        private Object with_image;
        private String addition_name;
        private String addition_price;

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

    public class Product {
        private String cart_id;
        private String sub_category_id;
        private String remove_id;
        private String side_id;
        private String sub_category_name;
        private String sub_category_desc;
        private String sub_category_image;
        private String size_id;
        private String size_name;
        private String size_price;
        private String addition_id;
        private ArrayList<Addition> addition;
        private ArrayList<Remove> remove;
        private ArrayList<Object> side;
        private String quantity;
        private Object image;
        private String price;
        private String client_id;
        private String charge;
        private String calendar_start;
        private String total_amount;
        private String check_discount;
        private String vat;
        private int discount_percentage;
        private String total_amount_after_disc;
        private String vat_value;
        private String discount_value;
        private String summary;

        public String getCart_id() {
            return cart_id;
        }

        public void setCart_id(String cart_id) {
            this.cart_id = cart_id;
        }

        public String getSub_category_id() {
            return sub_category_id;
        }

        public void setSub_category_id(String sub_category_id) {
            this.sub_category_id = sub_category_id;
        }

        public String getRemove_id() {
            return remove_id;
        }

        public void setRemove_id(String remove_id) {
            this.remove_id = remove_id;
        }

        public String getSide_id() {
            return side_id;
        }

        public void setSide_id(String side_id) {
            this.side_id = side_id;
        }

        public String getSub_category_name() {
            return sub_category_name;
        }

        public void setSub_category_name(String sub_category_name) {
            this.sub_category_name = sub_category_name;
        }

        public String getSub_category_desc() {
            return sub_category_desc;
        }

        public void setSub_category_desc(String sub_category_desc) {
            this.sub_category_desc = sub_category_desc;
        }

        public String getSub_category_image() {
            return sub_category_image;
        }

        public void setSub_category_image(String sub_category_image) {
            this.sub_category_image = sub_category_image;
        }

        public String getSize_id() {
            return size_id;
        }

        public void setSize_id(String size_id) {
            this.size_id = size_id;
        }

        public String getSize_name() {
            return size_name;
        }

        public void setSize_name(String size_name) {
            this.size_name = size_name;
        }

        public String getSize_price() {
            return size_price;
        }

        public void setSize_price(String size_price) {
            this.size_price = size_price;
        }

        public String getAddition_id() {
            return addition_id;
        }

        public void setAddition_id(String addition_id) {
            this.addition_id = addition_id;
        }

        public ArrayList<Addition> getAddition() {
            return addition;
        }

        public void setAddition(ArrayList<Addition> addition) {
            this.addition = addition;
        }

        public ArrayList<Remove> getRemove() {
            return remove;
        }

        public void setRemove(ArrayList<Remove> remove) {
            this.remove = remove;
        }

        public ArrayList<Object> getSide() {
            return side;
        }

        public void setSide(ArrayList<Object> side) {
            this.side = side;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public Object getImage() {
            return image;
        }

        public void setImage(Object image) {
            this.image = image;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getClient_id() {
            return client_id;
        }

        public void setClient_id(String client_id) {
            this.client_id = client_id;
        }

        public String getCharge() {
            return charge;
        }

        public void setCharge(String charge) {
            this.charge = charge;
        }

        public String getCalendar_start() {
            return calendar_start;
        }

        public void setCalendar_start(String calendar_start) {
            this.calendar_start = calendar_start;
        }

        public String getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(String total_amount) {
            this.total_amount = total_amount;
        }

        public String getCheck_discount() {
            return check_discount;
        }

        public void setCheck_discount(String check_discount) {
            this.check_discount = check_discount;
        }

        public String getVat() {
            return vat;
        }

        public void setVat(String vat) {
            this.vat = vat;
        }

        public int getDiscount_percentage() {
            return discount_percentage;
        }

        public void setDiscount_percentage(int discount_percentage) {
            this.discount_percentage = discount_percentage;
        }

        public String getTotal_amount_after_disc() {
            return total_amount_after_disc;
        }

        public void setTotal_amount_after_disc(String total_amount_after_disc) {
            this.total_amount_after_disc = total_amount_after_disc;
        }

        public String getVat_value() {
            return vat_value;
        }

        public void setVat_value(String vat_value) {
            this.vat_value = vat_value;
        }

        public String getDiscount_value() {
            return discount_value;
        }

        public void setDiscount_value(String discount_value) {
            this.discount_value = discount_value;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public class Remove {
            private String remove_name;

            public String getRemove_name() {
                return remove_name;
            }

            public void setRemove_name(String remove_name) {
                this.remove_name = remove_name;
            }
        }


    }
