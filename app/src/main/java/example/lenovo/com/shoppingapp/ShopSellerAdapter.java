package example.lenovo.com.shoppingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * author：shashe
 * 日期：2018/10/24
 * 商家的适配器
 */
public class ShopSellerAdapter extends RecyclerView.Adapter<ShopSellerAdapter.MyViewHolder> {
    private List<ShopBean.DataBean> list = new ArrayList<>();
    private Context context;

    public ShopSellerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ShopSellerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.shop_seller_car_adapter, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopSellerAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.sellerName.setText(list.get(i).getSellerName());
        ShopSellerCarAdapter shopSellerCarAdapter = new ShopSellerCarAdapter(context, list.get(i).getList());
        LinearLayoutManager manager = new LinearLayoutManager(context);
        myViewHolder.recyclerView.setLayoutManager(manager);
        myViewHolder.recyclerView.setAdapter(shopSellerCarAdapter);
        shopSellerCarAdapter.setListener(new ShopSellerCarAdapter.ShopCallBackListener() {
            @Override
            public void callBack() {
                listener.callBack(list);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //传递数据
    public void setList(List<ShopBean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView sellerName;
        RecyclerView recyclerView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sellerName = itemView.findViewById(R.id.seller_name);
            recyclerView = itemView.findViewById(R.id.seller_recyclerview);
        }
    }
    //传递接口
    private ShopCallBackListener listener;

    public void setListener(ShopCallBackListener listener) {
        this.listener = listener;
    }

    public interface ShopCallBackListener {
        void callBack(List<ShopBean.DataBean> list);
    }
}
