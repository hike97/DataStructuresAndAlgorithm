package newcoder;

/**
 * @author: hike97
 * @createTime: 2023/05/18 22:40
 * @description: 合并数组
 * https://www.nowcoder.com/practice/89865d4375634fc484f3a24b7fe65665?tpId=196&tqId=37061&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj&difficulty=undefined&judgeStatus=undefined&tags=578&title=
 */
public class MergeArray {
    public static void main(String[] args) {

    }

    public void merge(int A[], int m, int B[], int n) {
        int[] tmp = new int[m+n];
        for(int k = 0,i = 0,j = 0; k < tmp.length; k++){
            if(i >= m){
                tmp[k++] = B[j++];
            }else if(j >= n){
                tmp[k++] = A[i++];
            }else if(A[i] <= B[j]){
                tmp[k++] = A[i++];
            }else {
                tmp[k++] = B[j++];
            }
        }
        System.arraycopy(tmp,0,A,0,tmp.length);
    }
}
