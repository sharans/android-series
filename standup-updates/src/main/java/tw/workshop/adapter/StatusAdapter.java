package tw.workshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import tw.workshop.R;
import tw.workshop.model.Status;

import java.util.List;

public class StatusAdapter extends ArrayAdapter<Status> {
    public StatusAdapter(Context context, List<Status> objects) {
        super(context, R.layout.status_row, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflator = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflator.inflate(R.layout.status_row, parent, false);
        }
        TextView storyNumberTextView = (TextView) convertView.findViewById(R.id.story_number);
        storyNumberTextView.setText(getItem(position).getStoryNumber());
        TextView storyStatusTextView = (TextView) convertView.findViewById(R.id.story_status);
        storyStatusTextView.setText(getItem(position).getStoryStatus());
        return convertView;
    }

}
