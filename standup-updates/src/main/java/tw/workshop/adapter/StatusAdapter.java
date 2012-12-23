package tw.workshop.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import tw.workshop.model.Status;

import java.util.ArrayList;
import java.util.List;

public class StatusAdapter extends BaseAdapter {
    private List<Status> statusList;

    public StatusAdapter() {
        statusList = new ArrayList<Status>();
        statusList.add(new Status("1341", "InProgress"));
    }

    @Override
    public int getCount() {
       return statusList.size();
    }

    @Override
    public Object getItem(int i) {
        return statusList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
