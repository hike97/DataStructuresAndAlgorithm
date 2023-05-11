package base;

/**
 * @author: hike97
 * @createTime: 2023/05/11 14:56
 * @description: 数组实现list
 */
public class MyArrayList {
    int[] nums = new int[8];
    public MyArrayList() {
        nums[0] = 3;
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 5;
        nums[4] = 4;
        nums[5] = 9;
    }
    public int get(int i) {
        return nums[i];
    }
    public void update(int i, int n) {nums[i] = n;
    }
    public void insertTail(int n) {
        nums[6] = n;
    }
    public void insertMiddle(int p, int n) {
        for (int i = nums.length-1; i >= p-1; i--) {
            //能取得值
            if (nums[i] != 0) {
                nums[i+1]=nums[i];
            }
        }
        nums[p-1]=n;
    }
    /**
     * 旧数组复制到新数组
     */
    public void resize(){
        int[] numsNew=new int[nums.length*2];
        System.arraycopy(nums,0,numsNew,0,nums.length);
        nums=numsNew;
    }
    public void insertOutOfBounds(int p,int n){
        //数组扩容
        resize();
        nums[p-1]=n;
    }
    public void deleteMiddle(int p){
        for(int i=p;i<nums.length;i++){
            nums[i-1]=nums[i];
        }
    }
    public void display() {
        for (int n : nums) {
            System.out.println(n);
        }
    }
    public void display2() {
        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.println(nums[i]);
        }
    }
    public static void main(String[] args) {
        MyArrayList demo1 = new MyArrayList();
        demo1.deleteMiddle(3);
        demo1.display();
    }
}
