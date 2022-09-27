package eg.gov.iti.juicemagic.pojo;

import java.io.Serializable;

public class AddCart_Model implements Serializable {
    private String lang;
    private String client_id;
    private String quantity;
    private String size_id;
    private String sub_category_id;
    private String addition_id;
    private String remove_id;
    private String note;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSize_id() {
        return size_id;
    }

    public void setSize_id(String size_id) {
        this.size_id = size_id;
    }

    public String getSub_category_id() {
        return sub_category_id;
    }

    public void setSub_category_id(String sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    public String getAddition_id() {
        return addition_id;
    }

    public void setAddition_id(String addition_id) {
        this.addition_id = addition_id;
    }

    public String getRemove_id() {
        return remove_id;
    }

    public void setRemove_id(String remove_id) {
        this.remove_id = remove_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public AddCart_Model(String lang, String client_id, String quantity, String size_id, String sub_category_id, String addition_id, String remove_id, String note) {
        this.lang = lang;
        this.client_id = client_id;
        this.quantity = quantity;
        this.size_id = size_id;
        this.sub_category_id = sub_category_id;
        this.addition_id = addition_id;
        this.remove_id = remove_id;
        this.note = note;
    }
}
