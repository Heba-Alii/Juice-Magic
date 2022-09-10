package eg.gov.iti.juicemagic.ui.menue;

import androidx.fragment.app.Fragment;

import eg.gov.iti.juicemagic.pojo.JuiceModel;
import eg.gov.iti.juicemagic.pojo.ParentCategoryModel;
import eg.gov.iti.juicemagic.pojo.SubCategoryModel;

public class MyTab {
   JuiceModel.Category parentCategoryModel;
   Fragment subCategoryModel;

    public MyTab(JuiceModel.Category parentCategoryModel, Fragment subCategoryModel) {
        this.parentCategoryModel = parentCategoryModel;
        this.subCategoryModel = subCategoryModel;
    }

    public JuiceModel.Category getParentCategoryModel() {
        return parentCategoryModel;
    }

    public void setParentCategoryModel(JuiceModel.Category parentCategoryModel) {
        this.parentCategoryModel = parentCategoryModel;
    }

    public Fragment getSubCategoryModel() {
        return subCategoryModel;
    }

    public void setSubCategoryModel(Fragment subCategoryModel) {
        this.subCategoryModel = subCategoryModel;
    }
}
