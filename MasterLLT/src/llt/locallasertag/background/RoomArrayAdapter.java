package llt.locallasertag.background;


import java.util.ArrayList;
import java.util.List;

import llt.locallasertag.R;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class RoomArrayAdapter extends ArrayAdapter<Player> {

	private List<Player> Players;
	private Context context;
	
	  public RoomArrayAdapter(Context context, int textViewResourceId,
		      List<Player> objects) {
	
		    super(context, textViewResourceId, objects);
		    this.context = context;
		  	this.Players=objects;
		  }
	 @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    View row = convertView;
	    final Player player = getItem(position);
	    	    
	    if(null == row) {
	      LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	      row = inflater.inflate(R.layout.custom_row, parent, false);
	      TextView curText = (TextView) row.findViewById(R.id.Name);
	         curText.setText(Players.get(position).getIGN());
	     
	    }
	    
	 
	    return row;
	  }
	 
	 public void refresh(List<Player> players)
	    {
	        this.Players = players;
	        notifyDataSetChanged();
	    } 
}
