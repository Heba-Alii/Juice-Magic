//package eg.gov.iti.juicemagic.ui.menue;
//
//public class Fragment extends Fra{
//
//
//
//    Toolbar toolbar;
//    TextView title,num;
//    ImageView cart;
//    ArrayList<Parent_Category> parent_categories,parent_categories2;
//    int position=-1;
//    RelativeLayout no, yes;
//    TabLayout tabLayout;
//    BottomNavigationView navigationView;
//
//    String lang;
//    Typeface typeface;
//    AppCompatActivity activity;
//    Meat_Chick_Tab_Adapter meat_chick_tab_adapter;
//    public Meat_Chicken() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view=inflater.inflate(R.layout.fragment_meat__chicken, container, false);
//
//        activity = (AppCompatActivity) getActivity();
//
//        setToolbar();
//
//
//        navigationView=activity.findViewById(R.id.bottom_navigation);
//        //  navigationView.setSelectedItemId(0);
//        navigationView.setVisibility(View.VISIBLE);
//        //------------------get data------------------//
//        if(getArguments()!=null) {
//            parent_categories = getArguments().getParcelableArrayList("cat");
//            position = getArguments().getInt("pos");
//        }
//
//        //------------------------prepare tabs-----------------//
//
//        parent_categories2=new ArrayList<>();
//        if(lang.equals("en")){
//            for(int i=parent_categories.size()-1;i>-1;i--){
//                parent_categories2.add(parent_categories.get(i));
//            }
//        }else{
//            for(int i=0;i<parent_categories.size();i++){
//                parent_categories2.add(parent_categories.get(i));
//            }
//        }
//        ViewPager vpPager = (ViewPager) view.findViewById(R.id.pager);
//        tabLayout=(TabLayout) view.findViewById(R.id.tabDots);
//        setupViewPager(vpPager);
//
//        tabLayout.setupWithViewPager(vpPager);
//        tabLayout.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
//
//        if (lang.equals("ar")) {
//            TabLayout.Tab tab = tabLayout.getTabAt(parent_categories.size()-1-position);
//            tab.select();
//        } else {
//            TabLayout.Tab tab = tabLayout.getTabAt(position);
//            tab.select();
//        }
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab1)
//            { tab1.select(); }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//            }
//        });
//
//        return view;
//    }
//
//    private void setupViewPager(ViewPager viewPager) {
//
//        meat_chick_tab_adapter = new Meat_Chick_Tab_Adapter(getChildFragmentManager());
//        LayoutInflater inflator = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        int count = parent_categories.size();
//        if(count<4){
//            tabLayout.setTabMode(TabLayout.MODE_FIXED);
//        }else{
//            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        }
//
//        for (int i=count-1; i>-1; i--){
//
//            Sandwitches fView = new Sandwitches();
//            Bundle bundle = new Bundle();
//            bundle.putParcelable("parent_cat", parent_categories2.get(i));
//
//            fView.setArguments(bundle);
//
//            meat_chick_tab_adapter.addFrag(fView,parent_categories2.get(i).getParent_category_name());
//        }
//
//        viewPager.setAdapter(meat_chick_tab_adapter);
//    }
//
//    private void  setToolbar(){
//        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
//        lang= SharedPrefManager.getInstance(activity).getLang();
//        if(lang.equals("en")){
//            typeface = Typeface.createFromAsset(activity.getAssets(), "fonts/Roboto-Regular.ttf");
//        }
//        if(lang.equals("ar")){
//            typeface = Typeface.createFromAsset(activity.getAssets(), "fonts/GE SS Two Light.otf");
//        }
//        activity.setSupportActionBar(toolbar);
//        no=toolbar.findViewById(R.id.no_cart);
//        yes=toolbar.findViewById(R.id.yes_cart);
//
//        num=toolbar.getRootView().findViewById(R.id.num);
//
//        title=toolbar.getRootView().findViewById(R.id.toolbar_title);
//
//        if(SharedPrefManager.getInstance(getContext()).get_Cart()>0){
//            cart=toolbar.getRootView().findViewById(R.id.cart);
//
//            no.setVisibility(View.INVISIBLE);
//            yes.setVisibility(View.VISIBLE);
//            num.setText(String.valueOf(SharedPrefManager.getInstance(getContext()).get_Cart()));
//
//        }else{
//            cart=toolbar.getRootView().findViewById(R.id.cart1);
//            yes.setVisibility(View.INVISIBLE);
//            no.setVisibility(View.VISIBLE);
//        }
//        title.setTypeface(typeface);
//        title.setText(getResources().getString(R.string.app_name));
//        ImageButton back=toolbar.findViewById(R.id.back);
//        back.setVisibility(View.VISIBLE);
//
//        num.setVisibility(View.VISIBLE);
//        cart.setVisibility(View.VISIBLE);
////        ImageView menu=toolbar.findViewById(R.id.menu);
////        menu.setVisibility(View.VISIBLE);
//        cart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment fragment=new MyCart();
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, fragment).addToBackStack("xyz")
//                        .commit();
//            }
//        });
//    }
//
