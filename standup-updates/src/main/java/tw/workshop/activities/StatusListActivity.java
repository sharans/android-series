package tw.workshop.activities;

import android.content.Intent;
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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static tw.workshop.activities.AddStatusActivity.NEW_STATUS;
import static tw.workshop.activities.AddStatusActivity.NEW_STATUS_ADDED;

public class StatusListActivity extends RoboActivity {

    private static String TAG = "standup-updates-application";

    @InjectView(R.id.status_list)
    ListView statusListView;
    private List<Status> statuses;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_details);

        statuses = new ArrayList<Status>();
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
        Intent addStatusIntent = new Intent(StatusListActivity.this, AddStatusActivity.class);
        startActivityForResult(addStatusIntent, NEW_STATUS_ADDED);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if( requestCode == NEW_STATUS_ADDED) {
            Status status = (Status) data.getExtras().getSerializable(NEW_STATUS);
            statuses.add(status);
        }
    }

}

