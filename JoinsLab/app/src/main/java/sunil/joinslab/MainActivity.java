package sunil.joinslab;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button addData, sameComp, inBoston, highSal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create Employee & Job Objects
        Employee emp1 = new Employee(123045678,"John", "Smith", 1973, "NY");
        Employee emp2 = new Employee(123045679,"David", "McWill", 1982,"Seattle");
        Employee emp3 = new Employee(123045680,"Katerina", "Wise", 1973, "Boston");
        Employee emp4 = new Employee(123045681,"Donald", "Lee", 1992, "London");
        Employee emp5 = new Employee(123045682,"Gary", "Henwood", 1987, "Las Vegas");
        Employee emp6 = new Employee(123045683,"Anthony", "Bright", 1963, "Seattle");
        Employee emp7 = new Employee(123045684,"William", "Newey", 1995, "Boston");
        Employee emp8 = new Employee(123045685,"Melony", "Smith", 1970,"Chicago");

        Job job1 = new Job(123045678,"Fuzz",60,1);
        Job job2 = new Job(123045679,"GA",70,2);
        Job job3 = new Job(123045680,"Little Place",120,5);
        Job job4 = new Job(123045681,"Macy's",78,3);
        Job job5 = new Job(123045682,"New Life",65,1);
        Job job6 = new Job(123045683,"Believe",158,6);
        Job job7 = new Job(123045684,"Macy's",200,8);
        Job job8 = new Job(123045685,"Stop",299,12);


        OpenHelper helper = OpenHelper.getInstance(MainActivity.this);

        // AddData Button does this ...
        helper.addEmployeeRow(emp1);
        helper.addEmployeeRow(emp2);
        helper.addEmployeeRow(emp3);
        helper.addEmployeeRow(emp4);
        helper.addEmployeeRow(emp5);
        helper.addEmployeeRow(emp6);
        helper.addEmployeeRow(emp7);
        helper.addEmployeeRow(emp8);

        helper.addJobRow(job1);
        helper.addJobRow(job2);
        helper.addJobRow(job3);
        helper.addJobRow(job4);
        helper.addJobRow(job5);
        helper.addJobRow(job6);
        helper.addJobRow(job7);
        helper.addJobRow(job8);

        ListView listview = (ListView) findViewById(R.id.listview);

        Cursor cursor = OpenHelper.getInstance(MainActivity.this).getSameCompany();
        CursorAdapter adapter = new CursorAdapter(MainActivity.this, cursor, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,viewGroup,false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                int firstIndex = cursor.getColumnIndex(Contracts.EmpTable.COL_FIRST);
                int lastIndex = cursor.getColumnIndex(Contracts.EmpTable.COL_LAST);
                int compIndex = cursor.getColumnIndex(Contracts.JobTable.COL_COMP);
                text.setText(cursor.getString(firstIndex)+" "+cursor.getString(lastIndex)+" "+cursor.getString(compIndex));
            }
        };
        listview.setAdapter(adapter);
    }
}
