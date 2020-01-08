package com.wd.home.activity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.common.base.BaseActivity;
import com.wd.health.R;
import com.wd.home.adapter.DiseaseSearchVoListAdapter;
import com.wd.home.adapter.DoctorSearchVoListAdapter;
import com.wd.home.adapter.DrugsSearchVoListAdapter;
import com.wd.home.bean.HomeSearchBean;
import com.wd.home.bean.PopularBean;
import com.wd.home.presenter.HomePresenter;
import com.wd.home.utils.FlowView;
import com.wd.home.utils.RecordSQLiteOpenHelper;
import com.wd.home.contract.Contract;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.wd.health.R2;
public class Edit_SearchActivity extends BaseActivity<HomePresenter> implements Contract.IView {
    @BindView(R2.id.iv_home_search_back)
    ImageView ivHomeSearchBack;
    @BindView(R2.id.et_home_search_title)
    EditText etHomeSearchTitle;
    @BindView(R2.id.iv_home_search)
    TextView ivHomeSearch;
    @BindView(R2.id.fl_topSearch)
    TagFlowLayout flTopSearch;
    @BindView(R2.id.ll_relevantSearchData)
    LinearLayout llRelevantSearchData;
    @BindView(R2.id.iv_noSearch_pic)
    ImageView ivNoSearchPic;
    @BindView(R2.id.tv_noSearch_name)
    TextView tvNoSearchName;
    @BindView(R2.id.rl_home_noSearch)
    RelativeLayout rlHomeNoSearch;
    @BindView(R2.id.rv_doctor)
    RecyclerView rvDoctor;
    @BindView(R2.id.rv_drug)
    RecyclerView rvDrug;
    @BindView(R2.id.rv_symptoms)
    RecyclerView rvSymptoms;
    @BindView(R2.id.ll_searchData)
    LinearLayout llSearchData;
    private FlowView fl_searchHistory;
    private boolean whetherTheQuery = false;
    private RecordSQLiteOpenHelper helper;
    private boolean hasData;
    private SQLiteDatabase db;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {
        fl_searchHistory = findViewById(R.id.fl_searchHistory);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        ivHomeSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = etHomeSearchTitle.getText().toString();
                search(keyword);
            }
        });
        ivHomeSearchBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mPresenter.onHomeSearch("好");
        mPresenter.onPopular();
        //记录到sqlite中
        helper = new RecordSQLiteOpenHelper(this);
        String tempName = etHomeSearchTitle.getText().toString();
        queryData(tempName);
    }

    @Override
    protected int initLayout() {
        return R.layout.home_activity_edit__search;
    }

    @Override
    public void onSuccess(Object obj) {
        if (obj instanceof PopularBean) {
            PopularBean bean = (PopularBean) obj;
            List<PopularBean.ResultBean> result = bean.getResult();
            final List<String> datas = new ArrayList<>();
            for (int i = 0; i < result.size(); i++) {
                String name = result.get(i).getName();
                datas.add(name);
            }
        } else if (obj instanceof HomeSearchBean) {
            HomeSearchBean bean = (HomeSearchBean) obj;
            HomeSearchBean.ResultBean result = bean.getResult();
            //病症
            List<HomeSearchBean.ResultBean.DiseaseSearchVoListBean> diseaseSearchVoList = result.getDiseaseSearchVoList();
            //医生
            List<HomeSearchBean.ResultBean.DoctorSearchVoListBean> doctorSearchVoList = result.getDoctorSearchVoList();
            //药品
            List<HomeSearchBean.ResultBean.DrugsSearchVoListBean> drugsSearchVoList = result.getDrugsSearchVoList();
            if (diseaseSearchVoList != null && diseaseSearchVoList.size() > 0 || doctorSearchVoList != null && doctorSearchVoList.size() > 0 || drugsSearchVoList != null && drugsSearchVoList.size() > 0) {
                rlHomeNoSearch.setVisibility(View.GONE);
                llSearchData.setVisibility(View.VISIBLE);
                llRelevantSearchData.setVisibility(View.GONE);

                //创建适配器
                DiseaseSearchVoListAdapter diseaseSearchVoListAdapter = new DiseaseSearchVoListAdapter(R.layout.home_layout_home_search_item, diseaseSearchVoList);
                //设置每个item的排列方式
                rvSymptoms.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                //设置上适配器
                rvSymptoms.setAdapter(diseaseSearchVoListAdapter);
                //创建适配器
                DoctorSearchVoListAdapter doctorSearchVoListAdapter = new DoctorSearchVoListAdapter(R.layout.home_layout_home_search_item, doctorSearchVoList);
                //设置每个item的排列方式
                rvDoctor.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                //设置上适配器
                rvDoctor.setAdapter(doctorSearchVoListAdapter);
                //创建适配器
                DrugsSearchVoListAdapter drugsSearchVoListAdapter = new DrugsSearchVoListAdapter(R.layout.home_layout_home_search_item, drugsSearchVoList);
                //设置每个item的排列方式
                rvDrug.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                //设置上适配器
                rvDrug.setAdapter(drugsSearchVoListAdapter);
            } else {
                rlHomeNoSearch.setVisibility(View.VISIBLE);
                llSearchData.setVisibility(View.GONE);
                llRelevantSearchData.setVisibility(View.GONE);
                tvNoSearchName.setText(etHomeSearchTitle.getText().toString());
                //llRelevantSearchData,llSearchData,rlHomeNoSearch
            }
        }
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public Context context() {
        return null;
    }

    private void search(String keyword) {
        try {
            //添加到流式布局中
            TextView tv = new TextView(this);
            tv.setText(keyword);
            fl_searchHistory.addView(tv);
            // 转编码格式
            String UTF8 = URLDecoder.decode(keyword, "UTF-8");
            //请求搜索数据
            mPresenter.onHomeSearch(UTF8);
            //添加到历史记录中
            AddHistory();


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private boolean hasData(String trim) {
        // 从数据库中Record表里找到name=tempName的id
        Cursor cursor = helper.getReadableDatabase().rawQuery(
                "select id as _id,name from records where name =?", new String[]{trim});
        //  判断是否有下一个

        return cursor.moveToNext();
    }


    private void AddHistory() {
        hasData = hasData(etHomeSearchTitle.getText().toString().trim());
        // 3. 若存在，则不保存；若不存在，则将该搜索字段保存（插入）到数据库，并作为历史搜索记录
        if (!hasData) {
            insertData(etHomeSearchTitle.getText().toString().trim()); // ->>关注4
            queryData("");
        }

    }

    private void insertData(String tempName) {
        db = helper.getWritableDatabase();
        db.execSQL("insert into records(name) values('" + tempName + "')");
        db.close();
    }

    private void queryData(String tempName) {
        if (!whetherTheQuery) {
            // 1. 模糊搜索
            Cursor cursor = helper.getReadableDatabase().rawQuery(
                    "select id as _id,name from records where name like '%" + tempName + "%' order by id desc ", null);
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                // 2. 创建adapter适配器对象 & 装入模糊搜索的结果
                TextView tv = new TextView(this);
                tv.setPadding(0, 10, 0, 10);
                tv.setText(name);
                fl_searchHistory.addView(tv);
                whetherTheQuery = true;
            }
        }
    }
}
