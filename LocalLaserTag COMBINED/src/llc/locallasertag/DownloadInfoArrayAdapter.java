package llc.locallasertag;

import java.util.List;



import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DownloadInfoArrayAdapter extends ArrayAdapter<DownloadInfo> {
  // Simple class to make it so that we don't have to call findViewById frequently
  private static class ViewHolder {
    TextView textView;
    ProgressBar progressBar;
    Button button;
    DownloadInfo info;
  }
  
  
  private static final String TAG = DownloadInfoArrayAdapter.class.getSimpleName();

  public DownloadInfoArrayAdapter(Context context, int textViewResourceId,
      List<DownloadInfo> objects) {
    super(context, textViewResourceId, objects);
  }
  
  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View row = convertView;
    final DownloadInfo info = getItem(position);
    // We need to set the convertView's progressBar to null.

    ViewHolder holder = null;
    
    if(null == row) {
      LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      row = inflater.inflate(R.layout.file_download_row, parent, false);
      
      holder = new ViewHolder();
      holder.textView = (TextView) row.findViewById(R.id.downloadFileName);
      holder.progressBar = (ProgressBar) row.findViewById(R.id.downloadProgressBar);
      // Get the Drawable custom_progressbar                     
      Drawable customDrawable=  getContext().getResources().getDrawable(R.drawable.custom_progressbar);

      // set the drawable as progress drawavle

      holder.progressBar.setProgressDrawable(customDrawable);

      holder.info = info;
      
      row.setTag(holder);
    } else {
      holder = (ViewHolder) row.getTag();
      
      holder.info.setProgressBar(null);
      holder.info = info;
      holder.info.setProgressBar(holder.progressBar);
    }

    holder.textView.setText(info.getFilename());
    holder.progressBar.setProgress(info.getProgress());
    holder.progressBar.setMax(info.getFileSize());
    info.setProgressBar(holder.progressBar);
    
   // FileDownloadTask task = new FileDownloadTask(info);
    //task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    
    
    
    //TODO: When reusing a view, invalidate the current progressBar.
    
    return row;
  }

}
