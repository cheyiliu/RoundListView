package study.demo.roundlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(new CommonRoundListAdapter(this, getTestData()));
    }

    private List<SampleModel> getTestData() {
        ArrayList<SampleModel> list = new ArrayList<>(10);
        for (int i = 0; i <10 ; i++) {
            SampleModel sm = new SampleModel();
            sm.mIcon = R.drawable.sample_icon;
            sm.mName = "DEMO-" + i;
            list.add(sm);
        }
        return list;
    }
}
