package com.example.product;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductView extends AppCompatActivity {

    TextView name_pv,discountPercentage_pv,price_pv,rating_pv,stock_pv,brand_pv,category_pv,description_pv;

    public static String name,price,rating,stock,brand,category,description = "";
    public static String discount = "";

    HashMap<String,String > hashMap;
    ArrayList<HashMap<String,String >>arrayList = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);

        FIND_VIEW_BY_ID();
        SET_TEXT_VIEW();


        RequestQueue queue = Volley.newRequestQueue(ProductView.this);

        String url ="https://dummyjson.com/products";
        JsonObjectRequest jsonObjectRequest  = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray jsonArray = response.getJSONArray("products");



                    JSONObject jsonObject = jsonArray.getJSONObject(ProductList.number);


                    JSONArray array = jsonObject.getJSONArray("images");

                    for (int x = 0; x<array.length(); x++)
                    {
                        String username = array.getString(x);

                        hashMap = new HashMap<>();
                        hashMap.put("iamgeurl",username);
                        arrayList.add(hashMap);

                    }

                    Mylists mylists = new Mylists();
                    listView.setAdapter(mylists);




                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(jsonObjectRequest);




    }

    private void SET_TEXT_VIEW() {

        name_pv.setText(name);
        discountPercentage_pv.setText("Discount :"+discount);
        price_pv.setText("price :$"+price);
        rating_pv.setText("rating :"+rating);
        stock_pv.setText("stock :"+stock);
        brand_pv.setText("Brand :"+brand);
        category_pv.setText("Category :"+category);
        description_pv.setText("Description:\n\n"+description);
    }

    private void FIND_VIEW_BY_ID() {
        listView = findViewById(R.id.listview_pv);

        name_pv = findViewById(R.id.name_pv);
        discountPercentage_pv = findViewById(R.id.discountPercentage_pv);
        price_pv = findViewById(R.id.price_pv);
        rating_pv  = findViewById(R.id.rating_pv);
        stock_pv = findViewById(R.id.stock_pv);
        brand_pv = findViewById(R.id.brand_pv);
        category_pv = findViewById(R.id.category_pv);
        description_pv = findViewById(R.id.description_pv);
    }

    public class Mylists extends BaseAdapter{


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {


            LayoutInflater layoutInflater = getLayoutInflater();
            View myview = layoutInflater.inflate(R.layout.product_view_model,listView,false);

            ImageView iamge_pv;
            LottieAnimationView lottieAnimationView;


            iamge_pv = myview.findViewById(R.id.iamge_pv);
            lottieAnimationView = myview.findViewById(R.id.animation_pv);


            HashMap<String,String>mymap = arrayList.get(i);
            String iamgeurl = mymap.get("iamgeurl");

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    lottieAnimationView.setVisibility(View.GONE);
                    iamge_pv.setVisibility(View.VISIBLE);

                    Picasso.get().load(iamgeurl)
                            .into(iamge_pv);

                }
            },200);




            return myview;
        }
    }

}