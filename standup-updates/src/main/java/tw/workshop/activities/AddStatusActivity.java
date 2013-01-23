package tw.workshop.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import tw.workshop.R;
import tw.workshop.model.Status;

import static tw.workshop.datastore.StatusUpdatesHelper.COLUMN_DETAILS;
import static tw.workshop.datastore.StatusUpdatesHelper.COLUMN_STATUS;
import static tw.workshop.datastore.StatusUpdatesHelper.COLUMN_STORY_NO;

public class AddStatusActivity extends RoboActivity {

    @InjectView(R.id.save)
    private Button saveButton;

    @InjectView(R.id.story_number_text)
    private EditText storyNumber;

    @InjectView(R.id.story_status_text)
    private EditText storyStatus;

    @InjectView(R.id.details)
    private EditText details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_status);
        populateDataFromIntentToViews(getIntent());
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent data = new Intent();
                data.putExtra("new_status_item", new Status(storyNumber.getText().toString(), storyStatus.getText().toString(), details.getText().toString()));
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }

    private void populateDataFromIntentToViews(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null && !extras.isEmpty()) {
            details.setText(extras.getString(COLUMN_DETAILS));
            storyNumber.setText(extras.getString(COLUMN_STORY_NO));
            storyStatus.setText(extras.getString(COLUMN_STATUS));
            storyNumber.setEnabled(false);
        }
    }
}
