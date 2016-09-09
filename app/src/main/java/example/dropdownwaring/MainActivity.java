package example.dropdownwaring;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.dongz.dropdownwarning.DropDownWarning;

public class MainActivity extends AppCompatActivity {
    boolean on = false;
    com.dongz.dropdownwarning.DropDownWarning dropDownWarning;
    RelativeLayout rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = (RelativeLayout) findViewById(R.id.rootView);

        Button button = (Button) findViewById(R.id.button);


        dropDownWarning = new DropDownWarning.Builder(getApplicationContext(), rootView)
                .message("My Message")
                .foregroundColor(0xffffffff)
                .build();
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dropDownWarning.show();
            }
        });

    }
}
