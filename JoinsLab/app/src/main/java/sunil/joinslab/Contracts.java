package sunil.joinslab;

import android.provider.BaseColumns;

public final class Contracts {
    //For a less-crowded Helper file...
    private Contracts(){}


    public static abstract class EmpTable implements BaseColumns {

        public static final String TABLE_NAME = "employee_information";
        public static final String COL_SSN = "social_security_num";
        public static final String COL_FIRST = "first_name";
        public static final String COL_LAST = "last_name";
        public static final String COL_YOB = "year_of_birth";
        public static final String COL_CITY = "city";

        public static final String CREATE_TABLE =
                "CREATE TABLE " + EmpTable.TABLE_NAME + " (" +
                        EmpTable._ID+" INTEGER," +
                        EmpTable.COL_SSN+" INTEGER PRIMARY KEY," +
                        EmpTable.COL_FIRST+" TEXT," +
                        EmpTable.COL_LAST+" TEXT," +
                        EmpTable.COL_YOB+" INTEGER," +
                        EmpTable.COL_CITY+" TEXT" +
                        " )";

        public static final String DELETE_EMP_TABLE =
                "DROP TABLE IF EXISTS "+ EmpTable.TABLE_NAME;
    }

    public static abstract class JobTable implements BaseColumns{

        public static final String TABLE_NAME = "department_information";
        public static final String COL_SSN = "ssn";
        public static final String COL_COMP = "company";
        public static final String COL_SAL = "salary";
        public static final String COL_EXP = "experience";

        public static final String CREATE_TABLE =
                "CREATE TABLE " + JobTable.TABLE_NAME+ "( " +
                        JobTable._ID+" INTEGER PRIMARY KEY," +
                        JobTable.COL_SSN+" INTEGER, " +
                        JobTable.COL_COMP+" TEXT, "+
                        JobTable.COL_SAL+" TEXT, "+
                        JobTable.COL_EXP+" TEXT, "+
                        "FOREIGN KEY ("+COL_SSN+") REFERENCES "+EmpTable.TABLE_NAME+"("+ EmpTable.COL_SSN+") )";

        public static final String DELETE_DEPT_TABLE =
                "DROP TABLE IF EXISTS "+ JobTable.TABLE_NAME;
    }
}


