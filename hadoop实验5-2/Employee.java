package cwg.V17034460115.hadoop;


import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;


public class Employee implements Writable {
    private int empno;
    private String ename;
    private  String job;
    private int mgr;

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public int getComm() {
        return comm;
    }

    public void setComm(int comm) {
        this.comm = comm;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    private String hiredate;
    private int sal;
    private int comm;
    private int deptno;
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(this.empno);
        out.writeUTF(this.ename);
        out.writeUTF(this.job);
        out.writeInt(this.mgr);
        out.writeUTF(this.hiredate);
        out.writeInt(this.sal);
        out.writeInt(this.comm);
        out.writeInt(this.deptno);
    }

    public void readFields(DataInput in) throws IOException {
        this.empno = in.readInt();
        this.ename = in.readUTF();
        this.job = in.readUTF();
        this.mgr = in.readInt();
        this.hiredate = in.readUTF();
        this.sal = in.readInt();
        this.comm = in.readInt();
        this.deptno = in.readInt();
    }
}
