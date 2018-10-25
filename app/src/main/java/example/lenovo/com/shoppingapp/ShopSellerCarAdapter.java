package example.lenovo.com.shoppingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * author：shashe
 * 日期：2018/10/24
 * 展示商家里的商品适配器
 */
public class ShopSellerCarAdapter extends RecyclerView.Adapter<ShopSellerCarAdapter.MyViewHolder> {
    private Context context;
    private List<ShopBean.DataBean.ListBean> list = new ArrayList<>();

    public ShopSellerCarAdapter(Context context, List<ShopBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ShopSellerCarAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.shop_car_adapter, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopSellerCarAdapter.MyViewHolder myViewHolder, final int i) {
        Picasso.with(context).load(list.get(i).getImages().split("\\|")[0]).fit().into(myViewHolder.carImage);
        myViewHolder.carTitle.setText(list.get(i).getTitle());
        myViewHolder.carPrice.setText(list.get(i).getPrice() + "");
        if (list.get(i).isCheck()) {//选中
            myViewHolder.carCricle.setImageResource(R.drawable.cricle_yes);
        } else {
            myViewHolder.carCricle.setImageResource(R.drawable.cricle_no);
        }
        //点击商品选中
        myViewHolder.carCricle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list.get(i).isCheck()) {
                    list.get(i).setCheck(false);
                } else {
                    list.get(i).setCheck(true);
                }
                notifyItemChanged(i);
                listener.callBack();
            }
        });
        //设置自定义View的Edit
        myViewHolder.shopCarPriceLayout.setData(this,list,i);
        myViewHolder.shopCarPriceLayout.setOnCallBack(new ShopCarPriceLayout.CallBackListener() {
            @Override
            public void callBack() {
                listener.callBack();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView carImage, carCricle;
        TextView carTitle, carPrice;
        ShopCarPriceLayout shopCarPriceLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            carImage = itemView.findViewById(R.id.car_image);
            carTitle = itemView.findViewById(R.id.car_title);
            carPrice = itemView.findViewById(R.id.car_price);
            carCricle = itemView.findViewById(R.id.car_cricle);
            shopCarPriceLayout=itemView.findViewById(R.id.shopcarpricelayout);
        }
    }

    //传递接口
    private ShopCallBackListener listener;

    public void setListener(ShopCallBackListener listener) {
        this.listener = listener;
    }

    public interface ShopCallBackListener {
        void callBack();
    }
}
