package com.example.manipalfreshers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi") public class Manipal_blog_Activity extends Activity{
	private String[] drawerListViewItems;
    private DrawerLayout drawerLayout;
    private ListView drawerListView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.manipalblog_page);
		// get list items from strings.xml
				drawerListViewItems = getResources().getStringArray(R.array.quicklinks);
				// get ListView defined in activity_main.xml
				drawerListView = (ListView) findViewById(R.id.left_drawer);
		       // Set the adapter for the list view
				drawerListView.setAdapter(new ArrayAdapter<String>(this, R.layout.listview, drawerListViewItems));
				// 2. App Icon 
				drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		        // 2.1 enable and show "up" arrow
		        if (android.os.Build.VERSION.SDK_INT >= 11)
		           getActionBar().setDisplayHomeAsUpEnabled(true);
		        // just styling option
				drawerLayout.setDrawerShadow(android.R.drawable.alert_dark_frame, GravityCompat.START);
				drawerListView.setOnItemClickListener(new DrawerItemClickListener());
			}
			private class DrawerItemClickListener implements ListView.OnItemClickListener {
				    @Override
				    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				    	String s = ((TextView)view).getText().toString();
				    	if (s.equalsIgnoreCase("Home")){
				    		Intent i = new Intent(Manipal_blog_Activity.this,MainActivity.class);
				    		startActivity(i);
				    	}
				    	else if (s.equalsIgnoreCase("Websis")){
				    		Intent i = new Intent(Manipal_blog_Activity.this,Websis_Activity.class);
				    		startActivity(i);
				    	}
				    	else if (s.equalsIgnoreCase("manipal.edu")){
				    		Intent i = new Intent(Manipal_blog_Activity.this,Website_Activity.class);
				    		startActivity(i);
				    	}
				    	else if (s.equalsIgnoreCase("mitfiles.com")){
				    		Intent i = new Intent(Manipal_blog_Activity.this,MitFiles_Activity.class);
				    		startActivity(i);
				    	}
				    	else if (s.equalsIgnoreCase("MTTN")){
				    		Intent i = new Intent(Manipal_blog_Activity.this,MTTN_Activity.class);
				    		startActivity(i);
				    	}
				    	else if (s.equalsIgnoreCase("TechTatva")){
				    		Intent i = new Intent(Manipal_blog_Activity.this,Techtatva_Activity.class);
				    		startActivity(i);
				    	}
				    	else if (s.equalsIgnoreCase("Revels")){
				    		Intent i = new Intent(Manipal_blog_Activity.this,Revels_Activity.class);
				    		startActivity(i);
				    	}
				    	else if (s.equalsIgnoreCase("StudentCouncil")){
				    		Intent i = new Intent(Manipal_blog_Activity.this,Student_council_Activity.class);
				    		startActivity(i);
				    	}
				        
				    	else if (s.equalsIgnoreCase("Manipal Blog")){
				    		
				    	}
				    	else if (s.equalsIgnoreCase("Contact us")){
				    		Intent i = new Intent(Manipal_blog_Activity.this,Contact_us_Activity.class);
				    		startActivity(i);
				    	}
				        
				    	Toast.makeText(Manipal_blog_Activity.this, s, Toast.LENGTH_LONG).show();
				    	drawerLayout.closeDrawer(drawerListView);

				    }
				}

	}
	
