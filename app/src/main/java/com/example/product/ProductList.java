package com.example.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductList extends AppCompatActivity {


    GridView gridView;
    HashMap<String,String>hashMap;
    ImageView home,febroit,user,homeshape,ferboitshape,usershape;
    ArrayList< HashMap<String,String>>arrayList = new ArrayList<>();
    Toolbar toolbar;
    LottieAnimationView lottieAnimationViews;

    public  static int number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        setSupportActionBar(toolbar);

        Find_view_ByID();
        JsonObjectPash();

    }




    private void Find_view_ByID() {

        gridView = findViewById(R.id.gridview_plist);
        lottieAnimationViews = findViewById(R.id.animation_mo);
    }

    public class Mylist extends BaseAdapter{

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
           View myview = layoutInflater.inflate(R.layout.product_model,gridView,false);

            ImageView febroit,img_thamble,febroid_sh;
            TextView rating_tv,name_tv,price_tv;
            CardView cardView;
            LottieAnimationView lottieAnimationView;

            lottieAnimationView = myview.findViewById(R.id.lodingber);
            name_tv = myview.findViewById(R.id.name_pm);
            rating_tv = myview.findViewById(R.id.rating_tv_pm);
            price_tv = myview.findViewById(R.id.price_pm);
            febroit = myview.findViewById(R.id.febroid_border_pm);
            img_thamble = myview.findViewById(R.id.thamble_pm);
            cardView = myview.findViewById(R.id.cardview_pm_fst);
            febroid_sh = myview.findViewById(R.id.febroid_shape_border_pm);


            HashMap<String,String> hashMapone = arrayList.get(i);

            String names = hashMapone.get("title");
            String ratings = hashMapone.get("rating");
            String prices = hashMapone.get("price");
            String thumbnails = hashMapone.get("thumbnail");
            String id = hashMapone.get("id");
            String description = hashMapone.get("description");
            String discountPercentage = hashMapone.get("discountPercentage");
            String stock = hashMapone.get("stock");
            String brand = hashMapone.get("brand");
            String category = hashMapone.get("category");



            name_tv.setText(names);
            rating_tv.setText(ratings);
            price_tv.setText("$"+prices);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    lottieAnimationView.setVisibility(View.GONE);
                    img_thamble.setVisibility(View.VISIBLE);

                    Picasso.get().load(thumbnails)
                            .into(img_thamble);

                }
            },500);









            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if( id.contains("1") )
                    {
                        Intent intent = new Intent(ProductList.this,ProductView.class);
                        startActivity(intent);
                        number =1;

                        ProductView.name = names;
                        ProductView.rating = ratings;
                        ProductView.price = prices;
                        ProductView.description = description;
                        ProductView.discount = discountPercentage;
                        ProductView.stock = stock;
                        ProductView.brand = brand;
                        ProductView.category = category;


                        febroit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                febroit.setVisibility(View.INVISIBLE);
                                febroid_sh.setVisibility(View.VISIBLE);

                            }
                        });

                        febroid_sh.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                febroit.setVisibility(View.VISIBLE);
                                febroid_sh.setVisibility(View.GONE);

                            }
                        });



                    } else if (id.contains("2")) {
                        Intent intent = new Intent(ProductList.this,ProductView.class);
                        startActivity(intent);
                        number =2;
                        ProductView.name = names;
                        ProductView.rating = ratings;
                        ProductView.price = prices;
                        ProductView.description = description;
                        ProductView.discount = discountPercentage;
                        ProductView.stock = stock;
                        ProductView.brand = brand;
                        ProductView.category = category;

                        febroit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                febroit.setVisibility(View.INVISIBLE);
                                febroid_sh.setVisibility(View.VISIBLE);

                            }
                        });

                        febroid_sh.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                febroit.setVisibility(View.VISIBLE);
                                febroid_sh.setVisibility(View.INVISIBLE);

                            }
                        });


                    } else if (id.contains("3")) {

                        Intent intent = new Intent(ProductList.this,ProductView.class);
                        startActivity(intent);
                        number =3;
                        ProductView.name = names;
                        ProductView.rating = ratings;
                        ProductView.price = prices;
                        ProductView.description = description;
                        ProductView.discount = discountPercentage;
                        ProductView.stock = stock;
                        ProductView.brand = brand;
                        ProductView.category = category;

                        febroit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                febroit.setVisibility(View.INVISIBLE);
                                febroid_sh.setVisibility(View.VISIBLE);

                            }
                        });

                        febroid_sh.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                febroit.setVisibility(View.VISIBLE);
                                febroid_sh.setVisibility(View.INVISIBLE);

                            }
                        });

                    } else if (id.contains("4")) {

                        Intent intent = new Intent(ProductList.this,ProductView.class);
                        startActivity(intent);
                        number =4;
                        ProductView.name = names;
                        ProductView.rating = ratings;
                        ProductView.price = prices;
                        ProductView.description = description;
                        ProductView.discount = discountPercentage;
                        ProductView.stock = stock;
                        ProductView.brand = brand;
                        ProductView.category = category;

                        febroit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                febroit.setVisibility(View.INVISIBLE);
                                febroid_sh.setVisibility(View.VISIBLE);

                            }
                        });

                        febroid_sh.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                febroit.setVisibility(View.VISIBLE);
                                febroid_sh.setVisibility(View.INVISIBLE);

                            }
                        });

                    } else if (id.contains("5")) {
                        Intent intent = new Intent(ProductList.this,ProductView.class);
                        startActivity(intent);
                        number =5;

                        ProductView.name = names;
                        ProductView.rating = ratings;
                        ProductView.price = prices;
                        ProductView.description = description;
                        ProductView.discount = discountPercentage;
                        ProductView.stock = stock;
                        ProductView.brand = brand;
                        ProductView.category = category;

                    } else if (id.contains("6")) {

                        Intent intent = new Intent(ProductList.this,ProductView.class);
                        startActivity(intent);
                        number =6;

                        ProductView.name = names;
                        ProductView.rating = ratings;
                        ProductView.price = prices;
                        ProductView.description = description;
                        ProductView.discount = discountPercentage;
                        ProductView.stock = stock;
                        ProductView.brand = brand;
                        ProductView.category = category;

                    } else if (id.contains("7")) {

                        Intent intent = new Intent(ProductList.this,ProductView.class);
                        startActivity(intent);
                        number =7;

                        ProductView.name = names;
                        ProductView.rating = ratings;
                        ProductView.price = prices;
                        ProductView.description = description;
                        ProductView.discount = discountPercentage;
                        ProductView.stock = stock;
                        ProductView.brand = brand;
                        ProductView.category = category;

                    } else if (id.contains("8")) {
                        Intent intent = new Intent(ProductList.this,ProductView.class);
                        startActivity(intent);
                        number =8;

                        ProductView.name = names;
                        ProductView.rating = ratings;
                        ProductView.price = prices;
                        ProductView.description = description;
                        ProductView.discount = discountPercentage;
                        ProductView.stock = stock;
                        ProductView.brand = brand;
                        ProductView.category = category;

                    } else if (id.contains("9")) {

                        Intent intent = new Intent(ProductList.this,ProductView.class);
                        startActivity(intent);
                        number =9;

                        ProductView.name = names;
                        ProductView.rating = ratings;
                        ProductView.price = prices;
                        ProductView.description = description;
                        ProductView.discount = discountPercentage;
                        ProductView.stock = stock;
                        ProductView.brand = brand;
                        ProductView.category = category;

                    } else if (id.contains("10")) {

                        Intent intent = new Intent(ProductList.this,ProductView.class);
                        startActivity(intent);
                        number =10;

                        ProductView.name = names;
                        ProductView.rating = ratings;
                        ProductView.price = prices;
                        ProductView.description = description;
                        ProductView.discount = discountPercentage;
                        ProductView.stock = stock;
                        ProductView.brand = brand;
                        ProductView.category = category;

                    } else if (id.contains("11")) {

                        othersActvity(11);
                        othersString(names,ratings,prices,description,discountPercentage,stock,brand,category);

                    } else if (id.contains("12")) {
                        othersActvity(12);
                        othersString(names,ratings,prices,description,discountPercentage,stock,brand,category);

                    } else if (id.contains("13")) {
                        othersActvity(13);
                        othersString(names,ratings,prices,description,discountPercentage,stock,brand,category);

                    } else if (id.contains("14")) {
                        othersActvity(14);
                        othersString(names,ratings,prices,description,discountPercentage,stock,brand,category);

                    } else if (id.contains("15")) {
                        othersActvity(15);
                        othersString(names,ratings,prices,description,discountPercentage,stock,brand,category);

                    } else if (id.contains("16")) {
                        othersActvity(16);
                        othersString(names,ratings,prices,description,discountPercentage,stock,brand,category);

                    } else if (id.contains("17")) {
                        othersActvity(17);
                        othersString(names,ratings,prices,description,discountPercentage,stock,brand,category);

                    } else if (id.contains("18")) {
                        othersActvity(18);
                        othersString(names,ratings,prices,description,discountPercentage,stock,brand,category);

                    } else if (id.contains("19")) {
                        othersActvity(19);
                        othersString(names,ratings,prices,description,discountPercentage,stock,brand,category);

                    } else if (id.contains("20")) {
                        othersActvity(20);
                        othersString(names,ratings,prices,description,discountPercentage,stock,brand,category);

                    }


                }
            });

            return myview;
        }
    }

    private void JsonObjectPash(){

        String url = "https://dummyjson.com/products";
        JsonObjectRequest  jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray jsonArray = response.getJSONArray("products");

                    for (int i=0; i<jsonArray.length(); i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String id = jsonObject.getString("id");
                        String title = jsonObject.getString("title");
                        String description = jsonObject.getString("description");
                        String price = jsonObject.getString("price");
                        String discountPercentage = jsonObject.getString("discountPercentage");
                        String rating = jsonObject.getString("rating");
                        String stock = jsonObject.getString("stock");
                        String brand = jsonObject.getString("brand");
                        String category = jsonObject.getString("category");
                        String thumbnail = jsonObject.getString("thumbnail");

                        hashMap = new HashMap<>();
                        hashMap.put("id",id);
                        hashMap.put("title",title);
                        hashMap.put("description",description);
                        hashMap.put("price",price);
                        hashMap.put("discountPercentage",discountPercentage);
                        hashMap.put("rating",rating);
                        hashMap.put("stock",stock);
                        hashMap.put("brand",brand);
                        hashMap.put("category",category);
                        hashMap.put("thumbnail",thumbnail);

                        arrayList.add(hashMap);


                        JSONArray myjson = jsonObject.getJSONArray("images");
                        String image = myjson.getString(0);


                    }

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            gridView.setVisibility(View.VISIBLE);
                            lottieAnimationViews.setVisibility(View.GONE);

                            Mylist mylist = new Mylist();
                            gridView.setAdapter(mylist);

                        }
                    },500);




                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue queue = Volley.newRequestQueue(ProductList.this);
        queue.add(jsonObjectRequest);

    }


    private void othersActvity(int num)
    {
        Intent intent = new Intent(ProductList.this,ProductView.class);
        startActivity(intent);
        number =num;
    }
    private void othersString(String names,String ratings,String prices,String description,String discountPercentage,String stock,String brand,String category)
    {
        ProductView.name = names;
        ProductView.rating = ratings;
        ProductView.price = prices;
        ProductView.description = description;
        ProductView.discount = discountPercentage;
        ProductView.stock = stock;
        ProductView.brand = brand;
        ProductView.category = category;
    }





}