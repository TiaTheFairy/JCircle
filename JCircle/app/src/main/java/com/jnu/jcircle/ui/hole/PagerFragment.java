package com.jnu.jcircle.ui.hole;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.jnu.jcircle.R;
import com.jnu.jcircle.ui.hole.Adapter.PagerAdapter;
import com.jnu.jcircle.ui.hole.Pages.FragmentToMyself;
import com.jnu.jcircle.ui.hole.Pages.FragmentToOthers;

import java.util.ArrayList;
import java.util.List;

public class PagerFragment extends FragmentActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holepager);
        //通过id找对应的控件
        tabLayout=findViewById(R.id.pager_tabs);
        viewPager=findViewById(R.id.pager_viewpager);
        imageView=findViewById(R.id.pager_no);
        //让pager加载页面,加载的页面为output_record和input_record。在方法里初始化
        initPager();
    }
    private void initPager() {                               //初始化FragmentPager页面，创建页面
        List<Fragment> fragmentList = new ArrayList<>();    //创建页面于公共父类Fragment中
        FragmentToMyself fragmentToMyself = new FragmentToMyself();
        FragmentToOthers fragmentToOthers = new FragmentToOthers();
        fragmentList.add(fragmentToMyself);
        fragmentList.add(fragmentToOthers);

        //创建适配器
        PagerAdapter mpagerAdapter = new PagerAdapter(super.getSupportFragmentManager(), fragmentList);
        //设置适配器
        viewPager.setAdapter(mpagerAdapter);
        //关联tablayout和ViewPager
        tabLayout.setupWithViewPager(viewPager);  //引入import com.google.android.material.tabs.TabLayout
    }

    public void onCLick(View view) {       //在xml文件直接绑定点击事件
        switch(view.getId()){              //通过id执行函数
            case R.id.pager_no:
                finish();
                break;
        }
    }
}
