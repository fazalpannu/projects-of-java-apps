package com.example.a20f0196.SensorExample.RestApiExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.example.a20f0196.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyReatApiMainActivity extends AppCompatActivity {
 MyRetrofitInter apiInterface;
 RecyclerView recyclerView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reat_api_main);
        recyclerView=findViewById(R.id.myrestrecylclerview);
        apiInterface=MyRetrofitConnection.getMyRetrofit().create(MyRetrofitInter.class);
        GetAllPost();
        GetAllCommentsByQuery();
        GetAllCommentsById();
        GetAllComments();
    }
private void GetAllComments() {
    apiInterface.getComments().enqueue(new Callback<List<MyCommentsModel>>() {


        @Override
        public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
            if(response.body().size()>0)
            {

                for(MyCommentsModel myCommentsModel: response.body())
                {
                    Log.d("Tag","ID"+MyCommentsModel.getId()+"PostID"+MyCommentsModel.getPostId()+"name"+MyCommentsModel.getName()+"Email"+MyCommentsModel.getEmail()+"Email"+MyCommentsModel.getBody());
                }

//

            }
            else
            {
                Log.d("TAG","List is empty");
            }
        }

        @Override
        public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {
            Log.d("TAG","Failure");
        }
    });

}


    private void GetAllCommentsById() {
        apiInterface.getCommentsById(3).enqueue(new Callback<List<MyCommentsModel>>() {


            @Override
            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
                if(response.body().size()>0)
                {

                    for(MyCommentsModel myCommentsModel: response.body())
                    {
                        Log.d("Tag","ID"+MyCommentsModel.getId()+"PostID"+MyCommentsModel.getPostId()+"name"+MyCommentsModel.getName()+"Email"+MyCommentsModel.getEmail()+"Email"+MyCommentsModel.getBody());
                    }

//

                }
                else
                {
                    Log.d("TAG","List is empty");
                }
            }

            @Override
            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {
                Log.d("TAG","Failure");
            }
        });

    }

    private void GetAllCommentsByQuery() {
        apiInterface.getcommentsbyquery(3).enqueue(new Callback<List<MyCommentsModel>>() {


            @Override
            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
                if(response.body().size()>0)
                {

                    for(MyCommentsModel myCommentsModel: response.body())
                    {
                        Log.d("Tag","ID"+MyCommentsModel.getId()+"PostID"+MyCommentsModel.getPostId()+"name"+MyCommentsModel.getName()+"Email"+MyCommentsModel.getEmail()+"Email"+MyCommentsModel.getBody());
                    }

//

                }
                else
                {
                    Log.d("TAG","List is empty");
                }
            }

            @Override
            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {
                Log.d("TAG","Failure");
            }
        });

    }

    private void GetAllCommentsByQuery2() {
        apiInterface.getcommentsbyquery2(3,"id","desc").enqueue(new Callback<List<MyCommentsModel>>() {


            @Override
            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
                if(response.body().size()>0)
                {

                    for(MyCommentsModel myCommentsModel: response.body())
                    {
                        Log.d("Tag","ID"+MyCommentsModel.getId()+"PostID"+MyCommentsModel.getPostId()+"name"+MyCommentsModel.getName()+"Email"+MyCommentsModel.getEmail()+"Email"+MyCommentsModel.getBody());
                    }

//

                }
                else
                {
                    Log.d("TAG","List is empty");
                }
            }

            @Override
            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {
                Log.d("TAG","Failure");
            }
        });

    }


    private void Createpost()
    {
        MypPostModel mypPostModel=new MypPostModel(10,5,"title of my post","body of my post");
        Call<MypPostModel> mypost=apiInterface.createPost(mypPostModel);
      mypost.enqueue(new Callback<MypPostModel>() {
          @Override
          public void onResponse(Call<MypPostModel> call, Response<MypPostModel> response) {
              if (response.isSuccessful())
              {
                  Log.d("Tag"," "+response.body().getUserId()+" "+response.body().getId()+"+ "+response.body().getTitle());
              }
          }

          @Override
          public void onFailure(Call<MypPostModel> call, Throwable t) {

          }
      });
    }

    private void GetAllPost() {
        apiInterface.getPosts().enqueue(new Callback<List<MypPostModel>>() {
            @Override
            public void onResponse(Call<List<MypPostModel>> call, Response<List<MypPostModel>> response) {
                if(response.body().size()>0)
                {
                    Log.d("TAG","Data REtrieved");
                    List<MypPostModel> list=response.body();
                    myrestadapter adapter=new myrestadapter(list,MyReatApiMainActivity.this);
                    LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MyReatApiMainActivity.this);
                    recyclerView.setAdapter(adapter);

                }
                else
                {
                    Log.d("TAG","List is empty");
                }
            }

            @Override
            public void onFailure(Call<List<MypPostModel>> call, Throwable t) {
                Log.d("TAG","Failure");
            }
        });
    }
}