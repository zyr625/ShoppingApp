package example.lenovo.com.shoppingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import utils.OkHttpUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String url = "http://www.zhaoapi.cn/product/getCarts?uid=71";
    private ShopSellerAdapter shopSellerAdapter;
    private ImageView ivCricle;
    private List<ShopBean.DataBean> list = new ArrayList<>();
    private List<ShopBean.DataBean.ListBean> listAll;
    private TextView allPriceText, sumPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView mrecyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mrecyclerView.setLayoutManager(manager);
        shopSellerAdapter = new ShopSellerAdapter(this);
        mrecyclerView.setAdapter(shopSellerAdapter);
        dohttp();
        findViewById(R.id.layout_all).setOnClickListener(this);
        ivCricle = findViewById(R.id.iv_cricle);
        allPriceText = findViewById(R.id.all_price);
        sumPrice = findViewById(R.id.sum_price_txt);
        shopSellerAdapter.setListener(new ShopSellerAdapter.ShopCallBackListener() {
            @Override
            public void callBack(List<ShopBean.DataBean> list) {
                double allPrice = 0;
                int num = 0;
                int numAll = 0;
                for (int a = 0; a < list.size(); a++) {
                    List<ShopBean.DataBean.ListBean> listAll = list.get(a).getList();
                    for (int i = 0; i < listAll.size(); i++) {
                        numAll = numAll + listAll.get(i).getNum();
                        if (listAll.get(i).isCheck()) {
                            allPrice = allPrice + (listAll.get(i).getPrice() * listAll.get(i).getNum());
                            num = num + listAll.get(i).getNum();
                        }
                    }
                }
                if (num < numAll) {
                    ivCricle.setImageResource(R.drawable.cricle_no);
                    isClick = true;
                } else {
                    ivCricle.setImageResource(R.drawable.cricle_yes);
                    isClick = false;
                }
                allPriceText.setText("合计：" + allPrice);
                sumPrice.setText("去结算(" + num + ")");
            }
        });
    }

    private void dohttp() {
        OkHttpUtils.getOkHttpUtils().get(url).result(new OkHttpUtils.HttpListener() {
            @Override
            public void success(String data) {
                ShopBean bean = new Gson().fromJson(data, ShopBean.class);
                list = bean.getData();
                list.remove(0);
                shopSellerAdapter.setList(list);
            }

            @Override
            public void fail(String error) {

            }
        });
    }

    private boolean isClick = true;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_all://全选
                if (isClick) {
                    ivCricle.setImageResource(R.drawable.cricle_yes);
                    isClick = false;
                    checkSeller(true);
                } else {
                    ivCricle.setImageResource(R.drawable.cricle_no);
                    isClick = true;
                    checkSeller(false);
                }
                break;
        }
    }

    //选中状态
    private void checkSeller(boolean bool) {
        double allPrice = 0;
        int num = 0;
        for (int a = 0; a < list.size(); a++) {
            listAll = list.get(a).getList();
            for (int i = 0; i < listAll.size(); i++) {
                listAll.get(i).setCheck(bool);
                allPrice = allPrice + (listAll.get(i).getPrice() * listAll.get(i).getNum());
                num = num + listAll.get(i).getNum();
            }
        }
        if (bool) {
            allPriceText.setText("合计：" + allPrice);
            sumPrice.setText("去结算(" + num + ")");
        } else {
            allPriceText.setText("合计：0.00");
            sumPrice.setText("去结算(0)");
        }
        shopSellerAdapter.notifyDataSetChanged();
    }
}
