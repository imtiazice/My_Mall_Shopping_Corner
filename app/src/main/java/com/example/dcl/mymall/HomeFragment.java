package com.example.dcl.mymall;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;

    ///////////////////Banner Slider

    private ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    private int currentPage = 2;
    private Timer timer;
    final private long DELAY_TIME = 3000;
    final private long PERIOD_TIME =3000;

    ///////////////////Banner Slider

    /////////////////Strip Ad

    private ImageView stripAdImage;
    private ConstraintLayout stripAdContainer;

    /////////////////Strip Ad


    ////////////////Horizontal Product Layout

    private TextView horizontalLayoutTitle;
    private Button horizontalLayoutViewAllBtn;
    private RecyclerView horizontalRecyclerView;

    ////////////////Horizontal Product Layout





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
        categoryModelList.add(new CategoryModel("link", "Home"));
        categoryModelList.add(new CategoryModel("link", "Electronics"));
        categoryModelList.add(new CategoryModel("link", "Appliance"));
        categoryModelList.add(new CategoryModel("link", "Furniture"));
        categoryModelList.add(new CategoryModel("link", "Fashion"));
        categoryModelList.add(new CategoryModel("link", "Toys"));
        categoryModelList.add(new CategoryModel("link", "Home"));
        categoryModelList.add(new CategoryModel("link", "Sports"));
        categoryModelList.add(new CategoryModel("link", "Wall Arts"));
        categoryModelList.add(new CategoryModel("link", "Books"));
        categoryModelList.add(new CategoryModel("link", "Shoes"));

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();


        ///////////////////Banner Slider

        bannerSliderViewPager = view.findViewById(R.id.banner_slider_view_pager);

        sliderModelList = new ArrayList<SliderModel>();

        sliderModelList.add(new SliderModel(R.mipmap.icon_error,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.signout,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.green_mail,"#077AE4"));

        sliderModelList.add(new SliderModel(R.mipmap.red_email,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.ic_launcher,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.cart_icon,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.cross,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.bell,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.icon_error,"#077AE4"));

        sliderModelList.add(new SliderModel(R.mipmap.signout,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.green_mail,"#077AE4"));
        sliderModelList.add(new SliderModel(R.mipmap.red_email,"#077AE4"));



        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);

        bannerSliderViewPager.setCurrentItem(currentPage);


        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                currentPage = i;

            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (i == ViewPager.SCROLL_STATE_IDLE){
                    pagerLooper();
                }

            }
        };
        bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);

        startBannerSlideShow();

        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                pagerLooper();
                stopBannerSlideShow();
                if (event.getAction() == MotionEvent.ACTION_UP){
                    startBannerSlideShow();
                }
                return false;
            }
        });

        ///////////////////Banner Slider


        /////////////////Strip ad
        stripAdImage  = view.findViewById(R.id.strip_ad_image);
        stripAdContainer = view.findViewById(R.id.strip_ad_container);

        stripAdImage.setImageResource(R.drawable.banner_samsung);
        stripAdContainer.setBackgroundColor(Color.parseColor("#000000"));
        /////////////////Strip ad


        ////////////////Horizontal Product Layout
        horizontalLayoutTitle = view.findViewById(R.id.horizontal_scroll_layout_title);
        horizontalLayoutViewAllBtn = view.findViewById(R.id.horizontal_scroll_view_all_btn);
        horizontalRecyclerView = view.findViewById(R.id.horizontal_scroll_layout_recyclerview);

        List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.mobile,"Redmi 5A", "SD 425 Processor","Tk. 7078/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.icon_error,"Redmi 5A", "SD 425 Processor","Tk. 7078/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.cart_icon,"Redmi 5A", "SD 425 Processor","Tk. 7078/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.bell,"Redmi 5A", "SD 425 Processor","Tk. 7078/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.home_icon,"Redmi 5A", "SD 425 Processor","Tk. 7078/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.green_mail,"Redmi 5A", "SD 425 Processor","Tk. 7078/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.home_icon,"Redmi 5A", "SD 425 Processor","Tk. 7078/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.red_email,"Redmi 5A", "SD 425 Processor","Tk. 7078/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.user_info_icon,"Redmi 5A", "SD 425 Processor","Tk. 7078/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.cross_button,"Redmi 5A", "SD 425 Processor","Tk. 7078/-"));

        HorizontalProductScrollAdapter horizontalProductScrollAdapter = new HorizontalProductScrollAdapter(horizontalProductScrollModelList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);

        horizontalRecyclerView.setAdapter(horizontalProductScrollAdapter);
        horizontalProductScrollAdapter.notifyDataSetChanged();

        ////////////////Horizontal Product Layout


        ///////////////Grid Product Layout
/*
        TextView gridTextViewTitle = view.findViewById(R.id.grid_product_layout_title);
        Button gridLayoutViewAllBtn = view.findViewById(R.id.grid_product_layout_viewall_btn);
        GridView gridView = view.findViewById(R.id.grid_product_layout_gridview);

        gridView.setAdapter(new GridProductLayoutAdapter(horizontalProductScrollModelList));
        */

        ///////////////Grid Product Layout

        //////////////////////////////
        RecyclerView testing = view.findViewById(R.id.tesing);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager);

        List<HomePageModel> homePageModelList =  new ArrayList<>();
        homePageModelList.add(new HomePageModel(1,R.drawable.banner_samsung,"#000000"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(0,sliderModelList));
        homePageModelList.add(new HomePageModel(1,R.drawable.banner_s9,"#fffff00"));
        homePageModelList.add(new HomePageModel(1,R.drawable.banners_new,"#ff0000"));
        homePageModelList.add(new HomePageModel(0,sliderModelList));

        HomePageAdapter adapter =  new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //////////////////////////////




        return view;
    }

    ///////////////////Banner Slider
    private void pagerLooper(){
        if (currentPage == sliderModelList.size()-2){
            currentPage = 2;
            bannerSliderViewPager.setCurrentItem(currentPage, false);
        }

        if (currentPage == 1){
            currentPage = sliderModelList.size() - 3;
            bannerSliderViewPager.setCurrentItem(currentPage, false);
        }
    }

    private void startBannerSlideShow(){
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage >= sliderModelList.size()){
                    currentPage = 1;
                }
                bannerSliderViewPager.setCurrentItem(currentPage++, true);

            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, DELAY_TIME, PERIOD_TIME);
    }

    private void stopBannerSlideShow(){

        timer.cancel();

    }

    ///////////////////Banner Slider

}
