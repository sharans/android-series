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

public class AddStatusActivity extends RoboActivity {

    public static final Integer NEW_STATUS_ADDED = 1;
    public static final String NEW_STATUS = "NEW_STATUS";
    @InjectView(R.id.save_status)
    Button saveStatusButton;

    @InjectView(R.id.story_number_text)
    EditText storyNumberEdit;

    @InjectView(R.id.story_status_text)
    EditText storyStatusEdit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_status);

        saveStatusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Status newStatus = new Status(storyNumberEdit.getText().toString(), storyStatusEdit.getText().toString());
                Intent intent = new Intent();
                intent.putExtra(NEW_STATUS, newStatus);
                setResult(NEW_STATUS_ADDED, intent);
                finish();
            }
        });
    }
}
