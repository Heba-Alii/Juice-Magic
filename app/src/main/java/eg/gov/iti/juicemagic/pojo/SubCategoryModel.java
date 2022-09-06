package eg.gov.iti.juicemagic.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class SubCategoryModel implements Serializable {
    private ArrayList<JuiceModel.Latest> product;
    private int success;

    public ArrayList<JuiceModel.Latest> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<JuiceModel.Latest> product) {
        this.product = product;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}
