package test;
/**
 * ������������
 * @author ctk
 *
 */
public class PCData {
    private int data;
    public PCData(int d){
        data = d;
    }
    public PCData(String d){
        data = Integer.valueOf(d);
    }
    public int getData(){
        return data;
    }
    @Override
    public String toString(){
        return "data:"+data;
    }
	public void setData(int data) {
        this.data = data;
    }
}