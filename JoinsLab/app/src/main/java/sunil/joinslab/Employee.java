package sunil.joinslab;


public class Employee {
    private int mSoSec;
    private String mFirstName;
    private String mLastName;
    private int mYearBirth;
    private String mCity;

    public Employee(int ss, String f, String l, int yr, String c){
        mSoSec = ss;
        mFirstName = f;
        mLastName = l;
        mYearBirth = yr;
        mCity = c;
    }

    public int getSoSec(){return mSoSec;}
    public void setSoSec(int s){mSoSec = s;}

    public String getFirstName(){return mFirstName;}
    public void setFirstName(String f){mFirstName = f;}

    public String getLastName(){return mLastName;}
    public void setmLastName(String l){mLastName = l;}

    public int getmYearBirth(){return mYearBirth;}
    public void setmYearBirth(int y){mYearBirth = y;}

    public String getCity(){return mCity;}
    public void setCity(String c){mCity = c;}
}
