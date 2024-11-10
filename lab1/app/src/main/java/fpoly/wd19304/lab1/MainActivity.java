package fpoly.wd19304.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ToDoDAO toDoDAO;
    private ListView listView;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDoDAO = new ToDoDAO(this);
        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = editText.getText().toString();
                if (!task.isEmpty()) {
                    toDoDAO.addTask(task);
                    editText.setText("");
                    loadTasks();
                }
            }
        });

        loadTasks();
    }

    private void loadTasks() {
        List<String> tasks = toDoDAO.getAllTasks();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        listView.setAdapter(adapter);
    }
}