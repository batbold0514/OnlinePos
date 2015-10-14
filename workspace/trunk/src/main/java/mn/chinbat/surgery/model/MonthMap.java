package mn.chinbat.surgery.model;

public class MonthMap {
	private int count;
	private ServicePrice sp;
	public MonthMap(ServicePrice sp , int count){
		this.sp = sp;
		this.count = count;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ServicePrice getSp() {
		return sp;
	}
	public void setSp(ServicePrice sp) {
		this.sp = sp;
	}
	
}
