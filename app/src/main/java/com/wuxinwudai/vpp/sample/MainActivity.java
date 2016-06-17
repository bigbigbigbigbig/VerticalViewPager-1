package com.wuxinwudai.vpp.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.wuxinwudai.vvp.PagerAdapter;
import com.wuxinwudai.vvp.VerticalViewPager;
import com.wuxinwudai.vvp.sample.R;

public class MainActivity extends AppCompatActivity {
    private int[] resources = new int[]{
            R.drawable.guide_brown,
            R.drawable.guide_grey,
            R.drawable.guide_light_green,
            R.drawable.guide_pink,
            R.drawable.guide_yellow
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VerticalViewPager vvp = (VerticalViewPager)findViewById(R.id.vvp);
        vvp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return resources.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView iv = new ImageView(MainActivity.this);
                iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                iv.setScaleType(ImageView.ScaleType.FIT_XY);
                iv.setImageResource(resources[position]);
                ((VerticalViewPager) container).addView(iv);
                return iv;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                ((VerticalViewPager) container).removeView((View) object);
            }
        });
    }
}
