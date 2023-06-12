package com.example.a20f0196.SensorExample.RestApiExample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyRetrofitInter {
   @GET("posts")
   Call<List<MypPostModel> > getPosts();

   @GET("posts/{1}/comments")
   Call<List<MyCommentsModel> > getComments();
   @GET("posts/{id}/comments")
   Call<List<MyCommentsModel> > getCommentsById(@Path("id") int id);
   @GET("comments")
   Call<List<MyCommentsModel>> getcommentsbyquery(@Query("postid") int id);

   @GET("comments")
   Call<List<MyCommentsModel>> getcommentsbyquery2(@Query("postid") int id,@Query("_sort") String sort,@Query("order") String orderby);
    @POST("psot")
   Call<MypPostModel> createPost(@Body MypPostModel post);

}
