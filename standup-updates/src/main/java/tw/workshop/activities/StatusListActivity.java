package tw.workshop.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.status_row, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == R.id.add){
            showAddStatus();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAddStatus() {
        Toast.makeText(StatusListActivity.this, "Add menu clicked", Toast.LENGTH_LONG).show();
    }
}

