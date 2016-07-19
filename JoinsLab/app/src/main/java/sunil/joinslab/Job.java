package sunil.joinslab;


public class Job {
    private int mSSN;
    private String mCompany;
    private double mSalary;
    private int mExperience;

    public Job(int soc, String comp, double sal, int exp){
        mSSN = soc;
        mCompany = comp;
        mSalary = sal;
        mExperience = exp;
    }

    public int getSocSec(){return mSSN;}
    public void setSocSec(int s){mSSN = s;}

    public String getCompany(){return mCompany;}
    public void setCompany(String c){mCompany = c;}

    public double getSalary(){return mSalary;}
    public void setmSalary(double s){mSalary = s;}

    public int getExperience(){return mExperience;}
    public void setmExperience(int e){mExperience = e;}

}
