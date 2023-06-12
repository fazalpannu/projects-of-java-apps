//package com.example.a20f0196.CardViewExample;
//
//import static android.os.Build.VERSION_CODES.R;
//
//import android.os.Bundle;
//import android.view.View;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.a20f0196.databinding.ActivityCardViewScrollingMainBinding;
//import com.google.android.material.appbar.CollapsingToolbarLayout;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.android.material.snackbar.Snackbar;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CardViewScrollingActivityMain extends AppCompatActivity {
//
//    private ActivityCardViewScrollingMainBinding binding;
//public ArrayList<mymodel> mymodelList;
//public MyClassViewAdapter adapter;
//public RecyclerView recyclerView;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        binding = ActivityCardViewScrollingMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        Toolbar toolbar = binding.toolbar;
//        setSupportActionBar(toolbar);
//        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
//        toolBarLayout.setTitle(getTitle());
//
//        FloatingActionButton fab = binding.fab;
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
////        recyclerView=findViewById(R.id.vi)
////        mymodelList=new ArrayList<>();
////        adapter =new MyClassViewAdapter(this,mymodelList);
////        recyclerView=setAdapter(adapter);
//
//
//    }
//    public void insetdata()
//    {
////        int [] mydrawables=new int []
////                {
////                      //  R.drawable.
////                }
//
//    }
//}