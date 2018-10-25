package example.lenovo.com.shoppingapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * author：shashe
 * 日期：2018/10/24
 */
public class ShopCarPriceLayout extends RelativeLayout implements View.OnClickListener {
    private EditText editCar;
    public ShopCarPriceLayout(Context context) {
        super(context);
        init(context);
    }

    public ShopCarPriceLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ShopCarPriceLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private Context context;
    private void init(Context context) {
        this.context=context;
        View view = View.inflate(context, R.layout.shop_car_price_layout, null);
        ImageView addImage=view.findViewById(R.id.add_car);
        ImageView jianImage=view.findViewById(R.id.jian_car);
        editCar=view.findViewById(R.id.edit_shop_car);
        addImage.setOnClickListener(this);
        jianImage.setOnClickListener(this);
        addView(view);
    }

    private int num;
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_car://增加
                num++;
                editCar.setText(num+"");
                list.get(position).setNum(num);
                listener.callBack();
                shopSellerCarAdapter.notifyItemChanged(position);
                break;
            case R.id.jian_car://减少
                if (num>1){
                    num--;
                }else {
                    Toast.makeText(context,"我是有底线的",Toast.LENGTH_SHORT).show();
                }
                editCar.setText(num+"");
                list.get(position).setNum(num);
                listener.callBack();
                shopSellerCarAdapter.notifyItemChanged(position);
                break;
        }
    }
    //传递的数据
    List<ShopBean.DataBean.ListBean> list=new ArrayList<>();
    private int position;
    private ShopSellerCarAdapter shopSellerCarAdapter;
    public void setData(ShopSellerCarAdapter shopSellerCarAdapter, List<ShopBean.DataBean.ListBean> list, int i) {
        this.list=list;
        this.shopSellerCarAdapter=shopSellerCarAdapter;
        position=i;
        num = list.get(i).getNum();
        editCar.setText(num+"");
    }
    //接口传递
    private CallBackListener listener;
    public void setOnCallBack(CallBackListener listener){
        this.listener=listener;
    }
    public interface CallBackListener{
        void callBack();
    }
}
