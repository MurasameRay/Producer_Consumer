package Producer_Comsumer;

public class Repository {
	private static int count=0;
	static final int buffer=20;
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Repository.count = count;
	}

	@Override
	public String toString() {
		return "仓库里还有 [count=" + count + "个资源]";
	}
}
