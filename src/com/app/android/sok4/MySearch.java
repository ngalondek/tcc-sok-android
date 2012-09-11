package com.app.android.sok4;


import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MySearch extends ListActivity {
    
    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        
        final Intent queryIntent = getIntent();
        final String queryAction = queryIntent.getAction();
        if (Intent.ACTION_SEARCH.equals(queryAction)) {
            doSearchWithIntent(queryIntent);
        }
	Toast.makeText(MySearch.this,
		"MySearch.onCreate", Toast.LENGTH_SHORT)
		.show();
    }
    
    private void doSearchWithIntent(final Intent queryIntent) {
        final String queryString = queryIntent.getStringExtra(SearchManager.QUERY);
        doSearchWithQuery(queryString);
    }
    
    
    
    private void doSearchWithQuery(String queryString) {
	Toast.makeText(MySearch.this,
		"§A·Q­nSearch"+queryString, Toast.LENGTH_SHORT)
		.show();
    }
}