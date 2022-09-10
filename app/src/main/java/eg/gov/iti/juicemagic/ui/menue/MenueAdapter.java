package eg.gov.iti.juicemagic.ui.menue;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

//
//public class MenueAdapter extends RecyclerView.Adapter<MenueAdapter.MenueViewHolder> {
//    private ArrayList<JuiceModel.Category> menueList = new ArrayList<>();
//
//    @NonNull
//    @Override
//    public MenueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return new MenueViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.menue_item, parent, false));
//    }
//
//
//    @Override
//    public void onBindViewHolder(@NonNull MenueViewHolder holder, int position) {
//        holder.menueBtn.setText(menueList.get(position).getParent_category_name());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return menueList.size();
//    }
//
//    public void setList(ArrayList<JuiceModel.Category> menueList) {
//        this.menueList = menueList;
//        notifyDataSetChanged();
//    }
//
//    public class MenueViewHolder extends RecyclerView.ViewHolder {
//
//        AppCompatButton menueBtn;
//
//        public MenueViewHolder(@NonNull View itemView) {
//            super(itemView);
//            menueBtn = itemView.findViewById(R.id.menue_btn);
//        }
//    }
//}
public class MenueAdapter extends FragmentStatePagerAdapter {
    ArrayList<MyTab> tabs = new ArrayList<>();

    public MenueAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public void addTabs(MyTab tab) {
        tabs.add(tab);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return tabs.get(position).getSubCategoryModel();
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getParentCategoryModel().getParent_category_name();
    }

    @Override
    public int getCount() {
        return tabs.size();
    }
}