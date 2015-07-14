package com.example.manipalfreshers;

import java.util.Random;

import android.os.Bundle;
import android.os.Handler;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private String[] drawerListViewItems;
    private DrawerLayout drawerLayout;
    private ListView drawerListView;
    int []imageArray={R.drawable.back1,R.drawable.back2,R.drawable.back3};
    private ImageView i1;
	private Random randomGenerator = new Random();
	private final Handler handler = new Handler();
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		i1=(ImageView) findViewById(R.id.imageView1);
		// get list items from strings.xml
		drawerListViewItems = getResources().getStringArray(R.array.quicklinks);
		// get ListView defined in activity_main.xml
		drawerListView = (ListView) findViewById(R.id.left_drawer);

       // Set the adapter for the list view
		drawerListView.setAdapter(new ArrayAdapter<String>(this,
                R.layout.listview, drawerListViewItems));
      
		// 2. App Icon 
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        
        // 2.1 enable and show "up" arrow
       if (android.os.Build.VERSION.SDK_INT >= 11)
           getActionBar().setDisplayHomeAsUpEnabled(true);
         
        
        // just styling option
		drawerLayout.setDrawerShadow(android.R.drawable.alert_dark_frame, GravityCompat.START);
		
		drawerListView.setOnItemClickListener(new DrawerItemClickListener());
		
		
		Runnable runnable = new Runnable() {
	           public void run() {
	        	   int i = randomGenerator.nextInt(3);
	               i1.setImageResource(imageArray[i]);
	               handler.postDelayed(this, 1000);
	           }
	       };
	    handler.postDelayed(runnable,0);   

}
	
	private class DrawerItemClickListener implements ListView.OnItemClickListener {
	    @Override
	    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	    	String s = ((TextView)view).getText().toString();
	    	if (s.equalsIgnoreCase("Home")){
	    		
	    	}
	    	else if (s.equalsIgnoreCase("Websis")){
	    		Intent i = new Intent(MainActivity.this,Websis_Activity.class);
	    		startActivity(i);
	    	}
	    	else if (s.equalsIgnoreCase("manipal.edu")){
	    		Intent i = new Intent(MainActivity.this,Website_Activity.class);
	    		startActivity(i);
	    	}
	    	else if (s.equalsIgnoreCase("mitfiles.com")){
	    		Intent i = new Intent(MainActivity.this,MitFiles_Activity.class);
	    		startActivity(i);
	    	}
	    	else if (s.equalsIgnoreCase("MTTN")){
	    		Intent i = new Intent(MainActivity.this,MTTN_Activity.class);
	    		startActivity(i);
	    	}
	    	else if (s.equalsIgnoreCase("TechTatva")){
	    		Intent i = new Intent(MainActivity.this,Techtatva_Activity.class);
	    		startActivity(i);
	    	}
	    	else if (s.equalsIgnoreCase("Revels")){
	    		Intent i = new Intent(MainActivity.this,Revels_Activity.class);
	    		startActivity(i);
	    	}
	    	else if (s.equalsIgnoreCase("StudentCouncil")){
	    		Intent i = new Intent(MainActivity.this,Student_council_Activity.class);
	    		startActivity(i);
	    	}
	        
	    	else if (s.equalsIgnoreCase("Manipal Blog")){
	    		Intent i = new Intent(MainActivity.this,Manipal_blog_Activity.class);
	    		startActivity(i);
	    	}
	    	else if (s.equalsIgnoreCase("Contact us")){
	    		Intent i = new Intent(MainActivity.this,Contact_us_Activity.class);
	    		startActivity(i);
	    	}
	        
	    	Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
	    	drawerLayout.closeDrawer(drawerListView);

	    }
	}


}