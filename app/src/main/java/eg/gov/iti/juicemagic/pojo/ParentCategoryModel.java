package eg.gov.iti.juicemagic.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class ParentCategoryModel implements Serializable {
    private ArrayList<JuiceModel.Category> product;
    private int success;

    public ArrayList<JuiceModel.Category> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<JuiceModel.Category> product) {
        this.product = product;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}
