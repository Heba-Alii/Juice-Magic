package eg.gov.iti.juicemagic.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class JuiceModel implements Serializable {

   // private ArrayList<Slider> slider;
    private ArrayList<Latest> latest;
    private ArrayList<Offer> offers;
    private ArrayList<Category> categories;
    private ArrayList<MostSelling> most_selling;
    private int success;

//    public ArrayList<String> getSlider() {
//        return slider;
//    }
//
//    public void setSlider(ArrayList<String> slider) {
//        this.slider = slider;
//    }

    public ArrayList<Latest> getLatest() {
        return latest;
    }

    public void setLatest(ArrayList<Latest> latest) {
        this.latest = latest;
    }

    public ArrayList<Offer> getOffers() {
        return offers;
    }

    public void setOffers(ArrayList<Offer> offers) {
        this.offers = offers;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public ArrayList<MostSelling> getMost_selling() {
        return most_selling;
    }

    public void setMost_selling(ArrayList<MostSelling> most_selling) {
        this.most_selling = most_selling;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }


    public class Category {
        private String parent_category_id;
        private String parent_category_name;
        private String parent_category_desc;
        private String parent_category_image;
        private String display;
        private String arrangement;
        private String type;
        private String removes_type;
        private String addition_type;
        private String date;

        public String getParent_category_id() {
            return parent_category_id;
        }

        public void setParent_category_id(String parent_category_id) {
            this.parent_category_id = parent_category_id;
        }

        public String getParent_category_name() {
            return parent_category_name;
        }

        public void setParent_category_name(String parent_category_name) {
            this.parent_category_name = parent_category_name;
        }

        public String getParent_category_desc() {
            return parent_category_desc;
        }

        public void setParent_category_desc(String parent_category_desc) {
            this.parent_category_desc = parent_category_desc;
        }

        public String getParent_category_image() {
            return parent_category_image;
        }

        public void setParent_category_image(String parent_category_image) {
            this.parent_category_image = parent_category_image;
        }

        public String getDisplay() {
            return display;
        }

        public void setDisplay(String display) {
            this.display = display;
        }

        public String getArrangement() {
            return arrangement;
        }

        public void setArrangement(String arrangement) {
            this.arrangement = arrangement;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getRemoves_type() {
            return removes_type;
        }

        public void setRemoves_type(String removes_type) {
            this.removes_type = removes_type;
        }

        public String getAddition_type() {
            return addition_type;
        }

        public void setAddition_type(String addition_type) {
            this.addition_type = addition_type;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }

    public class Latest {
        private String type;
        private String sub_category_id;
        private String sub_category_name;
        private String sub_category_desc;
        private String sub_category_image;
        private String discount;
        private Object discount_percentage;
        private String parent_category_id;
        private String addition_type;
        private String removes_type;
        private int evaluate;
        private int sub_category_fav;
        private ArrayList<Size> sizes;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSub_category_id() {
            return sub_category_id;
        }

        public void setSub_category_id(String sub_category_id) {
            this.sub_category_id = sub_category_id;
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

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public Object getDiscount_percentage() {
            return discount_percentage;
        }

        public void setDiscount_percentage(Object discount_percentage) {
            this.discount_percentage = discount_percentage;
        }

        public String getParent_category_id() {
            return parent_category_id;
        }

        public void setParent_category_id(String parent_category_id) {
            this.parent_category_id = parent_category_id;
        }

        public String getAddition_type() {
            return addition_type;
        }

        public void setAddition_type(String addition_type) {
            this.addition_type = addition_type;
        }

        public String getRemoves_type() {
            return removes_type;
        }

        public void setRemoves_type(String removes_type) {
            this.removes_type = removes_type;
        }

        public int getEvaluate() {
            return evaluate;
        }

        public void setEvaluate(int evaluate) {
            this.evaluate = evaluate;
        }

        public int getSub_category_fav() {
            return sub_category_fav;
        }

        public void setSub_category_fav(int sub_category_fav) {
            this.sub_category_fav = sub_category_fav;
        }

        public ArrayList<Size> getSizes() {
            return sizes;
        }

        public void setSizes(ArrayList<Size> sizes) {
            this.sizes = sizes;
        }
    }

    public class MostSelling {
        private String type;
        private String sub_category_id;
        private String sub_category_name;
        private String sub_category_desc;
        private String sub_category_image;
        private String discount;
        private String discount_percentage;
        private String parent_category_id;
        private String addition_type;
        private String removes_type;
        private int evaluate;
        private int sub_category_fav;
        private ArrayList<Size> sizes;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSub_category_id() {
            return sub_category_id;
        }

        public void setSub_category_id(String sub_category_id) {
            this.sub_category_id = sub_category_id;
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

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getDiscount_percentage() {
            return discount_percentage;
        }

        public void setDiscount_percentage(String discount_percentage) {
            this.discount_percentage = discount_percentage;
        }

        public String getParent_category_id() {
            return parent_category_id;
        }

        public void setParent_category_id(String parent_category_id) {
            this.parent_category_id = parent_category_id;
        }

        public String getAddition_type() {
            return addition_type;
        }

        public void setAddition_type(String addition_type) {
            this.addition_type = addition_type;
        }

        public String getRemoves_type() {
            return removes_type;
        }

        public void setRemoves_type(String removes_type) {
            this.removes_type = removes_type;
        }

        public int getEvaluate() {
            return evaluate;
        }

        public void setEvaluate(int evaluate) {
            this.evaluate = evaluate;
        }

        public int getSub_category_fav() {
            return sub_category_fav;
        }

        public void setSub_category_fav(int sub_category_fav) {
            this.sub_category_fav = sub_category_fav;
        }

        public ArrayList<Size> getSizes() {
            return sizes;
        }

        public void setSizes(ArrayList<Size> sizes) {
            this.sizes = sizes;
        }
    }

    public class Offer {
        private String type;
        private String sub_category_id;
        private String sub_category_name;
        private String sub_category_desc;
        private String sub_category_image;
        private String discount;
        private String discount_percentage;
        private String parent_category_id;
        private String addition_type;
        private String removes_type;
        private int evaluate;
        private int sub_category_fav;
        private ArrayList<Size> sizes;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSub_category_id() {
            return sub_category_id;
        }

        public void setSub_category_id(String sub_category_id) {
            this.sub_category_id = sub_category_id;
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

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getDiscount_percentage() {
            return discount_percentage;
        }

        public void setDiscount_percentage(String discount_percentage) {
            this.discount_percentage = discount_percentage;
        }

        public String getParent_category_id() {
            return parent_category_id;
        }

        public void setParent_category_id(String parent_category_id) {
            this.parent_category_id = parent_category_id;
        }

        public String getAddition_type() {
            return addition_type;
        }

        public void setAddition_type(String addition_type) {
            this.addition_type = addition_type;
        }

        public String getRemoves_type() {
            return removes_type;
        }

        public void setRemoves_type(String removes_type) {
            this.removes_type = removes_type;
        }

        public int getEvaluate() {
            return evaluate;
        }

        public void setEvaluate(int evaluate) {
            this.evaluate = evaluate;
        }

        public int getSub_category_fav() {
            return sub_category_fav;
        }

        public void setSub_category_fav(int sub_category_fav) {
            this.sub_category_fav = sub_category_fav;
        }

        public ArrayList<Size> getSizes() {
            return sizes;
        }

        public void setSizes(ArrayList<Size> sizes) {
            this.sizes = sizes;
        }
    }


    public class Size {
        private String sub_category_size_price_id;
        private String sub_category_size_name;
        private String discount;
        private String sub_category_size_price_after_disc;
        private String sub_category_size_price;

        public String getSub_category_size_price_id() {
            return sub_category_size_price_id;
        }

        public void setSub_category_size_price_id(String sub_category_size_price_id) {
            this.sub_category_size_price_id = sub_category_size_price_id;
        }

        public String getSub_category_size_name() {
            return sub_category_size_name;
        }

        public void setSub_category_size_name(String sub_category_size_name) {
            this.sub_category_size_name = sub_category_size_name;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getSub_category_size_price_after_disc() {
            return sub_category_size_price_after_disc;
        }

        public void setSub_category_size_price_after_disc(String sub_category_size_price_after_disc) {
            this.sub_category_size_price_after_disc = sub_category_size_price_after_disc;
        }

        public String getSub_category_size_price() {
            return sub_category_size_price;
        }

        public void setSub_category_size_price(String sub_category_size_price) {
            this.sub_category_size_price = sub_category_size_price;
        }
    }


}

//public  class Slider{
//    private image;
//}

