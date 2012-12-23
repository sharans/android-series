package tw.workshop.activities;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import tw.workshop.R;
import tw.workshop.adapter.StatusAdapter;
import tw.workshop.model.Status;

import java.util.ArrayList;
import java.util.List;

public class StatusListActivity extends RoboActivity {

    private static String TAG = "standup-updates-application";

    @InjectView(R.id.status_list)
    ListView statusListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_details);


        List<Status> statuses = new ArrayList<Status>();
        statuses.add(new Status("1341", "InProgress"));
        statuses.add(new Status("1443", "Done"));

        statusListView.setAdapter(new StatusAdapter(this, statuses));
    }

}

